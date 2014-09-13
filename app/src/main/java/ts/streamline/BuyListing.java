package ts.streamline;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class BuyListing extends Activity {


    ImageView preview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_listing);
        getListing();
    }

    public void open(View v ){
        getListing();
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

    public void getListing(){
        try {
           /* HttpResponse<JsonNode> jsonResponse = Unirest.post("http://api.trademe.co.nz/v1/Listings/{listingId}.{file_format}")
                    .header("accept", "application/json")
                    .routeParam("listingId", "779720530")
                    .routeParam("file_format", "json")
                    .asJson();*/
            System.out.print("hi");
         // System.out.print(jsonResponse);
            System.out.print("hi");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
