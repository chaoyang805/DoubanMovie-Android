package me.chaoyang805.doubanmovie.moviedetail;

import me.chaoyang805.doubanmovie.data.source.MoviesRepository;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private MoviesRepository mRepository;
    private MovieDetailContract.View mDetailView;

    public MovieDetailPresenter(MoviesRepository repository, MovieDetailContract.View view) {
        mRepository = repository;
        mDetailView = view;
        mDetailView.setPresenter(this);
    }

    @Override
    public void loadMovieDetail(String movieId) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
