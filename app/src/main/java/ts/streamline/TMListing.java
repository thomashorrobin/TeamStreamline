package ts.streamline;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.thoughtworks.xstream.XStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class TMListing extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmlisting);
        tv = (TextView)findViewById(R.id.textview);
        XStream stream = new XStream();
        SearchResult sr = null;
        try {
            URL url = new URL("https://touch.trademe.co.nz/api/v1/Search/General.xml?search_string=macbook&category=0&page=1&rows=25&return_metadata=true");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String xml = in.readLine();
            sr = (SearchResult) stream.fromXML(xml);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sr != null){
            for(Listing l: sr.getList()){
                tv.append(l.getTitle() + "\n");
            }
        }
    }

    public static void main(String[] args){
        XStream stream = new XStream();
        SearchResult sr = null;
        try {
            URL url = new URL("https://touch.trademe.co.nz/api/v1/Search/General.xml?search_string=macbook&category=0&page=1&rows=25&return_metadata=true");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String xml = in.readLine();
            sr = (SearchResult) stream.fromXML(xml);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(sr != null){
            for(Listing l: sr.getList()){
                System.out.println(l.getTitle());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tmlisting, menu);
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
}
