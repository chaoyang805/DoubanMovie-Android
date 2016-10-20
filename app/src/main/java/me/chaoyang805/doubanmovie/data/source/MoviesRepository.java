package me.chaoyang805.doubanmovie.data.source;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import me.chaoyang805.doubanmovie.Injection;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.MovieResults;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MoviesRepository implements MoviesDataSource {

    public void shouldInvalidateCache(boolean forceUpdate) {

    }

    public List<DoubanMovie> getTasks() {

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        MovieResults results = gson.fromJson(Injection.provideJsonMovies(), MovieResults.class);
        return results.getSubjects();

    }

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
