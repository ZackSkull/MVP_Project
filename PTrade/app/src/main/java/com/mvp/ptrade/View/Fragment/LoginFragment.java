package com.mvp.ptrade.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.ptrade.Model.Responses.UserResponse;
import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.Presenter.Auth.LoginPresenter;
import com.mvp.ptrade.Presenter.iPresenterUserResponse;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.AuthActivity;
import com.mvp.ptrade.View.Activity.MainActivity;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class LoginFragment extends Fragment implements iPresenterUserResponse {

    TextView txtredirectregister;
    EditText txtemail, txtpassword;
    Button btnlogin;

    SessionManager sessionManager;
    Context context;
    LoginPresenter loginpresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_login, container, false);

        txtredirectregister = (TextView) _view.findViewById(R.id.login_txtregister);
        txtemail    = (EditText) _view.findViewById(R.id.login_txtemail);
        txtpassword = (EditText) _view.findViewById(R.id.login_txtpassword);
        btnlogin    = (Button) _view.findViewById(R.id.login_loginbtn);

        context = getContext();
        sessionManager = new SessionManager(context);
        loginpresenter = new LoginPresenter(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //percobaan tanpa login
                AuthActivity.doChangeActivity(context, MainActivity.class);
                //loginpresenter.doLogin(txtemail.getText().toString(), txtpassword.getText().toString());
            }
        });

        txtredirectregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AuthActivity)getActivity()).doChangeFragment(new RegisterFragment());
            }
        });

        return _view;
    }

    @Override
    public void doSuccess(UserResponse userResponse) {
        sessionManager.doCreateSession(userResponse.getUser());
        Toast.makeText(context, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
        AuthActivity.doChangeActivity(context, MainActivity.class);
    }

    @Override
    public void doFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doConnectionError(int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
