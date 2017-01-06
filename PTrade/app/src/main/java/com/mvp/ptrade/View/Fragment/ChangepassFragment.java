package com.mvp.ptrade.View.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mvp.ptrade.R;

/**
 * Created by Zackzack on 06/01/2017.
 */

public class ChangepassFragment extends Fragment {
    EditText pass, npass,rpass;
    Button btnconfirm, btncancle;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View _view = inflater.inflate(R.layout.fragment_profile, container, false);
        pass = (EditText) _view.findViewById(R.id.frag_changepass_pass);
        rpass = (EditText) _view.findViewById(R.id.frag_changepass_npass);
        npass = (EditText) _view.findViewById(R.id.frag_changepass_rpass);
        btnconfirm = (Button) _view.findViewById(R.id.frag_changepass_btnconf);
        btncancle = (Button) _view.findViewById(R.id.frag_changepass_btncncl);

        btncancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doChangeFragment(new ProfileFragment());
            }
        });
        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return _view;
    }

    public void doChangeFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.frag_changepass, fragment).commit();
    }
}
