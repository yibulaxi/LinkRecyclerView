package com.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLeft,rvRight;
    private RvLeftAdapter adapter1;
    private RvRightAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        rvLeft = (RecyclerView) findViewById(R.id.rv_left);
        rvRight = (RecyclerView) findViewById(R.id.rv_right);
    }
    private void initData() {
        LeftData leftData = new LeftData();
        leftData.leftList = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            LeftData.LeftItem item = new LeftData.LeftItem();
            item.name = "这是第"+i+"项";
            item.id = i;
            leftData.leftList.add(item);
        }


        //左边
        adapter1=new RvLeftAdapter(MainActivity.this);
        adapter1.setData(leftData.leftList);
        rvLeft.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rvLeft.setAdapter(adapter1);

        //右边
        adapter2=new RvRightAdapter(MainActivity.this);
        rvRight.setLayoutManager(new GridLayoutManager(this,3));
        rvRight.setAdapter(adapter2);
    }

    public void getRightData(int id){

    }

}
