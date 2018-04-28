package com.nd.zen.android.skeleton.holder;

import android.support.annotation.NonNull;
import android.view.ViewGroup;

/**
 * @author zen. date: 2018/4/24 0024
 */
public interface IPlaceHolderGenerator<H extends PlaceViewHolder<M>, M extends BasePlaceItem>
        extends ISkeletonType {

    @NonNull
    H onCreateViewHolder(ViewGroup parent);

}
