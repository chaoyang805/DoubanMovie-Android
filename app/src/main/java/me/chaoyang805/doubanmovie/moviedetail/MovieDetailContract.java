package me.chaoyang805.doubanmovie.moviedetail;

import me.chaoyang805.doubanmovie.BasePresenter;
import me.chaoyang805.doubanmovie.BaseView;
import me.chaoyang805.doubanmovie.data.Movie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface MovieDetailContract {

    interface View extends BaseView<Presenter> {
        void showMovieDetailView(Movie movie);
    }

    interface Presenter extends BasePresenter {
        void loadMovieDetail(String movieId);
    }
}
