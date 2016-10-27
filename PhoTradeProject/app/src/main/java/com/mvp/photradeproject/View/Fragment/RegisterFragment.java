package com.mvp.photradeproject.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.photradeproject.R;
import com.mvp.photradeproject.View.Activity.AuthActivity;

/**
 * Created by Zackzack on 24/10/2016.
 */

public class RegisterFragment extends Fragment {
    EditText nama, email, password, repassword;
    TextView hasacctext;
    Button registerbtn;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View _view = inflater.inflate(R.layout.fragment_register, container, false);
        nama = (EditText) _view.findViewById(R.id.namatf);
        email = (EditText) _view.findViewById(R.id.emailtf);
        password = (EditText) _view.findViewById(R.id.passwordtf1);
        repassword = (EditText) _view.findViewById(R.id.passwordtf2);
        hasacctext = (TextView) _view.findViewById(R.id.hasacctext);
        context = getContext();
        registerpresenter = new RegisterPresenter(this);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nama.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(repassword.getText().toString())) {
                    Toast.makeText(context, "Please fill the blank fields.", Toast.LENGTH_SHORT).show();
                } else if (!password.getText().toString().equals(repassword.getText().toString())) {
                    Toast.makeText(context, "Password and Re-Password does not match.", Toast.LENGTH_SHORT).show();
                } else {
                    registerpresenter.doRegister(nama.getText().toString(), email.getText().toString(), password.getText().toString());
                }
            }
        });

        hasacctext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AuthActivity)getActivity()).doChangeFragment(new LoginFragment());

            }
        });

        return view;
    }

    public void doRegisterSuccess(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        ((AuthActivity)getActivity()).doChangeFragment(new LoginFragment());
    }

    @Override
    public void doRegisterFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doConnectionError(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
