package com.mvp.ptrade.Presenter;

import com.mvp.ptrade.Model.Responses.ThreadResponse;

/**
 * Created by Zackzack on 23/12/2016.
 */

public interface iPresenterThreadResponse extends iPresenterResponse {
    public void doSuccess (ThreadResponse threadResponse);
}
