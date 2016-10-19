package me.chaoyang805.doubanmovie.utils;

import android.content.Context;

/**
 * Created by chaoyang805 on 16/10/18.
 */

public class ScreenUtils {

    /**
     * convert px to dp
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }

    /**
     * convert dp to px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5f);
    }
}
