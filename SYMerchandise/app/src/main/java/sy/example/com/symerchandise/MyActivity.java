package sy.example.com.symerchandise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sy.example.com.symerchandise.database.DbHandler;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        DbHandler dbHandler = new DbHandler(this);

        dbHandler.insertProduct("Product1", 30, 4.98);
        TextView view = (TextView) findViewById(R.id.text1);

        view.setText("insert");
        String name = dbHandler.find(1L, "product");
        view.setText(name);

        Button but_add = (Button) findViewById(R.id.but_add);
        Button but_sell = (Button) findViewById(R.id.but_sell);
        Button but_report = (Button) findViewById(R.id.but_report);


        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
