package com.mvp.ptrade.View.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.mvp.ptrade.Presenter.iPresenterUserResponse;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.MainActivity;
import com.mvp.ptrade.View.Activity.ProfileActivity;

/**
 * Created by Zackzack on 20/12/2016.
 */

public class ProfileFragment extends Fragment implements iPresenterUserResponse {
    EditText name,username,email,city,address,phone,bio;
    Spinner gender;
    DatePicker datePicker;
    Context context;
    Button save, close;
    private String[] array_spinner;

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
        datePicker = (DatePicker) _view.findViewById(R.id.frag_pro_datePicker);
        save = (Button) _view.findViewById(R.id.frag_pro_btnsave);
        close = (Button) _view.findViewById(R.id.frag_pro_btnclose);

        context = getContext();

        //spinner items
        this.array_spinner = new String[]{
                "Pria","Wanita"
        };
        ArrayAdapter<String> spinneradapter = new ArrayAdapter<>(_view.getContext(),android.R.layout.simple_spinner_item,array_spinner);
        gender.setAdapter(spinneradapter);

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

    @Override
    public void doSuccess(UserResponse userResponse) {
        //sessionManager.doCreateSession(userResponse.getUser());
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
