package com.mvp.photradeproject.Presenter;

import com.mvp.photradeproject.Model.Responses.UserResponse;

/**
 * Created by Zackzack on 01/11/2016.
 */

public interface iPresenterUserResponse extends iPresenterResponse {
    public void doSuccess (UserResponse userResponse);
}
