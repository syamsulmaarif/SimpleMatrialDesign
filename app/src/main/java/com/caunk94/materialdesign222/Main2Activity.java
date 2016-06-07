package com.caunk94.materialdesign222;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends ActionBarActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        toolbar= (Toolbar) findViewById(R.id.toolbar_setting);
        toolbar.setLogo(R.drawable.ic_com_azefsw_rageswipe);
        toolbar.setTitle("About");
        toolbar.setSubtitle("Creator");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){ //untuk kembali ke home
            finish();
        }

        return true;
    }
}
