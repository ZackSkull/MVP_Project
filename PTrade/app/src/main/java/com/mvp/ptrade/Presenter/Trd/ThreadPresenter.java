package com.mvp.ptrade.Presenter.Trd;

import android.util.Log;

import com.mvp.ptrade.Model.Connections.ConnectionAPI;
import com.mvp.ptrade.Model.Responses.ThreadResponse;
import com.mvp.ptrade.Presenter.iPresenterThreadResponse;
import com.mvp.ptrade.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zackzack on 23/12/2016.
 */

public class ThreadPresenter {
    iPresenterThreadResponse iresponse;

    public ThreadPresenter (iPresenterThreadResponse response){
        this.iresponse = response;
    }

    public void getThreads() {
        ConnectionAPI.getInstance().getAPIModel().getThreads().enqueue(new Callback<ThreadResponse>() {
            @Override
            public void onResponse(Call<ThreadResponse> call, Response<ThreadResponse> response) {
                Log.d("response", response.body().getCode());
                if (response.body().getCode().equals("201")) {
                    iresponse.doSuccess(response.body());
                } else if (response.body().getCode().equals("401")) {
                    iresponse.doFail(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ThreadResponse> call, Throwable t) {
                iresponse.doConnectionError(R.string.connection_error);
            }
        });
    }
}

