package me.chaoyang805.doubanmovie.data.source;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import me.chaoyang805.doubanmovie.Injection;
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
}
