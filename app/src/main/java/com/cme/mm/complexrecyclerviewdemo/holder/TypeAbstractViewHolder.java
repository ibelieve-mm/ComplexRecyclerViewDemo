package com.cme.mm.complexrecyclerviewdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);
    }

    public abstract  void bindHolder(DataModel model);
}
