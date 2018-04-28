package com.nd.zen.android.skeleton.holder;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/**
 * @author zen. date: 2018/4/28 0028
 */
public abstract class PlaceViewHolder<M extends BasePlaceItem> extends ViewHolder {

    public PlaceViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBindView(M model);

}