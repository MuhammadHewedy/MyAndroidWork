package com.mhewedy.androidexamples;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search_action).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);

        if (searchManager != null && searchView != null){
            ComponentName componentName = getComponentName();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        }

        return true;
    }

}
