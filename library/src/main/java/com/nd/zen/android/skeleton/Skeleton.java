package com.nd.zen.android.skeleton;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.nd.zen.android.skeleton.holder.BasePlaceItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zen. date: 2018/4/24 0024
 */
public class Skeleton {

    private List<BasePlaceItem> mItems = new ArrayList<>();

    private Skeleton() {
        // do not thing
    }

    @NonNull
    public static Skeleton create() {
        return new Skeleton();
    }

    @NonNull
    static Skeleton.Wrapper create(@NonNull RecyclerView host) {
        return new Wrapper(host);
    }

    //// 配置组装部分

    public Skeleton append(BasePlaceItem item) {
        mItems.add(item);
        return this;
    }

    //// 配置应用部分

    public void into(@NonNull RecyclerView view) {
        SkeletonViewAdapter adapter = new SkeletonViewAdapter(mItems);

        view.setLayoutManager(new LinearLayoutManager(view.getContext()));
        view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public static class Wrapper extends Skeleton {

        private RecyclerView mHost;

        private Wrapper(@NonNull RecyclerView host) {
            mHost = host;
        }

        public void apply() {
            into(mHost);
        }

        public Wrapper append(BasePlaceItem item) {
            super.append(item);
            return this;
        }

    }

}
