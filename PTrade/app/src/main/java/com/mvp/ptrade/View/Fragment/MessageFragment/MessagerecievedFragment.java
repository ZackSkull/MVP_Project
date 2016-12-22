package com.mvp.ptrade.View.Fragment.MessageFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 22/12/2016.
 */

public class MessagerecievedFragment extends Fragment {
    EditText sender, subject, msg;
    Button close, replay;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.message_recieved, container, false);
        sender = (EditText) _view.findViewById(R.id.msgrec_sender);
        subject = (EditText) _view.findViewById(R.id.msgrec_subject);
        msg = (EditText) _view.findViewById(R.id.msgrec_msg);
        close = (Button) _view.findViewById(R.id.msgrec_btnclose);
        replay = (Button) _view.findViewById(R.id.msgrec_btnreplay);


        return _view;
    }
}
