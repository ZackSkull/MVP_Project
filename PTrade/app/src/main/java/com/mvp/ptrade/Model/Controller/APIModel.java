package com.mvp.ptrade.Model.Controller;

import com.mvp.ptrade.Model.Responses.ThreadResponse;
import com.mvp.ptrade.Model.Responses.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Zackzack on 18/12/2016.
 */

public interface APIModel {

    @POST("user/register")
    Call<UserResponse> doRegister(@Body Map<String, String> userdata);

    @POST("user/login")
    Call<UserResponse> doLogin(@Body Map<String, String> userdata);

    @GET("path")
    Call<ThreadResponse> getThreads();
}
