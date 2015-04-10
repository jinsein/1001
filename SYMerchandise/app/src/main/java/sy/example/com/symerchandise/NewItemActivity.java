package sy.example.com.symerchandise;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sy.example.com.util.AlertNotifier;

/**
 * Created by JJIN on 15-01-28.
 */
public class NewItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newitem);

        Button but_submit = (Button) findViewById(R.id.submit_new);


        but_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validate fields
                String productName = ((EditText)findViewById(R.id.new_product_name)).getText().toString();
                String priceInString = ((EditText)findViewById(R.id.new_product_price)).getText().toString();
                String quantityInString = ((EditText)findViewById(R.id.new_product_quantity)).getText().toString();

                if (productName.equals("") || priceInString.equals("") || quantityInString.equals("")){
                    Log.i("add", "alert message");
                    //Alert!

                    AlertNotifier.alertContent(NewItemActivity.this, "Warning", "All fields are required");
                }else{
                    Log.i("add", "Quantity" + quantityInString);

                    // add it to db
                    double price = Double.parseDouble(priceInString);
                    int quantity = Integer.parseInt(quantityInString);

                    Intent intent = new Intent(getApplicationContext(), MyActivity.class);
                    startActivity(intent);
                }


            }
        });
    }


}
