package me.chaoyang805.doubanmovie.favorites;

import java.util.List;

import me.chaoyang805.doubanmovie.BasePresenter;
import me.chaoyang805.doubanmovie.BaseView;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface FavoritesContract {

    interface View extends BaseView<Presenter> {
        void showFavoritesView(List<DoubanMovie> movies);
        void showDeleteSuccessView(String movieId);
        void showAddFavoriteSuccessView(DoubanMovie doubanMovie);
    }

    interface Presenter extends BasePresenter {
        void loadMovies(boolean forceUpdate);
        void deleteMovies(String movieId);
        void addFavoriteMovie(DoubanMovie doubanMovie);
    }
}
