package com.mvp.ptrade.Model.Basic;


import android.support.v4.app.Fragment;

/**
 * Created by Zackzack on 23/12/2016.
 */

public class FragmentListThread {
    private Fragment fragment;
    private String title;

    public FragmentListThread(Fragment frag, String string){
        fragment = frag;
        title = string;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
