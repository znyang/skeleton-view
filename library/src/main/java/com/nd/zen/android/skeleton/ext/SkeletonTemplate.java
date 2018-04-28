package com.nd.zen.android.skeleton.ext;

import com.nd.zen.android.skeleton.holder.BasePlaceItem;
import com.nd.zen.android.skeleton.holder.IPlaceHolderGenerator;
import com.nd.zen.android.skeleton.holder.PlaceViewHolder;

/**
 * @author zen. date: 2018/4/28 0028
 */
public abstract class SkeletonTemplate<H extends PlaceViewHolder<M>, M extends BasePlaceItem>
        implements IPlaceHolderGenerator<H, M> {

    private int mTypeId = 0;

    @Override
    public int getTypeId() {
        if (mTypeId == 0) {
            mTypeId = getClass().hashCode();
        }
        return mTypeId;
    }
}
