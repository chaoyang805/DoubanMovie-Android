package me.chaoyang805.doubanmovie.favorites;

import java.util.List;

import me.chaoyang805.doubanmovie.BasePresenter;
import me.chaoyang805.doubanmovie.BaseView;
import me.chaoyang805.doubanmovie.data.Movie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface FavoritesContract {

    interface View extends BaseView<Presenter> {
        void showFavoritesView(List<Movie> movies);
        void showDeleteSuccessView(String movieId);
        void showAddFavoriteSuccessView(Movie movie);
    }

    interface Presenter extends BasePresenter {
        void loadMovies(boolean forceUpdate);
        void deleteMovies(String movieId);
        void addFavoriteMovie(Movie movie);
    }
}
