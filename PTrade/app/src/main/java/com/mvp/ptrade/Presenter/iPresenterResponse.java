package com.mvp.ptrade.Presenter;

/**
 * Created by Zackzack on 18/12/2016.
 */

public interface iPresenterResponse {
    public void doFail(String message);
    public void doConnectionError(int message);
}
