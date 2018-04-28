package com.nd.zen.android.skeleton.ext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.ViewGroup;
import com.nd.zen.android.skeleton.ext.PlaceHolderText.TextItem;
import com.nd.zen.android.skeleton.ext.PlaceHolderText.TextViewHolder;
import com.nd.zen.android.skeleton.holder.BasePlaceItem;
import com.nd.zen.android.skeleton.holder.PlaceViewHolder;
import com.nd.zen.android.skeleton.view.HolderTextView;
import com.nd.zen.android.skeleton.view.Utils;

/**
 * @author zen. date: 2018/4/28 0028
 */
public class PlaceHolderText extends SkeletonTemplate<TextViewHolder, TextItem> {

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup vg) {
        HolderTextView view = new HolderTextView(vg.getContext());
        view.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        onCreateView(view);
        return new TextViewHolder(view);
    }

    private void onCreateView(HolderTextView view) {
        Context ctx = view.getContext();
        int top = Utils.dp2Px(ctx, 4);
        int left = Utils.dp2Px(ctx, 8);
        view.setPadding(left, top, left, top);
    }

    public static class TextItem extends BasePlaceItem {

        float mLine = 1f;

        public TextItem(float line) {
            this(line, 1);
        }

        public TextItem(float line, int repeatCount) {
            super(repeatCount);
            mLine = line;
        }

        public float getLine() {
            return mLine;
        }

        public void setLine(int line) {
            mLine = line;
        }
    }

    static class TextViewHolder extends PlaceViewHolder<TextItem> {

        public TextViewHolder(@NonNull HolderTextView itemView) {
            super(itemView);
        }

        @Override
        public void onBindView(TextItem textItem) {
            ((HolderTextView) itemView).setLinesToDraw(textItem.getLine());
        }
    }


}
