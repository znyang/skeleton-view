package com.nd.zen.android.skeleton.ext;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nd.zen.android.skeleton.R;
import com.nd.zen.android.skeleton.ext.PlaceHolderTab.TabContainer;
import com.nd.zen.android.skeleton.ext.PlaceHolderTab.TabViewHolder;
import com.nd.zen.android.skeleton.holder.BasePlaceItem;
import com.nd.zen.android.skeleton.holder.PlaceViewHolder;
import com.nd.zen.android.skeleton.holder.SkeletonManager;

/**
 * @author zen. date: 2018/4/28 0028
 */
public class PlaceHolderTab extends SkeletonTemplate<TabViewHolder, TabContainer> {

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(ViewGroup vg) {
        return new TabViewHolder(onCreateView(vg));
    }

    protected View onCreateView(ViewGroup vg) {
        return LayoutInflater.from(vg.getContext())
                .inflate(R.layout.ske_tmp_tab, vg, false);
    }

    public static class TabContainer extends BasePlaceItem {

        static {
            SkeletonManager.registerHolderGenerator(new PlaceHolderTab());
        }

        public TabContainer(int repeatCount) {
            super(repeatCount);
        }
    }

    public static class TabViewHolder extends PlaceViewHolder<TabContainer> {

        public TabViewHolder(View itemView) {
            super(itemView);
//            ViewGroup group = (ViewGroup) itemView.findViewById(R.id.vg_ske_tab);
//            for (int i = group.getChildCount(); --i >= 0; ) {
//                View child = group.getChildAt(i);
//                if (child instanceof HolderTextView) {
//                    ((HolderTextView) child).setLinesToDraw(1f);
//                }
//            }
        }

        @Override
        public void onBindView(TabContainer model) {

        }
    }

}
