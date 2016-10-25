package me.chaoyang805.doubanmovie.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.android.annotations.Nullable;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by chaoyang805 on 16/10/20.
 */

public class DoubanAPI {

    private static final String TAG = "DoubanAPI";

    // 10MB cache size
    private static final long MAX_CACHE_SIZE = 10 * 1024 *1024;
    // must be applicationContext
    private Context mContext;

    private CacheControlCallback mCallback = null;

    DoubanAPI(Context context, @Nullable CacheControlCallback callback) {
        mContext = context;
        mCallback = callback;
    }

    DoubanService getDoubanService() {

        String baseUrl = "https://api.douban.com/v2/movie/";
        OkHttpClient client = buildOkHttpClient();

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();

        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build();
        DoubanService doubanService = retrofit.create(DoubanService.class);

        return doubanService;
    }

    private OkHttpClient buildOkHttpClient() {
        File cacheDir = new File(mContext.getCacheDir(), "responses");
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }

        Cache cache = new Cache(cacheDir, MAX_CACHE_SIZE);
        OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .addNetworkInterceptor(this::buildInterceptor)
            .cache(cache)
            .build();
        return client;
    }

    private Response buildInterceptor(Interceptor.Chain chain) throws IOException {
        Log.d(TAG, "request intercepted");
        CacheControl cacheControl = null;

        boolean shouldUseCache =  mCallback != null && mCallback.shouldUseCache();

        if (!shouldUseCache) {
            Log.d(TAG, "don't use cache");
            cacheControl = CacheControl.FORCE_NETWORK;
        } else {
            Log.d(TAG, "use cache");
            cacheControl = new CacheControl
                .Builder()
                .onlyIfCached()
                .build();
//                .maxAge(5 * 60, TimeUnit.SECONDS)
//                .maxStale(24 * 7, TimeUnit.HOURS)
        }

        Request request = chain.request()
            .newBuilder()
            .cacheControl(cacheControl)
            .build();

        if (shouldUseCache) {

            return chain.proceed(request)
                .newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public ,max-age=" + 0)
                .build();
        } else {

            final int maxStale = 60 * 60 * 24 * 7;
            return chain.proceed(request)
                .newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public ,only-if-cached, max-stale=" + maxStale)
            .build();
        }

    }
}
interface CacheControlCallback {
    boolean shouldUseCache();
}