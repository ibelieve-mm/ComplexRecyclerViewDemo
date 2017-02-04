package com.cme.mm.complexrecyclerviewdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cme.mm.complexrecyclerviewdemo.R;
import com.cme.mm.complexrecyclerviewdemo.bean.DataModel;

/**
 * Descriptions：
 * <p>
 * Author：ChenME
 * Date：2017/2/3
 * Email：ibelieve1210@163.com
 */
public class Type1ViewHolder extends TypeAbstractViewHolder {

    public ImageView iv_avatar;
    public TextView tv_name;

    public Type1ViewHolder(View itemView) {
        super(itemView);
        iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void bindHolder(DataModel model) {
        iv_avatar.setBackgroundResource(model.avatarColor);
        tv_name.setText(model.name);
    }
}