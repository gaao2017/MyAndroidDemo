package com.gao.myandroiddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gao.myandroiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作为图片详情的展示界面
 */
public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    @BindView(R.id.fruit_image_view)
    ImageView mFruitImageView;
    @BindView(R.id.tool_bar)
    Toolbar mToolBar;
    @BindView(R.id.collapse_toolbar)
    CollapsingToolbarLayout mCollapseToolbar;
    @BindView(R.id.appBar)
    AppBarLayout mAppBar;
    @BindView(R.id.tv_fruit_text)
    TextView mTvFruitText;
    @BindView(R.id.btn_comment)
    FloatingActionButton mBtnComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String fruitName = intent.getStringExtra(FRUIT_NAME);
        int fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 0);

        setSupportActionBar(mToolBar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mCollapseToolbar.setTitle(fruitName);

        Glide.with(this).load(fruitImageId).into(mFruitImageView);

        String fruitDesc = generateFruitDesc(fruitName);
        mTvFruitText.setText(fruitDesc);

        mBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mTvFruitText,"评论",Snackbar.LENGTH_LONG)
                        .setText("哈哈").setAction("哈哈哈哈", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FruitActivity.this, "我被点击", Toast.LENGTH_SHORT).show();
                    }
                })
                        .setActionTextColor(getResources().getColor(R.color.colorAccent)).show();
            }
        });
    }

    private String generateFruitDesc(String fruitName) {
        StringBuilder fruitText = new StringBuilder();
        for (int i = 0; i < 530; i++) {
            fruitText.append(fruitName);
        }
        return fruitText.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;

        }

        return super.onOptionsItemSelected(item);

    }
}
