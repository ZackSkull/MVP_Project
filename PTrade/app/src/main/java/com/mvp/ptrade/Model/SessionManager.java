package com.mvp.ptrade.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.mvp.ptrade.Model.Basic.User;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class SessionManager {
    SharedPreferences sharedprf;
    SharedPreferences.Editor editor;

    Context context;

    private final int PRIVATEMODE = 0;

    public static final String PREFNAME       = "UserSession";
    public static final String KEYISPREFLOGIN = "isUserLogin";
    public static final String KEYUSERDATA    = "UserDatas";

    public SessionManager (Context context) {
        this.context = context;
        sharedprf = context.getSharedPreferences(PREFNAME, PRIVATEMODE);
        editor = sharedprf.edit();
    }

    public void doCreateSession (User user) {
        editor.putBoolean(KEYISPREFLOGIN, true);
        editor.putString(KEYUSERDATA, new Gson().toJson(user));
        editor.commit();
    }

    public boolean isUserLoggedIn () {
        return sharedprf.getBoolean(KEYISPREFLOGIN, false);
    }

    public User getUserLoggedIn () {
        User user = new Gson().fromJson(sharedprf.getString(KEYUSERDATA, ""), User.class);
        return user;
    }

    public void doClearSession () {
        editor.clear();
        editor.commit();
    }

}
