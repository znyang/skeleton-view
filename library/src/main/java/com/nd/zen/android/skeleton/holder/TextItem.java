package com.nd.zen.android.skeleton.holder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.ViewGroup;
import com.nd.zen.android.skeleton.holder.PlaceHolder.HolderGenerator;
import com.nd.zen.android.skeleton.holder.PlaceHolder.PlaceViewHolder;
import com.nd.zen.android.skeleton.view.HolderTextView;
import com.nd.zen.android.skeleton.view.Utils;

/**
 * @author zen. date: 2018/4/26 0026
 */
public class TextItem extends BasePlaceItem {

    float mLine = 1f;

    public TextItem(float line) {
        this(line, 1);
    }

    public TextItem(float line, int repeatCount) {
        super(repeatCount, Text.class);
        mLine = line;
    }

    public float getLine() {
        return mLine;
    }

    public void setLine(int line) {
        mLine = line;
    }

    static class Text extends HolderGenerator<ViewHolder, TextItem> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(Context ctx) {
            HolderTextView view = new HolderTextView(ctx);
            view.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            onCreateView(view);
            return new ViewHolder(view);
        }

        protected void onCreateView(HolderTextView view) {
            Context ctx = view.getContext();
            int top = Utils.dp2Px(ctx, 4);
            int left = Utils.dp2Px(ctx, 8);
            view.setPadding(left, top, left, top);
        }

    }

    static class ViewHolder extends PlaceViewHolder<TextItem> {

        public ViewHolder(@NonNull HolderTextView itemView) {
            super(itemView);
        }

        @Override
        public void onBindView(TextItem textItem) {
            ((HolderTextView) itemView).setLinesToDraw(textItem.getLine());
        }
    }

}
