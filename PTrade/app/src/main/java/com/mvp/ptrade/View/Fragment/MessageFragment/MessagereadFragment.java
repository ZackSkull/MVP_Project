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

public class MessagereadFragment extends Fragment {
    EditText reciever, subject, msg;
    Button close;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.message_read_send, container, false);
        reciever = (EditText) _view.findViewById(R.id.msgread_reciever);
        subject = (EditText) _view.findViewById(R.id.msgread_subject);
        msg = (EditText) _view.findViewById(R.id.msgread_msg);
        close = (Button) _view.findViewById(R.id.msgread_btnclose);


        return _view;
    }
}