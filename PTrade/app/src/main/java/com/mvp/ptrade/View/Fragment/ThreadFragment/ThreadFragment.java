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

public class ThreadFragment extends Fragment{
    private Context context;
    TextView productname;
    EditText ownerinfo;
    Button btncls, btnoffer;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_login, container, false);
        productname = (TextView) _view.findViewById(R.id.frag_product_name);
        ownerinfo = (EditText) _view.findViewById(R.id.frag_product_infoowner);
        btncls = (Button) _view.findViewById(R.id.frag_product_btncls);
        btnoffer = (Button) _view.findViewById(R.id.frag_product_btnoffer);

        ownerinfo.setKeyListener(null);
        btncls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return _view;
    }
}
