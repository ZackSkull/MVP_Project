package com.mvp.ptrade.View.Fragment.Tabs.ThreadTabs;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    private List<ThreadModel> threadlist;
    private MyThreadAdapter myThreadAdapter;
    private GridLayoutManager myLayoutManager;
    private Context context;
    private ThreadPresenter threadPresenter;

    public TabFragment1(){}
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _View = inflater.inflate(R.layout.tab_fragment_1, container, false);

        //threadPresenter = new ThreadPresenter(this);
        recyclerView = (RecyclerView) _View.findViewById(R.id.tab1_rv);
        context = _View.getContext();
        threadPresenter = new ThreadPresenter(this);

        threadlist = new ArrayList<>();
        myThreadAdapter = new MyThreadAdapter(context,threadlist);
        myLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(myLayoutManager);
//        threadPresenter.getThreadList();
        threadPresenter.getThreads();
        myThreadAdapter.notifyDataSetChanged();

//        try {
//            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return  _View;
    }

    @Override
    public void doSuccess(ThreadResponse threadResponse) {
        MyThreadAdapter adapter = new MyThreadAdapter(context, threadResponse.getThreads());
        myThreadAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void doConnectionError(int message) {
        //dosomething
    }

    @Override
    public void doFail(String message) {
        //dosomething
    }
}
