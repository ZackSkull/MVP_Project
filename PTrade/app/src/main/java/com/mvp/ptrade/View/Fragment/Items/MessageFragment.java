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
 * Created by Zackzack on 19/12/2016.
 */

public class MessageFragment extends Fragment {
    ImageView profileimg;
    TextView name,date,msg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.item_message, container, false);
        name = (TextView) view.findViewById(R.id.msgitem_textname);
        date = (TextView) view.findViewById(R.id.msgitem_textdate);
        msg = (TextView) view.findViewById(R.id.msgitem_textmessage);
        profileimg = (ImageView) view.findViewById(R.id.msgitem_propic);

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
