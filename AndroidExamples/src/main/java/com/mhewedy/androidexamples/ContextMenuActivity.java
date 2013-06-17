package com.mhewedy.androidexamples;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.mhewedy.androidexamples.model.RecentManager;

import java.util.ArrayList;
import java.util.List;

public class ContextMenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        handleIntent(getIntent());

        List<String> listAdapterData = new ArrayList<String>(RecentManager.getRecentManager()
                .getAllRecents());
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                listAdapterData));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    void handleIntent(Intent intent) {
        if (intent.getAction() == Intent.ACTION_SEARCH) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            RecentManager.getRecentManager().addRecent(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
