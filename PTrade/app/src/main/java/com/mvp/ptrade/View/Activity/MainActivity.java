package com.mvp.ptrade.View.Activity;

import android.content.Context;
import android.content.res.Configuration;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Fragment.Tabs.InboxTabs.MailViewPagerFragment;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.ThreadViewPagerFragment;

public class MainActivity extends ParentActivity{
    Context context;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ImageView nav_profile_pic;
    NavigationView navigation;
    SessionManager sessionManager;
    TextView name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = getApplicationContext();
        sessionManager = new SessionManager(context);

        //ViewPager
        doChangeContentFragment(new ThreadViewPagerFragment());

        //Navigation
        initInstancesNavigation();


        if (!sessionManager.isUserLoggedIn()) {
            this.doChangeActivity(context, AuthActivity.class);
        } else {
            if (sessionManager.getUserLoggedIn() == null) {
                sessionManager.doClearSession();
                this.doChangeActivity(context, AuthActivity.class);
            }
            else {
                email.setText(sessionManager.getUserLoggedIn().getEmail());
                name.setText(sessionManager.getUserLoggedIn().getName());
            }
        }
    }

    private void initInstancesNavigation() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);

        navigation = (NavigationView) findViewById(R.id.navigation_view);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.main:
                        doChangeContentFragment(new ThreadViewPagerFragment());
//                        Toast.makeText(context, R.string.main, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_2:
                        Toast.makeText(context, R.string.navigation_view_item_2, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_item_mail:
                        doChangeContentFragment(new MailViewPagerFragment());
//                        doChangeActivity(context, InboxActivity.class);
//                        Toast.makeText(context, R.string.Inbox, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_4:
                        Toast.makeText(context, R.string.navigation_view_item_4, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_logout:
                        sessionManager.doClearSession();
                        if (!sessionManager.isUserLoggedIn()) {
                            doChangeActivity(context, AuthActivity.class);
                        }
                        break;
                }
                return false;
            }
        });
        name = (TextView) navigation.getHeaderView(0).findViewById(R.id.nav_header_name);
        email = (TextView) navigation.getHeaderView(0).findViewById(R.id.nav_header_email);
        nav_profile_pic = (ImageView) navigation.getHeaderView(0).findViewById(R.id.nav_profile_pic);
        nav_profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doChangeActivity(context,ProfileActivity.class);
            }
        });

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:

                return true;
            case android.R.id.home:
                //View decorview = getWindow().getDecorView();
                //decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN);
                //onBackPressed();
                return true;
//            case R.id.autenticationmenu:
//                doChangeActivity(context, AuthActivity.class);
//                return true;
            case R.id.nav_logout:
                sessionManager.doClearSession();
                if (!sessionManager.isUserLoggedIn()) {
                    this.doChangeActivity(context, AuthActivity.class);
                }
        }

        return super.onOptionsItemSelected(item);
    }

    public void doChangeContentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.contentlayout, fragment).commit();
    }
}
