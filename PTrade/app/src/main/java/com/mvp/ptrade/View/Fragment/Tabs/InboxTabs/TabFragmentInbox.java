package com.mvp.ptrade.View.Fragment.Tabs.InboxTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Fragment.MessageFragment;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class TabFragmentInbox extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.message_inbox_fragment, container, false);

        //ListView listView = (ListView) _view.findViewById(R.id.msg_list);


//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        fm.beginTransaction();
//        Fragment fragment = new MessageFragment();
//        Bundle arguments = new Bundle();
//        arguments.putBoolean("argumen", false);
//        fragment.setArguments(arguments);
//        ft.add(R.id.msg_frag_container,fragment);
//        ft.commit();

        return _view;
    }
}
