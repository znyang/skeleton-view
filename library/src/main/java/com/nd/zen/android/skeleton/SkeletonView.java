package com.nd.zen.android.skeleton;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @author zen. date: 2018/4/24 0024
 */
public class SkeletonView extends RecyclerView {

    public SkeletonView(Context context) {
        super(context);
    }

    public SkeletonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SkeletonView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @NonNull
    public Skeleton.Wrapper setup() {
        return Skeleton.create(this);
    }


}
