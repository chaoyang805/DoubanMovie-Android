package me.chaoyang805.doubanmovie.movielist;

import android.support.annotation.NonNull;

import me.chaoyang805.doubanmovie.data.source.MoviesRepository;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MovieListPresenter implements MovieListContract.Presenter {

    private MoviesRepository mRepository;
    private MovieListContract.View mMovieListView;

    public MovieListPresenter(@NonNull MoviesRepository repository, @NonNull MovieListContract.View view) {
        mRepository = repository;
        mMovieListView = view;
        mMovieListView.setPresenter(this);
    }

    @Override
    public void loadMovieList(boolean forceUpdate) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
