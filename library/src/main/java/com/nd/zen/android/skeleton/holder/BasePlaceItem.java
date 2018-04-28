package com.nd.zen.android.skeleton.holder;

/**
 * 占位列表项数据，包含使用的PlaceHolder类型以及重复次数
 *
 * @author zen. date: 2018/4/26 0026
 */
public abstract class BasePlaceItem {

    private int mRepeatCount;

    public BasePlaceItem(int repeatCount) {
        mRepeatCount = repeatCount;
    }

    public int getRepeatCount() {
        return mRepeatCount;
    }

    public IPlaceHolderGenerator findPlaceHolder() {
        return SkeletonManager.getHolder(getClass().hashCode());
    }
}
