package com.mvp.ptrade.View.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 06/01/2017.
 */

public class ChangePassFragment extends Fragment {
    EditText pass, nPass, rPass;
    Button btnConfirm, btnCancel;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View _view = inflater.inflate(R.layout.fragment_changepassword, container, false);

        pass = (EditText) _view.findViewById(R.id.frag_changepass_pass);
        nPass = (EditText) _view.findViewById(R.id.frag_changepass_npass);
        rPass = (EditText) _view.findViewById(R.id.frag_changepass_rpass);
        btnConfirm = (Button) _view.findViewById(R.id.frag_changepass_btnconf);
        btnCancel = (Button) _view.findViewById(R.id.frag_changepass_btncncl);
        Log.d("deb", "change pass");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doChangeFragment(new ProfileFragment());
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return _view;
    }

    public void doChangeFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.frag_changePass, fragment).commit();
    }
}
