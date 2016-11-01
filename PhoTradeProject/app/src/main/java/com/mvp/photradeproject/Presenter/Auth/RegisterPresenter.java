package com.mvp.photradeproject.Presenter.Auth;

import com.mvp.photradeproject.Model.Connections.ConnectionAPI;
import com.mvp.photradeproject.Model.Responses.UserResponse;
import com.mvp.photradeproject.Presenter.iPresenterUserResponse;
import com.mvp.photradeproject.R;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zackzack on 28/10/2016.
 */

public class RegisterPresenter {
    iPresenterUserResponse registerresponse;

    public RegisterPresenter(iPresenterUserResponse registerresponse) {
        this.registerresponse = registerresponse;
    }

    public void doRegister(String name, String email, String password) {
        Map<String, String> _userdatas = new HashMap<>();
        _userdatas.put("name", name);
        _userdatas.put("email", email);
        _userdatas.put("password", password);

        ConnectionAPI.getInstance().getAPIModel().doRegister(_userdatas).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body().getCode().equals("201")) {
                    registerresponse.doSuccess(response.body());
                } else if (response.body().getCode().equals("401")) {
                    registerresponse.doFail(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                registerresponse.doConnectionError(R.string.connection_error);
            }
        });

    }
}
