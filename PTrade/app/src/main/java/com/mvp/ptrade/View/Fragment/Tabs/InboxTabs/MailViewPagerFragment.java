package com.mvp.ptrade.View.Fragment.Tabs.InboxTabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.ptrade.Model.Adapter.InboxPageAdapter;
import com.mvp.ptrade.Model.Adapter.PageAdapter;
import com.mvp.ptrade.Model.Basic.FragmentListThread;
import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 04/01/2017.
 */

public class MailViewPagerFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View _view = inflater.inflate(R.layout.fragment_thread_viewpager, container, false);

        TabLayout tabLayout = (TabLayout) _view.findViewById(R.id.tab_layout);
//        tabLayout.addTab(tabLayout.newTab().setText("Inbox"));
//        tabLayout.addTab(tabLayout.newTab().setText("Send"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) _view.findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter(getFragmentManager());
        adapter.addFragment(new FragmentListThread(new TabFragmentInbox(), "Inbox"));
        adapter.addFragment(new FragmentListThread(new TabFragmentSend(), "Send"));
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return _view;
    }
}
