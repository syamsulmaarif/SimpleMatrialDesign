package com.caunk94.materialdesign222;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.caunk94.materialdesign222.Tab.SlidingTabLayout;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    DrawerLayout Drawer;                                  // Declaring DrawerLayout
    ActionBarDrawerToggle mDrawerToggle;

    private Drawer.Result navigationDrawerLeft;
    private AccountHeader.Result headerNavigationLeft;
    //First We Declare Titles And Icons For Our Navigation Drawer List View
    //This Icons And Titles Are holded in an Array as you can see

    String TITLES[] = {"Home","Events","Mail","Shop","Travel"};
    int ICONS[] = {R.drawable.ic_settings_system_daydream_black_48dp,
            R.drawable.ic_thumb_up_black_48dp,
            R.drawable.ic_com_azefsw_rageswipe,
            R.drawable.ic_pets_black_48dp,
            R.drawable.ic_person_black_24dp};

    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_com_azefsw_rageswipe);
        setSupportActionBar(toolbar);

        Intent myintent = getIntent();
        if (Intent.ACTION_SEARCH.equals(myintent.getAction())){
            String query = myintent.getStringExtra(SearchManager.QUERY);
            Toast.makeText(this, query , Toast.LENGTH_SHORT).show();
        }

        mViewPager=(ViewPager)findViewById(R.id.vp_tabs);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),this));

        mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.biruMuda));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.warnaAksen));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);
        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                navigationDrawerLeft.setSelection(position);
                switch (position){
                    case 0:
                        toolbar.setTitle("Fragment 1");
                        break;
                    case 1:
                        toolbar.setTitle("Fragment 2");
                        break;
                    case 2:
                        toolbar.setTitle("Fragment 3");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        headerNavigationLeft = new AccountHeader()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .withThreeSmallProfileImages(false)
                .withHeaderBackground(R.drawable._liverbird)
                .addProfiles(
                        new ProfileDrawerItem()
                        .withName("Syams")
                        .withEmail("Syammsul.maarif94@gmail.com")
                        .withIcon(getResources().getDrawable(R.mipmap.ming))
                ).build();
//list
        navigationDrawerLeft = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withDisplayBelowToolbar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withDrawerGravity(Gravity.LEFT)
                .withSavedInstance(savedInstanceState)
                .withAccountHeader(headerNavigationLeft)
                .withSelectedItem(0)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long l, IDrawerItem drawerItem) {
                        mViewPager.setCurrentItem(position);
                        toolbar.setTitle(((PrimaryDrawerItem)drawerItem).getName());
                    }
                })
                .build();

        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Fragment 1").withIcon(getResources().getDrawable(R.drawable.ic_com_azefsw_rageswipe)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Fragment 2").withIcon(getResources().getDrawable(R.drawable.gusta)));
        navigationDrawerLeft.addItem(new PrimaryDrawerItem().withName("Fragment 3").withIcon(getResources().getDrawable(R.drawable.trollface)));


    }




    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Keluar Aplikasi?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView)menu.findItem(R.id.item_search).getActionView();
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            Intent intent = new Intent("com.caunk94.materialdesign222.Main2Activity");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
