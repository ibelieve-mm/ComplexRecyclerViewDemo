package com.cme.mm.complexrecyclerviewdemo.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cme.mm.complexrecyclerviewdemo.R;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;
import com.cme.mm.complexrecyclerviewdemo.holder.Type1ViewHolder;
import com.cme.mm.complexrecyclerviewdemo.holder.Type2ViewHolder;
import com.cme.mm.complexrecyclerviewdemo.holder.Type3ViewHolder;
import com.cme.mm.complexrecyclerviewdemo.holder.TypeAbstractViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<DataModel> mList = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;
    }

    public DemoAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel> list) {
        mList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.Type_One:
                return new Type1ViewHolder(layoutInflater.inflate(R.layout.item_type_1, parent, false));
            case DataModel.Type_Two:
                return new Type2ViewHolder(layoutInflater.inflate(R.layout.item_type_2, parent, false));
            case DataModel.Type_Three:
                return new Type3ViewHolder(layoutInflater.inflate(R.layout.item_type_3, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TypeAbstractViewHolder) holder).bindHolder(mList.get(position));
//        int viewType = getItemViewType(position);
//        switch (viewType) {
//            case DataModel.Type_One:
//                ((Type1ViewHolder) holder).bindHolder(mList.get(position));
//                break;
//            case DataModel.Type_Two:
//                ((Type2ViewHolder) holder).bindHolder(mList.get(position));
//                break;
//            case DataModel.Type_Three:
//                ((Type3ViewHolder) holder).bindHolder(mList.get(position));
//                break;
//        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
