package com.mvp.ptrade.View.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mvp.ptrade.Model.Basic.User;
import com.mvp.ptrade.Model.Responses.UserResponse;
import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.Presenter.User.ProfilePresenter;
import com.mvp.ptrade.Presenter.iPresenterUserResponse;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.MainActivity;
import com.mvp.ptrade.View.Activity.ProfileActivity;

/**
 * Created by Zackzack on 20/12/2016.
 */

public class ProfileFragment extends Fragment implements iPresenterUserResponse {
    EditText name,username,email,city,address,phone,bio,date;
    Spinner gender;
    Context context;
    Button save, close, changepass;
//    DatePicker datePicker;
    private String[] array_spinner;
    SessionManager sessionManager;
    ProfilePresenter profilePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View _view = inflater.inflate(R.layout.fragment_profile, container, false);

        name = (EditText) _view.findViewById(R.id.frag_pro_name);
        username = (EditText) _view.findViewById(R.id.frag_pro_username);
        email = (EditText) _view.findViewById(R.id.frag_pro_email);
        city = (EditText) _view.findViewById(R.id.frag_pro_kota);
        address = (EditText) _view.findViewById(R.id.frag_pro_address);
        phone = (EditText) _view.findViewById(R.id.frag_pro_phone);
        bio = (EditText) _view.findViewById(R.id.frag_pro_bio);
        gender = (Spinner) _view.findViewById(R.id.frag_pro_spinner_gender);
        save = (Button) _view.findViewById(R.id.frag_pro_btnsave);
        changepass = (Button) _view.findViewById(R.id.frag_pro_btncngpass);
        close = (Button) _view.findViewById(R.id.frag_pro_btnclose);

        context = getContext();
        sessionManager = new SessionManager(context);
        profilePresenter = new ProfilePresenter(this);

        //spinner items
        this.array_spinner = new String[]{
                "Pria","Wanita"
        };

        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(_view.getContext(),android.R.layout.simple_spinner_item,array_spinner);
        gender.setAdapter(spinneradapter);

        setsession();

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                User _oldUser = sessionManager.getUserLoggedIn();
                User _user = new User();
                _user.setId(_oldUser.getId());
                String _error = "";
                if (username.getText().toString() == "") _error = "Username cannot be empty";
                if (email.getText().toString() == "") _error = "Email cannot be empty";

                if (_error != "") {
                    Toast.makeText(context, _error, Toast.LENGTH_SHORT).show();
                }

                _user.setName(name.getText().toString());
                _user.setUsername(username.getText().toString());
                _user.setEmail(email.getText().toString());
                _user.setCity(city.getText().toString());
                _user.setAddress(address.getText().toString());
                _user.setPhone(phone.getText().toString());
                _user.setBio(bio.getText().toString());
                _user.setGender(gender.getSelectedItemPosition());

                profilePresenter.doUpdateProfile(_user);

                InputMethodManager inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                save.requestFocus();
            }
        });

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Change Password", Toast.LENGTH_SHORT).show();
                doChangeFragment(new ChangePassFragment());
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileActivity.doChangeActivity(context, MainActivity.class);
            }
        });

        return _view;
    }

    private void setsession(){
        User _user = sessionManager.getUserLoggedIn();
        name.setText(String.valueOf(_user.getName()));
        username.setText(_user.getUsername());
        email.setText(String.valueOf(_user.getEmail()));
        city.setText(String.valueOf(_user.getCity()));
        address.setText(String.valueOf(_user.getAddress()));
        phone.setText(String.valueOf(_user.getPhone()));
        bio.setText(String.valueOf(_user.getBio()));
        gender.setSelection(_user.getGender());
    }

    @Override
    public void doSuccess(UserResponse userResponse) {
        sessionManager.doCreateSession(userResponse.getUser());
        Toast.makeText(context, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
        setsession();
    }

    @Override
    public void doFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doConnectionError(int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void doChangeFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.frag_pro, fragment).commit();
    }
}
