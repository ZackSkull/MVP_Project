package com.mvp.ptrade.Presenter.Auth;

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

public class LoginPresenter {

    iPresenterUserResponse loginResponse;

    public LoginPresenter (iPresenterUserResponse userResponse) {
        this.loginResponse = loginResponse;
    }

    public void doLogin(String email, String password) {
        Map<String, String> _userdatas = new HashMap<>();
        _userdatas.put("email", email);
        _userdatas.put("password", password);

        ConnectionAPI.getInstance().getAPIModel().doLogin(_userdatas).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body().getCode().equals("200")) {
                    loginResponse.doSuccess(response.body());
                } else {
                    loginResponse.doFail(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                loginResponse.doConnectionError(R.string.connection_error);
            }
        });
    }
}

