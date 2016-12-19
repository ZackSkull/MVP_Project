package com.mvp.ptrade.Model.Adapter;

/**
 * Created by Zackzack on 18/12/2016.
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment1;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment2;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment3;

public class MainPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MainPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();
                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

