package com.mvp.ptrade.Model.Responses;

import com.mvp.ptrade.Model.Basic.Response;
import com.mvp.ptrade.Model.Basic.User;

/**
 * Created by Zackzack on 18/12/2016.
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
