package com.mvp.ptrade.Model.Connections;

import com.mvp.ptrade.Model.Controller.APIModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class ConnectionAPI {
    private static final String BASEURL = "http://10.0.2.2:8080/";//192.168.0.100:8001/
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
        retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(APIModel.class);
    }
}
