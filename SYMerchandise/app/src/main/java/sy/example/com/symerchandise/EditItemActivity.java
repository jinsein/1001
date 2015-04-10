package sy.example.com.symerchandise;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by youngwookyoo on 2015-04-09.
 */
public class EditItemActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        ArrayList<String> product_names = new ArrayList<String>();
        product_names.add("coke");
        product_names.add("pepsi");
        product_names.add("chocolate");
        product_names.add("chicken");
        product_names.add("youngwook");
        product_names.add("burger king");

       // String search_text = ((TextView) findViewById(R.id.edit_search)).getText().toString();

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) findViewById(R.id.search_product);
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));


        if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
            String query = getIntent().getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }


    }
}
