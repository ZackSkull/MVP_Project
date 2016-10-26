package com.mvp.photradeproject.View.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvp.photradeproject.R;
import com.mvp.photradeproject.View.Activity.AuthActivity;

/**
 * Created by Zackzack on 24/10/2016.
 */

public class RegisterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_register, container, false);
        TextView hasacctext = (TextView) _view.findViewById(R.id.hasacctext);
        hasacctext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((AuthActivity)getActivity()).doChangeFragment(new LoginFragment());
            }
        });
        return _view;
    }
}
