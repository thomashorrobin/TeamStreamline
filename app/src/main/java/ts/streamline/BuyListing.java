package ts.streamline;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtworks.xstream.XStream;

import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;


public class BuyListing extends Activity {

    static TextView text;
    static ImageView image;
    static ListedItemDetail item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_listing);
        image = (ImageView) findViewById(R.id.imageView);
        text = (TextView) findViewById(R.id.textView);
        getListing();
        text.append(item.Title+"\n");
        text.append("Price: "+item.PriceDisplay+"\n");
        text.append(item.Body);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buy_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getListing() {
        try {
           connect("http://api.trademe.co.nz/v1/Listings/779720530.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*Method from http://stackoverflow.com/questions/4457492/how-do-i-use-the-simple-http-client-in-android*/
    public static void connect(String url) {
        HttpClient httpclient = new DefaultHttpClient();

        // Prepare a request object
        HttpGet httpget = new HttpGet(url);

        // Execute the request
        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
           item = xstreamConversion(getResponseBody(response));
        } catch (Exception e) {
            Log.i("Crystal ERROR", "Here "+e);
        }
    }

    /*Methods from http://thinkandroid.wordpress.com/2009/12/30/getting-response-body-of-httpresponse/*/
    public static String getResponseBody(HttpResponse response) {

        String response_text = null;

        HttpEntity entity = null;

            entity = response.getEntity();

        try {
            response_text = _getResponseBody(entity);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return response_text;

    }
    /*Methods from http://thinkandroid.wordpress.com/2009/12/30/getting-response-body-of-httpresponse/*/
    public static String _getResponseBody(final HttpEntity entity) throws IOException, ParseException {

        if (entity == null) { throw new IllegalArgumentException("HTTP entity may not be null"); }

        InputStream instream = entity.getContent();

        if (instream == null) { return ""; }

        if (entity.getContentLength() > Integer.MAX_VALUE) { throw new IllegalArgumentException(

                "HTTP entity too large to be buffered in memory"); }

        String charset = getContentCharSet(entity);

        if (charset == null) {

            charset = HTTP.DEFAULT_CONTENT_CHARSET;

        }

        Reader reader = new InputStreamReader(instream, charset);

        StringBuilder buffer = new StringBuilder();

        try {

            char[] tmp = new char[1024];

            int l;

            while ((l = reader.read(tmp)) != -1) {

                buffer.append(tmp, 0, l);

            }

        } finally {

            reader.close();

        }

        return buffer.toString();

    }

    public static String getContentCharSet(final HttpEntity entity) throws ParseException {

        if (entity == null) { throw new IllegalArgumentException("HTTP entity may not be null"); }

        String charset = null;

        if (entity.getContentType() != null) {

            HeaderElement values[] = entity.getContentType().getElements();

            if (values.length > 0) {

                NameValuePair param = values[0].getParameterByName("charset");

                if (param != null) {

                    charset = param.getValue();

                }

            }

        }

        return charset;

    }

    public static ListedItemDetail xstreamConversion(String xml){
        XStream xstream = new XStream();
        xstream.alias("ListedItemDetail",ListedItemDetail.class);
        xstream.alias("Attribute", Attribute.class);
        xstream.alias("Bid", Bid.class);
        xstream.alias("Question", Question.class);
        xstream.alias("Address", Address.class);
        xstream.alias("Agency", Agency.class);
        xstream.alias("Agent", Agent.class);
        xstream.alias("BidCollection", BidCollection.class);
        xstream.alias("Charity", Charity.class);
        xstream.alias("ContactDetails", ContactDetails.class);
        xstream.alias("Dealer", Dealer.class);
        xstream.alias("Dealership", Dealership.class);
        xstream.alias("FixedPriceOfferDetails", FixedPriceOfferDetails.class);
        xstream.alias("FixedPriceOfferRecipient", FixedPriceOfferRecipient.class);
        xstream.alias("GeographicLocation", GeographicLocation.class);
        xstream.alias("Member", Member.class);
        xstream.alias("Photo", Photo.class);
        xstream.alias("PhotoUrl", PhotoURL.class);
        xstream.alias("PromotionResponse", PromotionResponse.class);
        xstream.alias("Questions", Questions.class);
        xstream.alias("Sale", Sale.class);
        xstream.alias("ShippingOption", ShippingOption.class);
        xstream.ignoreUnknownElements();
        return (ListedItemDetail)xstream.fromXML(xml);
    }



}