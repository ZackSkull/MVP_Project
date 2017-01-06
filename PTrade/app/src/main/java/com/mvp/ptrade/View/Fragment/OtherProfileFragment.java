package com.mvp.ptrade.View.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.MainActivity;
import com.mvp.ptrade.View.Activity.ProfileActivity;

/**
 * Created by Zackzack on 20/12/2016.
 */

public class OtherProfileFragment extends Fragment{
    EditText username,email,city,address,phone,bio;
    TextView name;
    Spinner gender;
    Context context;
    Button close, btnmsg;
    private String[] array_spinner;
    SessionManager sessionManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View _view = inflater.inflate(R.layout.fragment_profile, container, false);

        name = (TextView) _view.findViewById(R.id.frag_opro_name);
        email = (EditText) _view.findViewById(R.id.frag_opro_email);
        city = (EditText) _view.findViewById(R.id.frag_opro_kota);
        address = (EditText) _view.findViewById(R.id.frag_opro_address);
        phone = (EditText) _view.findViewById(R.id.frag_opro_phone);
        bio = (EditText) _view.findViewById(R.id.frag_opro_bio);
        gender = (Spinner) _view.findViewById(R.id.frag_opro_spinner_gender);
        name.setKeyListener(null);
        email.setKeyListener(null);
        city.setKeyListener(null);
        address.setKeyListener(null);
        phone.setKeyListener(null);
        bio.setKeyListener(null);
        close = (Button) _view.findViewById(R.id.frag_opro_btnclose);
        btnmsg = (Button) _view.findViewById(R.id.frag_opro_btnmsg);

        context = getContext();
        sessionManager = new SessionManager(context);

        //spinner items
        this.array_spinner = new String[]{
                "Pria","Wanita"
        };
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(_view.getContext(),android.R.layout.simple_spinner_item,array_spinner);
        gender.setEnabled(false);
        gender.setClickable(false);
        gender.setAdapter(spinneradapter);


        settext();

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileActivity.doChangeActivity(context, MainActivity.class);
            }
        });

        return _view;
    }
    private void settext(){
        name.setText("");
        username.setText("");
        email.setText("");
        city.setText("");
        address.setText("");
        phone.setText("");
        bio.setText("");
        gender.setSelection(0);
    }

    public void doChangeFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.frag_pro, fragment).commit();
    }
}
