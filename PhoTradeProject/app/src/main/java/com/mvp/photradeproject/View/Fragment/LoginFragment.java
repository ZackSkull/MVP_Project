package com.mvp.photradeproject.View.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mvp.photradeproject.R;
import com.mvp.photradeproject.View.Activity.AuthActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View _view = inflater.inflate(R.layout.fragment_login, container, false);
        TextView registertext = (TextView) _view.findViewById(R.id.registertext);
        registertext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((AuthActivity)getActivity()).doChangeFragment(new RegisterFragment());
            }
        });
        return _view;
    }
}
