package com.mvp.ptrade.View.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mvp.ptrade.Model.Responses.UserResponse;
import com.mvp.ptrade.Model.SessionManager;
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
    Button save, close;
    DatePicker datePicker;
    private String[] array_spinner;
    SessionManager sessionManager;

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
        date = (EditText) _view.findViewById(R.id.frag_pro_date);
        save = (Button) _view.findViewById(R.id.frag_pro_btnsave);
        close = (Button) _view.findViewById(R.id.frag_pro_btnclose);

        context = getContext();
        sessionManager = new SessionManager(context);

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
                //do save data
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
//<<<<<<< HEAD
        Log.d("Name:", sessionManager.getUserLoggedIn().getName());
        Log.d("Username:", sessionManager.getUserLoggedIn().getUsername());
        Log.d("Email:", sessionManager.getUserLoggedIn().getEmail());
        Log.d("City:", sessionManager.getUserLoggedIn().getCity());
        Log.d("Address:", sessionManager.getUserLoggedIn().getAddress());
        Log.d("Phone:", sessionManager.getUserLoggedIn().getPhone());
        Log.d("Bio:", sessionManager.getUserLoggedIn().getBio());
        Log.d("Date:", sessionManager.getUserLoggedIn().getBorndate());

        name.setText(sessionManager.getUserLoggedIn().getName());
        username.setText(sessionManager.getUserLoggedIn().getUsername());
        email.setText(sessionManager.getUserLoggedIn().getEmail());
        city.setText(sessionManager.getUserLoggedIn().getCity());
        address.setText(sessionManager.getUserLoggedIn().getAddress());
        phone.setText(sessionManager.getUserLoggedIn().getPhone());
        bio.setText(sessionManager.getUserLoggedIn().getBio());
        date.setText(sessionManager.getUserLoggedIn().getBorndate());
        if (sessionManager.getUserLoggedIn().getGender() == 1)
//=======
//        name.setText(sessionManager.getUserLoggedIn().getUsername());
//        username.setText(sessionManager.getUserLoggedIn().getUsername());
//        email.setText(sessionManager.getUserLoggedIn().getEmail());
//        if (sessionManager.getUserLoggedIn().getCity() != null)
//            city.setText(sessionManager.getUserLoggedIn().getCity());
//        if (sessionManager.getUserLoggedIn().getAddress() != null)
//            address.setText(sessionManager.getUserLoggedIn().getAddress());
//        if (sessionManager.getUserLoggedIn().getPhone() != null)
//            phone.setText(sessionManager.getUserLoggedIn().getPhone());
//        if (sessionManager.getUserLoggedIn().getBio() != null)
//            bio.setText(sessionManager.getUserLoggedIn().getBio());
//        if (sessionManager.getUserLoggedIn().getBorndate() != null)
//            date.setText(sessionManager.getUserLoggedIn().getBorndate());
//        if ((sessionManager.getUserLoggedIn().getGender() == true))
//>>>>>>> 748d713305932df87d0eab74862a5d428eb3e18f
            gender.setSelection(1);
        else
            gender.setSelection(2);
    }

    @Override
    public void doSuccess(UserResponse userResponse) {
        sessionManager.doCreateSession(userResponse.getUser());
        Toast.makeText(context, userResponse.getMessage(), Toast.LENGTH_SHORT).show();
        ProfileActivity.doChangeActivity(context, MainActivity.class);
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
