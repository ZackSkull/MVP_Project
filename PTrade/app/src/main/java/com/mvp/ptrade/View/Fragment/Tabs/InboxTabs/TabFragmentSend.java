package com.mvp.ptrade.View.Fragment.Tabs.InboxTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class TabFragmentSend extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_send_fragment, container, false);
    }
}
