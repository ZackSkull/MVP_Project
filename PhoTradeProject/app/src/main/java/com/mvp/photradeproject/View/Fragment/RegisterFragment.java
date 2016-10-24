package com.mvp.photradeproject.View.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.photradeproject.R;

/**
 * Created by Zackzack on 24/10/2016.
 */

public class RegisterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_login, container, false);
        //((AuthActivity)getActivity()).doChangeFragment(new LoginFragment());
        return _view;
    }
}
