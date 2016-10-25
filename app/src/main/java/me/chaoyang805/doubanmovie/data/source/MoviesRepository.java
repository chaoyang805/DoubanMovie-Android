package me.chaoyang805.doubanmovie.data.source;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.remote.MoviesRemoteDataSource;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MoviesRepository implements MoviesDataSource {

    private MoviesRemoteDataSource mRemoteDataSource;

    public MoviesRepository(Context appContext) {
        mRemoteDataSource = new MoviesRemoteDataSource(appContext);
    }

    public void invalidateCache(boolean forceUpdate) {
        mRemoteDataSource.invalidateCache(forceUpdate);
    }

    @Override
    public Observable<List<DoubanMovie>> loadMovies(int start, int count) {
        return mRemoteDataSource
            .loadMovies(start, count)
            .doOnComplete(() -> mRemoteDataSource.invalidateCache(false));
    }

    @Override
    public Observable<DoubanMovie> getMovie(@NonNull String id) {
        return mRemoteDataSource
            .getMovie(id)
            .doOnComplete(() -> mRemoteDataSource.invalidateCache(false));
    }

    @Override
    public Observable<DoubanCelebrity> getCelebrity(@NonNull String id) {
        return mRemoteDataSource
            .getCelebrity(id)
            .doOnComplete(() -> mRemoteDataSource.invalidateCache(false));
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByTag(@NonNull String tag, int start, int count) {
        return mRemoteDataSource
            .searchMoviesByTag(tag, start, count)
            .doOnComplete(() -> invalidateCache(false));
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByQuery(@NonNull String query, int start, int count) {
        return mRemoteDataSource
            .searchMoviesByQuery(query, start, count)
            .doOnComplete(() -> invalidateCache(false));
    }
}
