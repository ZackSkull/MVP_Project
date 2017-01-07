package com.mvp.ptrade.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp.ptrade.Model.Basic.User;
import com.mvp.ptrade.Model.Responses.UserResponse;
import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.Presenter.User.ProfilePresenter;
import com.mvp.ptrade.Presenter.iPresenterUserResponse;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.ProfileActivity;

/**
 * Created by Zackzack on 06/01/2017.
 */

public class ChangePassFragment extends Fragment implements iPresenterUserResponse {
    EditText pass, nPass, rPass;
    Button btnConfirm, btnCancel;
    Context context;
    SessionManager sessionManager;
    ProfilePresenter profilePresenter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View _view = inflater.inflate(R.layout.fragment_changepassword, container, false);

        pass = (EditText) _view.findViewById(R.id.frag_changepass_pass);
        nPass = (EditText) _view.findViewById(R.id.frag_changepass_npass);
        rPass = (EditText) _view.findViewById(R.id.frag_changepass_rpass);
        btnConfirm = (Button) _view.findViewById(R.id.frag_changepass_btnconf);
        btnCancel = (Button) _view.findViewById(R.id.frag_changepass_btncncl);

        context = getContext();
        sessionManager = new SessionManager(context);
        profilePresenter = new ProfilePresenter(this);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ProfileActivity) getActivity()).doChangeFragment(new ProfileFragment());
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User _oldUser = sessionManager.getUserLoggedIn();

                String _error = "";

                String _np = nPass.getText().toString();
                String _rp = rPass.getText().toString();

                if (pass.getText().length() == 0) _error = "Old Password cannot be empty";
                else if (nPass.getText().length() == 0) _error = "New-Password cannot be empty";
                else if (rPass.getText().length() == 0) _error = "Re-Password cannot be empty";
                else if (!_np.equals(_rp)) _error = "Re-password do not match";

                if (_error != "") {
                    Toast.makeText(context, _error, Toast.LENGTH_SHORT).show();
                }
                else{
                    profilePresenter.doUpdatePassword(_oldUser.getEmail(), pass.getText().toString(), nPass.getText().toString());
                }

                InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                btnConfirm.requestFocus();
            }
        });

        return _view;
    }

    @Override
    public void doSuccess(UserResponse userResponse) {
        sessionManager.doCreateSession(userResponse.getUser());
        Toast.makeText(context, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
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
