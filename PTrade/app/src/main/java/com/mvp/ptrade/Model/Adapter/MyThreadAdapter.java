package com.mvp.ptrade.Model.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvp.ptrade.Model.Basic.ThreadModel;
import com.mvp.ptrade.R;

import java.util.List;

/**
 * Created by Zackzack on 23/12/2016.
 */

public class MyThreadAdapter extends RecyclerView.Adapter<MyThreadAdapter.MyViewHolder> {
    private Context context;
    private List<ThreadModel> threads;
    public TextView name, description;
    public ImageView imageView;
    public CardView cardView;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.trditem_textname);
            description = (TextView) view.findViewById(R.id.trditem_textdesc);
            imageView = (ImageView) view.findViewById(R.id.trditem_pic);
            cardView = (CardView) view.findViewById(R.id.trditem_cardview);
        }
    }

    public MyThreadAdapter(Context context, List<ThreadModel> threads) {
        this.context = context;
        this.threads = threads;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thread, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        ThreadModel thread = threads.get(position);
        name.setText(thread.getProductid());//seharusnya nama product
        description.setText(thread.getUser());//seharusnya info tambahan product
//        Picasso.with(context).load(thread.getUrl()).into(imageView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open threaddetail
            }
        });
    }

    @Override
    public int getItemCount() {
        return threads.size();
    }
}