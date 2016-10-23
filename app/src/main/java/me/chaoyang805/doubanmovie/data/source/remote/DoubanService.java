package me.chaoyang805.doubanmovie.data.source.remote;

import io.reactivex.Observable;
import me.chaoyang805.doubanmovie.data.DoubanCelebrity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.MovieResults;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by chaoyang805 on 16/10/20.
 */

public interface DoubanService {
    @GET("in_theaters")
    Observable<MovieResults> loadMovies(
        @Query("city") String city,
        @Query("start") int start,
        @Query("count") int count
    );

    @GET("search")
    Observable<MovieResults> searchMoviesByQuery(
        @Query("q") String query,
        @Query("start") int start,
        @Query("count") int count
    );

    @GET("search")
    Observable<MovieResults> searchMoviesByTag(
        @Query("tag") String tag,
        @Query("start") int start,
        @Query("count") int count);

    @GET("subject/{id}")
    Observable<DoubanMovie> getMovie(@Path("id") String id);

    @GET("celebrity/{id}")
    Observable<DoubanCelebrity> getCelebrity(@Path("id") String id);


}
