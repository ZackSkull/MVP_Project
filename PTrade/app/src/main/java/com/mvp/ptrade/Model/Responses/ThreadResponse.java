package com.mvp.ptrade.Model.Responses;

import com.mvp.ptrade.Model.Basic.ThreadModel;
import com.mvp.ptrade.Model.Basic.Response;

import java.util.List;

/**
 * Created by Zackzack on 19/12/2016.
 */

public class ThreadResponse extends Response {
    private List<ThreadModel> threads;
    public List<ThreadModel> getThreads() {
        return threads;
    }
    public void setThreads(List<ThreadModel> threads) {
        this.threads = threads;
    }
}
