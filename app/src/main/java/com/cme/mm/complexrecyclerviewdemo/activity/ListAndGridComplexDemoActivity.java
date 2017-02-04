package com.cme.mm.complexrecyclerviewdemo.activity;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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
public class ListAndGridComplexDemoActivity extends AppCompatActivity {

    @ViewById(R.id.recyclerView)
    RecyclerView recyclerView;

    private DemoAdapter mAdapter;
    int colors[] = {android.R.color.holo_red_light,
            android.R.color.holo_blue_light, android.R.color.holo_orange_light};

    @AfterViews
    void onPageStart() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int type = recyclerView.getAdapter().getItemViewType(position);
                if (DataModel.Type_Three == type) {
                    return gridLayoutManager.getSpanCount();//返回的跨度为Grid的列数
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) view.getLayoutParams();
                int spanSize = layoutParams.getSpanSize();
                int spanIndex = layoutParams.getSpanIndex();
                outRect.top = 20;
                if (spanSize != gridLayoutManager.getSpanCount()) {
                    if (spanIndex == 1) {
                        outRect.left = 10;
                    } else {
                        outRect.right = 10;
                    }
                }
            }
        });

        mAdapter = new DemoAdapter(this);
        recyclerView.setAdapter(mAdapter);

        initData();
    }

    private void initData() {
        List<DataModel> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {

            int type;
            if (i < 5 || (i > 15 && i < 20)) {
                type = 1;
            } else if (i > 10 && i < 26) {
                type = 3;
            } else {
                type = 2;
            }

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