package me.chaoyang805.doubanmovie.data.source.local;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.MoviesDataSource;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MoviesLocalDataSource implements MoviesDataSource {
    @Override
    public Observable<List<DoubanMovie>> loadMovies(int start, int count) {
        return null;
    }

    @Override
    public Observable<DoubanMovie> getMovie(@NonNull String id) {
        return null;
    }

    @Override
    public Observable<DoubanCelebrity> getCelebrity(@NonNull String id) {
        return null;
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByTag(@NonNull String tag, int start, int count) {
        return null;
    }

    @Override
    public Observable<List<DoubanMovie>> searchMoviesByQuery(@NonNull String query, int start, int count) {
        return null;
    }
}
