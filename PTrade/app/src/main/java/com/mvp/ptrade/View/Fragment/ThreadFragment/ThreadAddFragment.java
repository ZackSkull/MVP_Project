package com.mvp.ptrade.View.Fragment.ThreadFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp.ptrade.Model.Basic.Product;
import com.mvp.ptrade.Model.Responses.ProductResponse;
import com.mvp.ptrade.Model.Responses.ThreadResponse;
import com.mvp.ptrade.Model.SessionManager;
import com.mvp.ptrade.Presenter.Trd.ProductPresenter;
import com.mvp.ptrade.Presenter.iPresenterProductResponse;
import com.mvp.ptrade.R;
import com.mvp.ptrade.View.Activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zackzack on 04/01/2017.
 */

public class ThreadAddFragment extends Fragment implements iPresenterProductResponse {
    private Context context;
    private Product[] products;
    private Spinner spinner;
    private EditText moreinfo;
    private Button addbtn;
    private ProductPresenter productPresenter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.thread_add_fragment, container, false);
        spinner = (Spinner) view.findViewById(R.id.trd_add_spinner);
        moreinfo = (EditText) view.findViewById(R.id.trd_add_moreinfo);
        addbtn = (Button) view.findViewById(R.id.trd_add_btn);

        context = getContext();
//        sessionManager = new SessionManager(context);
        productPresenter = new ProductPresenter(this);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productPresenter.getProducts();
            }
        });

        return view;
    }


    @Override
    public void doSuccess(ProductResponse productResponse) {
        products = productResponse.getProduct();
        ArrayAdapter<Product> productArrayAdapter = new ArrayAdapter<>(context,android.R.layout.simple_spinner_item,products);
        spinner.setAdapter(productArrayAdapter);
    }

    @Override
    public void doFail(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void doConnectionError(int message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
