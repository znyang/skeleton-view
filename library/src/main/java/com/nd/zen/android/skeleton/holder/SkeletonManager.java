package com.nd.zen.android.skeleton.holder;

import android.util.SparseArray;
import com.nd.zen.android.skeleton.holder.TextItem.Text;

/**
 * @author zen. date: 2018/4/26 0026
 */
public class SkeletonManager {

    private static SparseArray<PlaceHolder> sHolders = new SparseArray<>();

    static {
        registerHolderGenerator(new Text());
    }

    public static void registerHolderGenerator(PlaceHolder... holders) {
        if (holders != null) {
            for (PlaceHolder holder : holders) {
                sHolders.append(holder.getTypeId(), holder);
            }
        }
    }

    public static PlaceHolder getHolder(int typeId) {
        return sHolders.get(typeId);
    }

}
