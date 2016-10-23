package me.chaoyang805.doubanmovie.home;

import android.support.annotation.NonNull;

import java.util.List;

import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.MoviesRepository;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class HomePresenter implements HomeContract.Presenter {

    private MoviesRepository mRepository;
    private HomeContract.View mHomeView;

    private boolean mIsFirstLoad = true;
    public HomePresenter(@NonNull MoviesRepository repository, @NonNull HomeContract.View view) {
        mRepository = repository;
        mHomeView = view;
        mHomeView.setPresenter(this);
    }

    @Override
    public void start() {
        loadMovies(false);
    }

    @Override
    public void loadMovies(boolean forceUpdate) {

        loadMovies(forceUpdate || mIsFirstLoad, true);
        mIsFirstLoad = false;
    }

    private void loadMovies(boolean forceUpdate, boolean showLoadingUI) {
        if (showLoadingUI) {
            mHomeView.showLoadingIndicator();
        }
        mRepository.shouldInvalidateCache(forceUpdate);
        List<DoubanMovie> movies = mRepository.getTasks();
        mHomeView.hideLoadingIndicator();
        mHomeView.showMovies(movies);
    }

    @Override
    public void openMovieDetails(DoubanMovie detailDoubanMovie) {
        mHomeView.showMoviesDetailUI(detailDoubanMovie);
    }
}
