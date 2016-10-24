package com.mvp.photradeproject.View.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvp.photradeproject.R;
import com.mvp.photradeproject.View.Fragment.LoginFragment;

public class AuthActivity extends AppCompatActivity {

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
