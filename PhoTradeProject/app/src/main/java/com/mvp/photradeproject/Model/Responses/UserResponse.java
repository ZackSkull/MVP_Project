package com.mvp.photradeproject.Model.Responses;

import com.mvp.photradeproject.Model.Basic.Response;
import com.mvp.photradeproject.Model.Basic.User;

/**
 * Created by Zackzack on 27/10/2016.
 */

public class UserResponse extends Response {
    private User user;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
