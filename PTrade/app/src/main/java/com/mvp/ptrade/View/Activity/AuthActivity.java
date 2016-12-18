package com.mvp.ptrade.View.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Fragment.LoginFragment;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class AuthActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        doChangeFragment(new LoginFragment());
    }

    public void doChangeFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_auth, fragment).commit();
    }
}
