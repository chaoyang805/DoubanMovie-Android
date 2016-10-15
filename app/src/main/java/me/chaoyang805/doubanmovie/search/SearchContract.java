package me.chaoyang805.doubanmovie.search;

import java.util.List;

import me.chaoyang805.doubanmovie.BasePresenter;
import me.chaoyang805.doubanmovie.BaseView;
import me.chaoyang805.doubanmovie.data.Movie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public interface SearchContract {

    interface View extends BaseView<Presenter> {
        void showSearchResultsView(List<Movie> searchResults);
    }

    interface Presenter extends BasePresenter {
        void searchMovies(String query);
        void searchMoviesForTag(String tag);
        void setFiltering();

    }
}
