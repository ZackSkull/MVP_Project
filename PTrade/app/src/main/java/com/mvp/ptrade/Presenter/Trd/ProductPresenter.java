package com.mvp.ptrade.Presenter.Trd;

import com.mvp.ptrade.Model.Connections.ConnectionAPI;
import com.mvp.ptrade.Model.Responses.ProductResponse;
import com.mvp.ptrade.Presenter.iPresenterProductResponse;
import com.mvp.ptrade.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zackzack on 04/01/2017.
 */

public class ProductPresenter {
    iPresenterProductResponse iresponse;

    public ProductPresenter (iPresenterProductResponse response){
        this.iresponse = response;
    }

    public void getProducts() {
        ConnectionAPI.getInstance().getAPIModel().getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.body().getCode().equals("201")) {
                    iresponse.doSuccess(response.body());
                } else if (response.body().getCode().equals("401")) {
                    iresponse.doFail(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                iresponse.doConnectionError(R.string.connection_error);
            }
        });

    }
}
