package com.cme.mm.complexrecyclerviewdemo.activity;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cme.mm.complexrecyclerviewdemo.R;
import com.cme.mm.complexrecyclerviewdemo.adapter.DemoAdapter;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
@EActivity(R.layout.activity_complex_list)
public class ComplexListDemoActivity extends AppCompatActivity{

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    private DemoAdapter mAdapter;
    int colors[] = {android.R.color.holo_red_light,
            android.R.color.holo_blue_light, android.R.color.holo_orange_light};

    @AfterViews
    void onPageStart() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = 15;
            }
        });
        mAdapter = new DemoAdapter(this);

        recyclerView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int type = (int) (Math.random() * 3) + 1;
            DataModel data = new DataModel();
            data.avatarColor = colors[type - 1];
            data.type = type;
            data.name = "name: " + i;
            data.content = "content: " + i;
            data.contentColor = colors[(type + 1) % 3];
            list.add(data);
        }

        mAdapter.addList(list);
        mAdapter.notifyDataSetChanged();
    }
}