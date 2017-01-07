package com.mvp.ptrade.Presenter.User;

import android.util.Log;

import com.mvp.ptrade.Model.Basic.User;
import com.mvp.ptrade.Model.Connections.ConnectionAPI;
import com.mvp.ptrade.Model.Responses.UserResponse;
import com.mvp.ptrade.Presenter.iPresenterUserResponse;
import com.mvp.ptrade.R;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class ProfilePresenter {
    iPresenterUserResponse profileResponse;

    public ProfilePresenter(iPresenterUserResponse profileResponse) {
        this.profileResponse = profileResponse;
    }

    public void doUpdateProfile(User _user) {
        Map<String, String> _userdatas = new HashMap<>();
        _userdatas.put("id", _user.getId());
        _userdatas.put("username", _user.getUsername());
        _userdatas.put("name", _user.getName());
        _userdatas.put("email", _user.getEmail());
        _userdatas.put("city", _user.getCity());
        _userdatas.put("address", _user.getAddress());
        _userdatas.put("phone", _user.getPhone());
        _userdatas.put("bio", _user.getBio());
        _userdatas.put("gender", _user.getGender().toString());

        Log.d("status", "start update");

        ConnectionAPI.getInstance().getAPIModel().doUpdateProfile(_userdatas).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body().getCode().equals("201")) {
                    profileResponse.doSuccess(response.body());
                } else if (response.body().getCode().equals("401")) {
                    profileResponse.doFail(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                profileResponse.doConnectionError(R.string.connection_error);
            }
        });

    }
}

