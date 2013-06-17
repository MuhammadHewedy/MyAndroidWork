package com.mhewedy.androidexamples;

import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Example on Option Menu lifecycle with Non-functional Search View
 */
public class MainActivity extends Activity {

    static int counter;

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

        if (searchManager != null && searchView != null) {
            ComponentName componentName = getComponentName();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.create_new:
            case R.id.search_action:
                makeToast("Supported: " + item.getTitle());
                return true;
            default:
                makeToast("UnSupported: " + item.getTitle());
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu  (menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search_action).getActionView();
        int colorVal = counter++ * 100 %265;
        searchView.setBackgroundColor(Color.rgb(colorVal, colorVal, colorVal));

        return true;
    }

    void makeToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
