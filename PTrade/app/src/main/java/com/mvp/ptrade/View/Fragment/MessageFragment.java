package com.mvp.ptrade.View.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class MessageFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.messageitem, container, false);

//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//        fm.beginTransaction();
//        Fragment fragment = new MessageFragment();
//        Bundle arguments = new Bundle();
//        arguments.putBoolean("argumen", false);
//        fragment.setArguments(arguments);
//        ft.add(R.id.msg_frag_content,fragment);
//        ft.commit();

        return layout;
    }
}
