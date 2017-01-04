package com.mvp.ptrade.Model.Controller;

import com.mvp.ptrade.Model.Responses.ProductResponse;
import com.mvp.ptrade.Model.Responses.ThreadResponse;
import com.mvp.ptrade.Model.Responses.UserResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Zackzack on 18/12/2016.
 */

public interface APIModel {

    @POST("user/register")
    Call<UserResponse> doRegister(@Body Map<String, String> userdata);
    @POST("user/login")
    Call<UserResponse> doLogin(@Body Map<String, String> userdata);

//    Route::get('spec', 'SpecDefaultController@index');
//    Route::get('spec/{id}', 'SpecDefaultController@show');
//    Route::post('spec/store', 'SpecDefaultController@store');
//    Route::put('spec/update/{id}', 'SpecDefaultController@update');
//    Route::delete('spec/delete/{id}', 'SpecDefaultController@destroy');

    @GET("product")
    Call<ProductResponse> getProducts();
    @GET("product/{id}")
    Call<ProductResponse> getProduct();
    @POST("product/store")
    Call<ProductResponse> storeProduct();
    @PUT("product/update/{id}")
    Call<ProductResponse> updateProduct();
    @DELETE("product/delete/{id}")
    Call<ProductResponse> deleteProduct();

    @GET("thread")
    Call<ThreadResponse> getThreads();
    @GET("thread/{id}")
    Call<ThreadResponse> getThread();
    @POST("thread/store")
    Call<ThreadResponse> storeThread();
    @PUT("thread/update/{id}")
    Call<ThreadResponse> updateThread();
    @DELETE("thread/delete/{id}")
    Call<ThreadResponse> deleteThread();
}
