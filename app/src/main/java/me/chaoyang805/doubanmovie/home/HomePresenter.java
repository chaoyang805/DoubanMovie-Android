package me.chaoyang805.doubanmovie.home;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.MoviesRepository;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class HomePresenter implements HomeContract.Presenter {

    private static final String TAG = "HomePresenter";

    private MoviesRepository mRepository;
    private HomeContract.View mHomeView;
    private CompositeDisposable mCompositeDisposables;
    private boolean mIsFirstLoad = true;

    public HomePresenter(@NonNull MoviesRepository repository, @NonNull HomeContract.View view) {
        mRepository = repository;
        mHomeView = view;
        mHomeView.setPresenter(this);
        mCompositeDisposables = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        loadMovies(false);
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposables.clear();
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
        mRepository.invalidateCache(forceUpdate);

        Disposable disposable = mRepository
            .loadMovies(0, 5)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(movies -> {
                mHomeView.hideLoadingIndicator();
                Log.d(TAG, "show movies");
                mHomeView.showMovies(movies);
            }, throwable -> {
                mHomeView.hideLoadingIndicator();
                mHomeView.showLoadingMoviesError();
                throwable.printStackTrace();
            }, () -> {
                Log.d(TAG, "load movies complete");
            });

        mCompositeDisposables.add(disposable);
    }

    @Override
    public void openMovieDetails(DoubanMovie detailDoubanMovie) {
        mHomeView.showMoviesDetailUI(detailDoubanMovie);
    }
}
