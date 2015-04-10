package sy.example.com.symerchandise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by JJIN on 15-01-28.
 */
public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button b = (Button) findViewById(R.id.but_newProduct);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewItemActivity.class);
                startActivity(i);
            }
        });

        Button b2 = (Button) findViewById(R.id.but_edit_product);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditItemActivity.class);
                startActivity(i);
            }
        });
    }

}
