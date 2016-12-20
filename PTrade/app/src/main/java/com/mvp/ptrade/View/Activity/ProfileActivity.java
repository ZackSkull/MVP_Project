package com.mvp.ptrade.View.Activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Fragment.ProfileFragment;

public class ProfileActivity extends ParentActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        context = getApplicationContext();
        doChangeFragment(new ProfileFragment());
    }
    @Override
    public void onBackPressed() {
        doChangeActivity(context, MainActivity.class);
    }

    public void doChangeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_profile, fragment).commit();
    }
}
