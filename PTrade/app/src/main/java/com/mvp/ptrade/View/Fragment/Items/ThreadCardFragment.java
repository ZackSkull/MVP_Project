package com.mvp.ptrade.View.Fragment.Items;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 22/12/2016.
 */

public class ThreadCardFragment extends Fragment {
    ImageView threadimg;
    TextView name,desc;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.item_thread, container, false);
        name = (TextView) view.findViewById(R.id.trditem_textname);
        desc = (TextView) view.findViewById(R.id.trditem_textdesc);
        threadimg = (ImageView) view.findViewById(R.id.trditem_pic);

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

        return view;
    }
}