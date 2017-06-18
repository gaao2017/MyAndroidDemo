package com.gao.myandroiddemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gao.myandroiddemo.R;
import com.gao.myandroiddemo.activity.FruitActivity;
import com.gao.myandroiddemo.bean.Fruit;

import java.util.List;

/**
 * Created by gao on 2017/6/15.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private Context mContext;
    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        this.mFruitList = fruitList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        ImageView mFruitImage;
        TextView mFruitName;

        public ViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView;
            mFruitImage = (ImageView) itemView.findViewById(R.id.iv_fruit_image);
            mFruitName = (TextView) itemView.findViewById(R.id.iv_fruit_name);
        }
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (mContext == null) {
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        //设置cardView点击事件 打开一个水果的详情
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);

                Intent intent = new Intent(mContext, FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImageId());
                mContext.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.mFruitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.mFruitImage);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


}
