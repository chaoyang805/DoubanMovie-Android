package me.chaoyang805.doubanmovie.home;

import me.chaoyang805.doubanmovie.BasePresenter;
import me.chaoyang805.doubanmovie.BaseView;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showMovies();
        void showMoviesDetailUI(DoubanMovie doubanMovie);
        void showLoadingMoviesError();
        boolean isActive();
    }

    interface Presenter extends BasePresenter {
        void loadMovies(boolean forceUpdate);
        void openMovieDetails(DoubanMovie detailDoubanMovie);
    }
}
