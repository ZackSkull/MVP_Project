package com.mvp.ptrade.View.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
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

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Zackzack on 20/12/2016.
 */

public class ProfileFragment extends Fragment implements iPresenterUserResponse {
    EditText name,username,email,city,address,phone,bio,date;
    Spinner gender;
    Context context;
    Button save, close;
//    DatePicker datePicker;
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
//        date = (EditText) _view.findViewById(R.id.frag_pro_date);
//        datePicker = (DatePicker) _view.findViewById(R.id.frag_pro_date);
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
//        Log.d("Name:", String.valueOf(sessionManager.getUserLoggedIn().getName()));
//        Log.d("Username:", String.valueOf(sessionManager.getUserLoggedIn().getUsername()));
//        Log.d("Email:", String.valueOf(sessionManager.getUserLoggedIn().getEmail()));
//        Log.d("City:", String.valueOf(sessionManager.getUserLoggedIn().getCity()));
//        Log.d("Address:", String.valueOf(sessionManager.getUserLoggedIn().getAddress()));
//        Log.d("Phone:", String.valueOf(sessionManager.getUserLoggedIn().getPhone()));
//        Log.d("Bio:", String.valueOf(sessionManager.getUserLoggedIn().getBio()));
//        Log.d("Date:", String.valueOf(sessionManager.getUserLoggedIn().getBorndate()));
//
        name.setText(String.valueOf(sessionManager.getUserLoggedIn().getName()));
        username.setText(sessionManager.getUserLoggedIn().getUsername());
        email.setText(String.valueOf(sessionManager.getUserLoggedIn().getEmail()));
        city.setText(String.valueOf(sessionManager.getUserLoggedIn().getCity()));
        address.setText(String.valueOf(sessionManager.getUserLoggedIn().getAddress()));
        phone.setText(String.valueOf(sessionManager.getUserLoggedIn().getPhone()));
        bio.setText(String.valueOf(sessionManager.getUserLoggedIn().getBio()));
//        date.setText(String.valueOf(sessionManager.getUserLoggedIn().getBorndate()));
//        SimpleDateFormat _df = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
//        Date _d = new Date();
//        Calendar _cal = new Calendar.getInstance();
//
//
//        try {
//            _d = _df.parse(String.valueOf(sessionManager.getUserLoggedIn().getBorndate()));
//            _cal.setTime(_d);
//        } catch (ParseException _e){
//            _e.printStackTrace();
//        }
//
//        datePicker.init(_cal.YEAR, _cal.MONTH, _cal.DATE, null);
        gender.setSelection(sessionManager.getUserLoggedIn().getGender());
//        if (sessionManager.getUserLoggedIn().getGender() == 1)
//=======
//        if (sessionManager.getUserLoggedIn().getName() != null)
//            name.setText(sessionManager.getUserLoggedIn().getName());
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
//        if (sessionManager.getUserLoggedIn().getGender() == 1)
//>>>>>>> 748d713305932df87d0eab74862a5d428eb3e18f
//            gender.setSelection(0);
//        else
//            gender.setSelection(1);
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
