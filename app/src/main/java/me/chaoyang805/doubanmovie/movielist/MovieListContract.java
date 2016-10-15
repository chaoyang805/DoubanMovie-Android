package me.chaoyang805.doubanmovie.movielist;

import java.util.List;

import me.chaoyang805.doubanmovie.BasePresenter;
import me.chaoyang805.doubanmovie.BaseView;
import me.chaoyang805.doubanmovie.data.Movie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface MovieListContract {

    interface View extends BaseView<Presenter> {
        void showMovieListView(List<Movie> movies);
        void showLoading();
        void hideLoadingView();
        void showLoadingMoviesError();
    }

    interface Presenter extends BasePresenter {
        void loadMovieList(boolean forceUpdate);
    }
}
