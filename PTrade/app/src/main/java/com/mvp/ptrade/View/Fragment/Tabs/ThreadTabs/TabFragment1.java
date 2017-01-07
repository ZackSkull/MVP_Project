package com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mvp.ptrade.Model.Adapter.MyThreadAdapter;
import com.mvp.ptrade.Model.Basic.ThreadModel;
import com.mvp.ptrade.Model.Responses.ThreadResponse;
import com.mvp.ptrade.Presenter.Trd.ThreadPresenter;
import com.mvp.ptrade.Presenter.iPresenterThreadResponse;
import com.mvp.ptrade.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zackzack on 18/12/2016.
 */

public class TabFragment1 extends Fragment implements iPresenterThreadResponse {
    private RecyclerView recyclerView;
    private List<ThreadModel> threads;
    private MyThreadAdapter myThreadAdapter;
    private GridLayoutManager myLayoutManager;
    private ThreadPresenter threadPresenter;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public TabFragment1(){}
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.tab_fragment_1, container, false);

        threadPresenter = new ThreadPresenter(this);
        recyclerView = (RecyclerView) _view.findViewById(R.id.tab1_rv);
        mSwipeRefreshLayout = (SwipeRefreshLayout) _view.findViewById(R.id.tab1_refresh);

        threads = new ArrayList<>();
        myThreadAdapter = new MyThreadAdapter(getActivity(),threads);

        myLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(myLayoutManager);
        threadPresenter.getThreads();
        recyclerView.setAdapter(myThreadAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(true);
                threadPresenter.getThreads();
            }
        });

        return  _view;
    }

    @Override
    public void doSuccess(ThreadResponse threadResponse) {
        ThreadResponse newResponse = threadResponse;
        MyThreadAdapter adapter = new MyThreadAdapter(getActivity(), newResponse.getThreads());
        recyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void doConnectionError(int message) {
        //dosomething
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void doFail(String message) {
        //dosomething
        mSwipeRefreshLayout.setRefreshing(false);
    }
}
