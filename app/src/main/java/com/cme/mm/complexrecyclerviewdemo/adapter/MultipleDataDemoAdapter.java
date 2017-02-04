package com.cme.mm.complexrecyclerviewdemo.adapter;


import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cme.mm.complexrecyclerviewdemo.R;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel1;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel2;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel3;
import com.cme.mm.complexrecyclerviewdemo.holder.Type1ViewHolder;
import com.cme.mm.complexrecyclerviewdemo.holder.Type1ViewHolder_Plus;
import com.cme.mm.complexrecyclerviewdemo.holder.Type2ViewHolder;
import com.cme.mm.complexrecyclerviewdemo.holder.Type2ViewHolder_Plus;
import com.cme.mm.complexrecyclerviewdemo.holder.Type3ViewHolder;
import com.cme.mm.complexrecyclerviewdemo.holder.Type3ViewHolder_Plus;
import com.cme.mm.complexrecyclerviewdemo.holder.TypeAbstractViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
public class MultipleDataDemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int Type_One = 1;
    public static final int Type_Two = 2;
    public static final int Type_Three = 3;

    private LayoutInflater layoutInflater;
//    private List<DataModel> mList = new ArrayList<>();

    @Override
    public int getItemViewType(int position) {
        return typeList.get(position);
    }

    public MultipleDataDemoAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    public void addList(List<DataModel1> list1, List<DataModel2> list2, List<DataModel3> list3) {
        addListByType(Type_One, list1);
        addListByType(Type_Two, list2);
        addListByType(Type_Three, list3);

        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
    }

    private List<DataModel1> list1 = new ArrayList<>();
    private List<DataModel2> list2 = new ArrayList<>();
    private List<DataModel3> list3 = new ArrayList<>();
    private List<Integer> typeList = new ArrayList<>();
    private Map<Integer, Integer> mPosition = new HashMap<>();

    private void addListByType(int type, List list) {
        mPosition.put(type, typeList.size());
        for (int i = 0; i < list.size(); i++) {
            typeList.add(type);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.Type_One:
                return new Type1ViewHolder_Plus(layoutInflater.inflate(R.layout.item_type_1, parent, false));
            case DataModel.Type_Two:
                return new Type2ViewHolder_Plus(layoutInflater.inflate(R.layout.item_type_2, parent, false));
            case DataModel.Type_Three:
                return new Type3ViewHolder_Plus(layoutInflater.inflate(R.layout.item_type_3, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        int realPosition = position - mPosition.get(viewType);

        switch (viewType) {
            case DataModel.Type_One:
                ((Type1ViewHolder_Plus) holder).bindHolder(list1.get(realPosition));
                break;
            case DataModel.Type_Two:
                ((Type2ViewHolder_Plus) holder).bindHolder(list2.get(realPosition));
                break;
            case DataModel.Type_Three:
                ((Type3ViewHolder_Plus) holder).bindHolder(list3.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }
}