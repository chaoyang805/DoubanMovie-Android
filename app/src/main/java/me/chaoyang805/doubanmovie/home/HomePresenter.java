package me.chaoyang805.doubanmovie.home;

import android.support.annotation.NonNull;

import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.MoviesRepository;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class HomePresenter implements HomeContract.Presenter {

    private MoviesRepository mRepository;
    private HomeContract.View mHomeView;

    public HomePresenter(@NonNull MoviesRepository repository, @NonNull HomeContract.View view) {
        mRepository = repository;
        mHomeView = view;
        mHomeView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loadMovies(boolean forceUpdate) {

    }

    @Override
    public void openMovieDetails(DoubanMovie detailDoubanMovie) {

    }
}
