package me.chaoyang805.doubanmovie.data.source.remote;

import android.content.Context;

import com.android.annotations.Nullable;

/**
 * Created by chaoyang805 on 16/10/20.
 */

public class RetrofitFactory {

    private static DoubanService sInstance = null;

    private static final Object obj = new Object();

    public static DoubanService getDoubanService(Context appContext, @Nullable CacheControlCallback callback) {
//        if (sInstance == null) {
//            synchronized (obj) {
//                if (sInstance == null) {
//                    sInstance = new DoubanAPI(appContext, callback).getDoubanService();
//                }
//            }
//        }
        return new DoubanAPI(appContext, callback).getDoubanService();
    }

    // Another service ?
}
