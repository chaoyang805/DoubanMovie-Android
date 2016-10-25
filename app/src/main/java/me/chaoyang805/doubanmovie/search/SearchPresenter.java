package me.chaoyang805.doubanmovie.search;

import android.support.annotation.NonNull;

import me.chaoyang805.doubanmovie.data.source.MoviesRepository;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private MoviesRepository mRepository;
    private SearchContract.View mSearchView;

    public SearchPresenter(@NonNull MoviesRepository repository, SearchContract.View view) {
        mRepository = repository;
        mSearchView = view;
        mSearchView.setPresenter(this);
    }

    @Override
    public void searchMovies(String query) {

    }

    @Override
    public void searchMoviesForTag(String tag) {

    }

    @Override
    public void setFiltering() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
