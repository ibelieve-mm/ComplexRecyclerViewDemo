package com.cme.mm.complexrecyclerviewdemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
public abstract class TypeAbstractViewHolder_Plus<T> extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder_Plus(View itemView) {
        super(itemView);
    }

    public abstract  void bindHolder(T model);
}
