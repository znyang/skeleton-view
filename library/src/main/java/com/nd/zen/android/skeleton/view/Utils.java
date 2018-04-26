package com.nd.zen.android.skeleton.view;

import android.content.Context;

/**
 * @author zen. date: 2018/4/26 0026
 */
public class Utils {

    public static int dp2Px(Context ctx, int dp) {
        return (int) (ctx.getResources().getDisplayMetrics().density * dp);
    }

}
