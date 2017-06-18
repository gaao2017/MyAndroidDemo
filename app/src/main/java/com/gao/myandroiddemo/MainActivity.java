package com.gao.myandroiddemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.gao.myandroiddemo.activity.DBSaveDataActivity;
import com.gao.myandroiddemo.activity.FruitActivity;
import com.gao.myandroiddemo.adapter.FruitAdapter;
import com.gao.myandroiddemo.bean.Fruit;
import com.gao.myandroiddemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //@BindView(R.id.toolbar)
    Toolbar mToolbar;
    //@BindView(R.id.appbar_layout)
    AppBarLayout mAppbarLayout;
    // @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    // @BindView(R.id.fab)
    FloatingActionButton mFab;
    // @BindView(R.id.nav_view)
    NavigationView mNavView;
    //  @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private SwipeRefreshLayout mRefreshLayout;

    private int imageId[] = {R.mipmap.ic_a, R.mipmap.ic_b, R.mipmap.ic_c, R.mipmap.ic_d,
            R.mipmap.ic_e, R.mipmap.ic_f, R.mipmap.ic_g, R.mipmap.ic_h,
            R.mipmap.ic_i, R.mipmap.ic_j, R.mipmap.ic_k, R.mipmap.ic_l,
            R.mipmap.ic_m, R.mipmap.ic_n, R.mipmap.ic_o, R.mipmap.ic_q, R.mipmap.ic_r};

    private String fruitName[] = {"苹果", "香蕉", "凤梨", "桔子", "芒果", "龙眼",
            "苹果1", "香蕉1", "凤梨1", "桔子1", "芒果1", "龙眼1",
            "苹果2", "香蕉2", "凤梨2", "桔子2", "芒果2", "龙眼2", "花生"};

    private List<Fruit> mFruitList = new ArrayList<>();
    private FruitAdapter mFruitAdapter;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ButterKnife.bind(this);

        mContext = MainActivity.this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //设置ToolBar和ActionBar显示一样的效果
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        initFruit();
        initView();


    }

    private void initFruit() {
        mFruitList.clear();
        for (int i = 0; i < imageId.length; i++) {

            Random random = new Random();
            int index = random.nextInt(imageId.length);
            mFruitList.add(new Fruit(fruitName[index], imageId[index]));



        }


    }

    private void initView() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mAppbarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        mRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruit();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.iv_menu);

        }

        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mNavView.setCheckedItem(R.id.nav_call);
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_call:
                        startActivity(new Intent(MainActivity.this, DBSaveDataActivity.class));
                        break;
                }

                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * 参数一 传入一个View SnackBar会自动查找最外层的布局 用于展示
                 * 参数2 SnackBar要显示的内容
                 */
                Snackbar.make(view, "点击悬浮按钮", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(manager);
        mFruitAdapter = new FruitAdapter(mFruitList);
        mRecyclerView.setAdapter(mFruitAdapter);


    }

    private void refreshFruit() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruit();
                        mFruitAdapter.notifyDataSetChanged();
                        mRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {

        }

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.backup:
                Utils.show(MainActivity.this, "点击备份", Toast.LENGTH_SHORT);
                break;
            case R.id.delete:
                Utils.show(MainActivity.this, "点击 删除", Toast.LENGTH_SHORT);
                break;
            case R.id.setting:
                Utils.show(MainActivity.this, "点击 设置", Toast.LENGTH_SHORT);
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

        }

        return true;
    }


}
