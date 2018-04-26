package com.nd.zen.android.skeleton.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.nd.zen.android.skeleton.holder.PlaceHolder.PlaceViewHolder;

/**
 * @author zen. date: 2018/4/24 0024
 */
public interface PlaceHolder<H extends PlaceViewHolder<M>, M extends BasePlaceItem> extends SkeletonType {

    @NonNull
    H onCreateViewHolder(Context ctx);

    abstract class PlaceViewHolder<M extends BasePlaceItem> extends ViewHolder {

        public PlaceViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void onBindView(M model);

    }

    abstract class HolderGenerator<H extends PlaceViewHolder<M>, M extends BasePlaceItem> implements PlaceHolder<H, M> {

        protected int mTypeId = 0;

        @Override
        public int getTypeId() {
            if (mTypeId == 0) {
                mTypeId = getClass().hashCode();
            }
            return mTypeId;
        }
    }

}
