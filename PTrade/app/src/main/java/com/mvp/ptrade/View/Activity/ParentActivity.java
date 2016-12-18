package com.mvp.ptrade.View.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class ParentActivity extends AppCompatActivity {
    public static void doChangeActivity (Context context, Class activityClass) {
        Intent _intent = new Intent(context, activityClass);
        _intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(_intent);
    }
}
