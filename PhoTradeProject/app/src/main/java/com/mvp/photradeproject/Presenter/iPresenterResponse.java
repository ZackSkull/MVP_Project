package com.mvp.photradeproject.Presenter;

/**
 * Created by Zackzack on 01/11/2016.
 */

public interface iPresenterResponse {
    public void doFail(String message);
    public void doConnectionError(int message);
}
