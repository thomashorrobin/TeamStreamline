package ts.streamline;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
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
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * First page the user sees, helps them take a picture
 */
public class LandingPage extends Activity {

    static final int REQUEST_TAKE_PHOTO = 1;//This code is used so we know when it's returning an image
    ImageView preview;
    TextView guessText;
    File iFile;
    boolean imageSet = false;
    boolean guessMade = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        preview = (ImageView)findViewById(R.id.previewImg);
        guessText = (TextView)findViewById(R.id.guessText);
        dispatchTakePictureIntent();
    }

    String mCurrentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
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

    public void dispText(String s){
        guessText.setText(s);
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
     * A picture has been taken
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Log.i("SL", "File saved");
            Bitmap bmp = BitmapFactory.decodeFile(iFile.getAbsolutePath());
            preview.setImageBitmap(Bitmap.createScaledBitmap(bmp, 1024, (int)(1024*bmp.getWidth()/bmp.getHeight()), false));
            imageSet = true;

            guessText.setText("Uploading");
            SendImageTask nt = new SendImageTask();
            nt.execute();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       return (id == R.id.action_settings)|| super.onOptionsItemSelected(item);
    }

    class SendImageTask extends AsyncTask<String, Void, String> {

        private Exception exception;
        String name;

        protected String doInBackground(String... filePath) {
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
                String token = matcher.group(1);

                Log.i("SL", token);

                Thread.sleep(11000);

                requestHeaders = new HttpHeaders();
                requestHeaders.set("X-Mashape-Key", "sPsf3HHRaImshDvA64Him0jITDGxp1YeFqGjsnpxa2EgUvXWhV");
                String url = "https://camfind.p.mashape.com/image_responses/"+token;
                restTemplate = new RestTemplate();
                message = new LinkedMultiValueMap<String, Object>();
                requestEntity = new HttpEntity<MultiValueMap<String, Object>>(
                        message, requestHeaders);
                response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
                Log.i("SL", response.toString());

                Pattern pattern2 = Pattern.compile(".*\"name\":\"([^\"]*)\".*");
                Matcher matcher2 = pattern2.matcher(response.getBody());
                matcher2.find();
                name = matcher2.group(1);
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
            dispText(name);
        }
    }
}
