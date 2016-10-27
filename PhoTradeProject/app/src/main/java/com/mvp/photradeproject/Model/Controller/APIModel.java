package com.mvp.photradeproject.Model.Controller;

import com.mvp.photradeproject.Model.Responses.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Zackzack on 27/10/2016.
 */

public interface APIModel {

    @POST("user/register")
    Call<UserResponse> doRegister(@Body Map<String, String> userdata);
}
