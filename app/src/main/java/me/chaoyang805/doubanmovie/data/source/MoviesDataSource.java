package me.chaoyang805.doubanmovie.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Observable;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface MoviesDataSource {

    Observable<List<DoubanMovie>> loadMovies(int start, int count);

    Observable<DoubanMovie> getMovie(@NonNull String id);

    Observable<DoubanCelebrity> getCelebrity(@NonNull String id);

    Observable<List<DoubanMovie>> searchMoviesByTag(@NonNull String tag, int start, int count);

    Observable<List<DoubanMovie>> searchMoviesByQuery(@NonNull String query, int start, int count);

}
