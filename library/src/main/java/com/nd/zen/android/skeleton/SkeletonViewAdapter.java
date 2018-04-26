package com.nd.zen.android.skeleton;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.nd.zen.android.skeleton.holder.BasePlaceItem;
import com.nd.zen.android.skeleton.holder.PlaceHolder.PlaceViewHolder;
import com.nd.zen.android.skeleton.holder.SkeletonManager;
import java.util.List;

/**
 * @author zen. date: 2018/4/25 0025
 */
public class SkeletonViewAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    @NonNull
    private SparseArray<BasePlaceItem> mItems = new SparseArray<>();

    private int mCount;

    public SkeletonViewAdapter(@NonNull List<BasePlaceItem> items) {
        setData(items);
    }

    private void setData(@NonNull List<BasePlaceItem> items) {
        mItems.clear();
        int totalSize = 0;
        for (BasePlaceItem item : items) {
            for (int i = item.getRepeatCount(); --i >= 0; ) {
                mItems.put(totalSize++, item);
            }
        }
        mCount = totalSize;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return SkeletonManager.getHolder(viewType).onCreateViewHolder(parent.getContext());
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        holder.onBindView(mItems.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).findPlaceHolder().getTypeId();
    }

    @Override
    public int getItemCount() {
        return mCount;
    }

}
