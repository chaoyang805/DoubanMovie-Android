package me.chaoyang805.doubanmovie.data.source.remote;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.MovieResults;
import me.chaoyang805.doubanmovie.data.source.MoviesDataSource;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MoviesRemoteDataSource implements MoviesDataSource {

    private DoubanService mService = null;

    public MoviesRemoteDataSource() {
        mService = DoubanServiceFactory.getDoubanService();
    }

    @Override
    public Observable<List<DoubanMovie>> loadMovies(int start, int count) {

        return mService
            .loadMovies("北京", start, count)
            .map(MovieResults::getSubjects)
            .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<DoubanMovie> getMovie(@NonNull String id) {
        return mService
            .getMovie(id)
            .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<DoubanCelebrity> getCelebrity(@NonNull String id) {
        return mService
            .getCelebrity(id)
            .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByTag(@NonNull String tag, int start, int count) {
        return mService
            .searchMoviesByTag(tag, start, count)
            .map(MovieResults::getSubjects)
            .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByQuery(@NonNull String query, int start, int count) {
        return mService
            .searchMoviesByQuery(query, start, count)
            .map(MovieResults::getSubjects)
            .subscribeOn(Schedulers.io());
    }
}
