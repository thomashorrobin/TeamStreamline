package ts.streamline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class DataPage extends Activity {

    DataPage dp = this;
    String query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        query = bundle.getString("query");
        setContentView(R.layout.activity_data_page);
        ((ImageButton)findViewById(R.id.btnVl)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchSearch = new Intent(dp, SearchResult.class);
                launchSearch.putExtra("query", query);
                startActivity(launchSearch);
            }
        });
        ((ImageButton)findViewById(R.id.btnList)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent launchSearch = new Intent(dp, SellPage.class);
                startActivity(launchSearch);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data_page, menu);
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
