package com.nd.zen.android.skeleton.holder;

import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import com.nd.zen.android.skeleton.ext.PlaceHolderText;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author zen. date: 2018/4/26 0026
 */
public class SkeletonManager {

    private static SparseArray<IPlaceHolderGenerator> sHolders = new SparseArray<>();

    static {
        registerHolderGenerator(new PlaceHolderText());
    }

    public static void registerHolderGenerator(IPlaceHolderGenerator... holders) {
        if (holders != null) {
            long start = SystemClock.elapsedRealtime();
            for (IPlaceHolderGenerator holder : holders) {
                appendCode(holder.getTypeId(), holder);
                registerPlaceItem(holder);
            }
            long cost = SystemClock.elapsedRealtime() - start;
            Log.e("Ske", "cost " + cost + "ms");
        }
    }

    private static void registerPlaceItem(IPlaceHolderGenerator holder) {
        Type type = holder.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type[] ats = pt.getActualTypeArguments();
            for (Type at : ats) {
                if (at instanceof Class
                        && BasePlaceItem.class.isAssignableFrom((Class) at)) {
                    // register BasePlaceItem -> HolderGenerator
                    appendCode(at.hashCode(), holder);
                    Log.w("Ske", "register class " + ((Class) at).getSimpleName() + " -> " + holder.toString());
                }
            }
        }
    }

    private static void appendCode(int code, IPlaceHolderGenerator generator) {
        sHolders.append(code, generator);
        Log.w("Ske", "register " + code + " -> " + generator.toString());
    }

    public static IPlaceHolderGenerator getHolder(int typeId) {
        IPlaceHolderGenerator generator = sHolders.get(typeId);
        if (generator == null) {
            Log.e("Ske", "find code " + typeId + " FAIL.");
        }
        return generator;
    }

}
