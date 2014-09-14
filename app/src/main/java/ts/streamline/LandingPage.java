package ts.streamline;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * First page the user sees, helps them take a picture and displays the output
 */
public class LandingPage extends Activity {

    static final int REQUEST_TAKE_PHOTO = 1;//This code is used so we know when it's returning an image
    ImageView preview;
    TextView guessText;
    File iFile;
    String result = null;
    String mCurrentPhotoPath;
    ProgressBar waitSpinner;
    Typeface museo;
    final LandingPage lp = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        preview = (ImageView)findViewById(R.id.previewImg);
        guessText = (TextView)findViewById(R.id.guessText);
        waitSpinner = (ProgressBar)findViewById(R.id.waitSpinner);
        museo = Typeface.createFromAsset(getAssets(), "fonts/Museo500-Regular.otf");
        guessText.setTypeface(museo);
        ((ImageButton)findViewById(R.id.btnRetake)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });
        ((ImageButton)findViewById(R.id.btnProcess)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchSearch = new Intent(lp, DataPage.class);
                launchSearch.putExtra("query", result);
                startActivity(launchSearch);
            }
        });


        dispatchTakePictureIntent();
    }

    /*
     * Creates a blank image file prefixed by the date to write to later
     */
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new DateTime());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        Log.i("SL", "File made");
        return image;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.landing_page, menu);
        return true;
    }

    /*
     * Displays text and spinner status onscreen
     */
    public void dispStatus(String s, boolean b){
        guessText.setText(s);
        waitSpinner.setVisibility((b) ? View.VISIBLE : View.INVISIBLE);
    }

    public void setResult(String s){
        result = s;
        if(s==null){dispStatus("No results, try again",false);}
    }

    /*
     * Tells the phone's camera app to take a picture
     */
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                // Create the File where the photo should go
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {
                    // Error occurred while creating the File
                    return;
                }
                // Continue only if the File was successfully created
                if (photoFile != null) {
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile));
                    iFile = photoFile;
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                }
        }
    }

    /*
     * A picture has been taken, display onscreen
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Log.i("SL", "File saved");
            Bitmap bmp = BitmapFactory.decodeFile(iFile.getAbsolutePath());
            double scale = 1;
            int w = bmp.getWidth();
            int h = bmp.getHeight();
            //Scale down so it works on phones
            if(w>2048||h>2048){
                scale = 2048.0/Math.max(w,h);
            }
            bmp = Bitmap.createScaledBitmap(bmp, (int)(w*scale), (int)(h*scale), false);
            preview.setRotation(90);
            preview.setImageBitmap(bmp);

            dispStatus("Uploading", true);
            SendImageTask nt = new SendImageTask();
            nt.execute();
        }
    }

    //Callback after image submitted
    public void getRes(String token){
        dispStatus("Processing",true);
        GetGuess gg = new GetGuess(token);
        gg.execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       return (id == R.id.action_settings)|| super.onOptionsItemSelected(item);
    }

    /*
     * Submit an image to the api, get back the token
     */
    class SendImageTask extends AsyncTask<String, Void, String> {

        private Exception exception;
        String token;

        protected String doInBackground(String... filePath) {
            String token;
            try {
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.set("X-Mashape-Key", "sPsf3HHRaImshDvA64Him0jITDGxp1YeFqGjsnpxa2EgUvXWhV");
                MultiValueMap<String, Object> message = new LinkedMultiValueMap<String, Object>();
                message.add("image_request[image]", new FileSystemResource(iFile.getPath())); //attach file
                message.add("image_request[locale]", "en_NZ");
                HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
                        message, requestHeaders);
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.exchange("https://camfind.p.mashape.com/image_requests", HttpMethod.POST, requestEntity, String.class);
                Log.i("SL",response.getBody());

                final Pattern pattern = Pattern.compile(".*\"token\":\"([^\"]*)\".*");
                final Matcher matcher = pattern.matcher(response.getBody());
                matcher.find();
                token = matcher.group(1);

                return token;
            } catch (Exception e) {
                Log.i("SL",e.getMessage()+","+e.getCause());
                this.exception = e;
                return null;
            }
        }
        @Override
        protected void onPostExecute(String s) {
            getRes(s);
        }
    }

    /*
     * Use the token to fetch a guess as to what the image is
     */
    class GetGuess extends AsyncTask<String, Void, String> {

        private Exception exception;
        String name;
        String token;

        public GetGuess(String t){
            token = t;
        }

        protected String doInBackground(String... filePath) {
            try {
                Thread.sleep(11000);//This is high, add delay so api is ready with result
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.set("X-Mashape-Key", "sPsf3HHRaImshDvA64Him0jITDGxp1YeFqGjsnpxa2EgUvXWhV");
                String url = "https://camfind.p.mashape.com/image_responses/"+token;
                RestTemplate restTemplate = new RestTemplate();
                MultiValueMap<String, Object> message = new LinkedMultiValueMap<String, Object>();
                HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
                        message, requestHeaders);
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
                Log.i("SL", response.toString());

                Pattern pattern = Pattern.compile(".*\"name\":\"([^\"]*)\".*");
                Matcher matcher = pattern.matcher(response.getBody());
                matcher.find();
                name = matcher.group(1);
                Log.i("SL",name);
                return name;
            } catch (Exception e) {
                Log.i("SL",e.getMessage()+","+e.getCause());
                this.exception = e;
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            dispStatus(name, false);
            setResult(s);
        }
    }


}
