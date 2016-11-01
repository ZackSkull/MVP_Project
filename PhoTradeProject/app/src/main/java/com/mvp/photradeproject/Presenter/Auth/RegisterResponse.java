package com.mvp.photradeproject.Presenter.Auth;

/**
 * Created by Zackzack on 28/10/2016.
 */

public interface RegisterResponse {
    public void doRegisterSuccess(String message);
    public void doRegisterFail(String message);
    public void doConnectionError(String message);
}
