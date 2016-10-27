package com.mvp.photradeproject.Model.Connections;

import com.mvp.photradeproject.Model.Controller.APIModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zackzack on 27/10/2016.
 */

public class ConnectionAPI {
    private static final String BASEURL = "http://192.168.0.100:8001/";
    private static ConnectionAPI instance;
    private static APIModel api;
    private static Retrofit retrofit;

    public static ConnectionAPI getInstance() {
        if (instance == null)
            instance =  new ConnectionAPI();
        return instance;
    }

    public APIModel getAPIModel() {
        return api;
    }

    private ConnectionAPI() {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient.build())
                .build();

        api = retrofit.create(APIModel.class);
    }
}
