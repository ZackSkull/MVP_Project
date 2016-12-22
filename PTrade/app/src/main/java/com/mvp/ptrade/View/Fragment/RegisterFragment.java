package com.mvp.ptrade.View.Fragment;

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

import com.mvp.ptrade.Model.Responses.UserResponse;
import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.Presenter.Auth.RegisterPresenter;
import com.mvp.ptrade.Presenter.iPresenterUserResponse;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.AuthActivity;
import com.mvp.ptrade.View.Activity.MainActivity;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class RegisterFragment extends Fragment implements iPresenterUserResponse {
    EditText username, email, password, repassword;
    TextView txtlogin;
    Button registerbtn;

    SessionManager sessionManager;
    Context context;
    RegisterPresenter registerpresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View _view = inflater.inflate(R.layout.fragment_register, container, false);
        username = (EditText) _view.findViewById(R.id.regis_txtusername);
        email = (EditText) _view.findViewById(R.id.regis_txtemail);
        password = (EditText) _view.findViewById(R.id.regis_txtpassword1);
        repassword = (EditText) _view.findViewById(R.id.regis_txtpassword2);
        txtlogin = (TextView) _view.findViewById(R.id.regis_txtlogin);
        registerbtn = (Button) _view.findViewById(R.id.regis_registerbtn);

        context = getContext();
        sessionManager = new SessionManager(context);
        registerpresenter = new RegisterPresenter(this);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString()) || TextUtils.isEmpty(repassword.getText().toString())) {
                    Toast.makeText(context, "Please fill the blank fields.", Toast.LENGTH_SHORT).show();
                } else if (!password.getText().toString().equals(repassword.getText().toString())) {
                    Toast.makeText(context, "Password and Re-Password does not match.", Toast.LENGTH_SHORT).show();
                } else {
                    registerpresenter.doRegister(username.getText().toString(), email.getText().toString(), password.getText().toString());
                }
            }
        });

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AuthActivity) getActivity()).doChangeFragment(new LoginFragment());
            }
        });

        return _view;
    }

    public void doSuccess(UserResponse userResponse) {
        sessionManager.doCreateSession(userResponse.getUser());
        Toast.makeText(context, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
        AuthActivity.doChangeActivity(context, MainActivity.class);
    }

    public void doFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void doConnectionError(int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}