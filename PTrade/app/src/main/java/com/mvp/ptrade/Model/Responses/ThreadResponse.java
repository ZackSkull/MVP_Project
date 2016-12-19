package com.mvp.ptrade.Model.Responses;

import com.mvp.ptrade.Model.Basic.ThreadModel;
import com.mvp.ptrade.Model.Basic.Response;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class ThreadResponse extends Response {
    private Thread thread;

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
