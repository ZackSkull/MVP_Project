package com.mvp.ptrade.Presenter;

import com.mvp.ptrade.Model.Responses.ProductResponse;

/**
 * Created by Zackzack on 04/01/2017.
 */

public interface iPresenterProductResponse extends iPresenterResponse{
    public void doSuccess (ProductResponse productResponse);
}
