package com.mvp.ptrade.Model.Adapter;

/**
 * Created by Zackzack on 18/12/2016.
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mvp.ptrade.View.Fragment.Tabs.InboxTabs.TabFragmentInbox;
import com.mvp.ptrade.View.Fragment.Tabs.InboxTabs.TabFragmentSend;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment1;
import com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs.TabFragment2;

public class InboxPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public InboxPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragmentInbox tab1 = new TabFragmentInbox();
                return tab1;
            case 1:
                TabFragmentSend tab2 = new TabFragmentSend();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

