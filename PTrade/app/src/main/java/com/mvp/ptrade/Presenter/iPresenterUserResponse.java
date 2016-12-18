package com.mvp.ptrade.Presenter;

import com.mvp.ptrade.Model.Responses.UserResponse;

/**
 * Created by Zackzack on 18/12/2016.
 */

public interface iPresenterUserResponse extends iPresenterResponse {
    public void doSuccess (UserResponse userResponse);
}
