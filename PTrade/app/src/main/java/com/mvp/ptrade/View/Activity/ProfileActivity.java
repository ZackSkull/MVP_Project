package com.mvp.ptrade.View.Activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Fragment.ProfileFragment;

public class ProfileActivity extends ParentActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = getApplicationContext();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        doChangeFragment(new ProfileFragment());
    }
    @Override
    public void onBackPressed() {
        doChangeActivity(context, MainActivity.class);
    }

    public void doChangeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //View decorview = getWindow().getDecorView();
                //decorview.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_FULLSCREEN);
                onBackPressed();
                return true;
            case R.id.autenticationmenu:
                doChangeActivity(context, AuthActivity.class);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
