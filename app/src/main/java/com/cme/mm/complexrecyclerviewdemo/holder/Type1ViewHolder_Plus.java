package com.cme.mm.complexrecyclerviewdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cme.mm.complexrecyclerviewdemo.R;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel1;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
public class Type1ViewHolder_Plus extends TypeAbstractViewHolder_Plus<DataModel1> {

    public ImageView iv_avatar;
    public TextView tv_name;

    public Type1ViewHolder_Plus(View itemView) {
        super(itemView);
        iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void bindHolder(DataModel1 model) {
        iv_avatar.setBackgroundResource(model.avatarColor);
        tv_name.setText(model.name);
    }
}