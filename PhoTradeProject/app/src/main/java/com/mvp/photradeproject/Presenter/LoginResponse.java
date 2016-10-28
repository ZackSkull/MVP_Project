package com.mvp.photradeproject.Presenter;

/**
 * Created by Zackzack on 28/10/2016.
 */

public interface LoginResponse {
    public void doLoginSuccess(String message);
    public void doLoginFail(String message);
    public void doConnectionError(String message);
}
