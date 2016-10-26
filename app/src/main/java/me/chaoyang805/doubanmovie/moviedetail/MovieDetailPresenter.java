package me.chaoyang805.doubanmovie.moviedetail;

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

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    private static final String TAG = "MovieDetailPresenter";

    private MoviesRepository mRepository;
    private MovieDetailContract.View mDetailView;
    private CompositeDisposable mCompositeDisposable;
    private String mMovieId;

    public MovieDetailPresenter(String movieId, MoviesRepository repository, MovieDetailContract.View view) {
        mRepository = repository;
        mDetailView = view;
        mDetailView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
        mMovieId = movieId;
    }

    @Override
    public void loadMovieDetail() {
        Disposable disposable = mRepository.getMovie(mMovieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                mDetailView::showMovieDetailView,
                Throwable::printStackTrace,
                () -> Log.d(TAG, "load movie complete")
            );
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void shareMovie(DoubanMovie movie) {
        Log.d(TAG, "share movie");
    }

    @Override
    public void subscribe() {
        loadMovieDetail();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
