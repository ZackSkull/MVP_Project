package com.mvp.ptrade.Model.Adapter;

/**
 * Created by Zackzack on 18/12/2016.
 */


import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mvp.ptrade.Model.Basic.FragmentListThread;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment1;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment2;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment3;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends FragmentPagerAdapter {
    private List<FragmentListThread> fragments;
    public MainPageAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(FragmentListThread flt) {
        fragments.add(flt);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}

