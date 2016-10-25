package me.chaoyang805.doubanmovie.data.source.remote;

import android.content.Context;
import android.net.Network;
import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.MovieResults;
import me.chaoyang805.doubanmovie.data.source.MoviesDataSource;
import me.chaoyang805.doubanmovie.utils.NetworkUtils;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MoviesRemoteDataSource implements MoviesDataSource, CacheControlCallback {

    private DoubanService mService = null;
    private final Context mAppContext;
    private boolean mCacheIsDirty = true;

    public MoviesRemoteDataSource(Context appContext) {
        mService = RetrofitFactory.getDoubanService(appContext, this);
        mAppContext = appContext;
    }

    public void invalidateCache(boolean invalidate) {
        mCacheIsDirty = invalidate;
    }

    @Override
    public Observable<List<DoubanMovie>> loadMovies(int start, int count) {

        return mService
            .loadMovies("北京", start, count)
            .map(MovieResults::getSubjects);
    }

    @Override
    public Observable<DoubanMovie> getMovie(@NonNull String id) {
        return mService
            .getMovie(id);
    }

    @Override
    public Observable<DoubanCelebrity> getCelebrity(@NonNull String id) {
        return mService
            .getCelebrity(id);
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByTag(@NonNull String tag, int start, int count) {
        return mService
            .searchMoviesByTag(tag, start, count)
            .map(MovieResults::getSubjects);
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByQuery(@NonNull String query, int start, int count) {
        return mService
            .searchMoviesByQuery(query, start, count)
            .map(MovieResults::getSubjects);
    }

    @Override
    public boolean shouldUseCache() {
        // 网络可用的话,根据缓存是否过期判断,缓存过期,就从网络获取,否则使用缓存
        if (NetworkUtils.isNetworkAvailable(mAppContext))
            return !mCacheIsDirty;
        // 网络不可用,直接用缓存喽
        return true;
    }
}
