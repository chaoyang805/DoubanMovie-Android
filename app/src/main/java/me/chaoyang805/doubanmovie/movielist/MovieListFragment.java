package me.chaoyang805.doubanmovie.movielist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MovieListFragment extends Fragment implements MovieListContract.View {

    private MovieListContract.Presenter mPresenter;

    public static MovieListFragment newInstance() {
        return new MovieListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movielist, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
//        mPresenter.start();
    }

    @Override
    public void showMovieListView(List<DoubanMovie> movies) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void showLoadingMoviesError() {

    }

    @Override
    public void setPresenter(MovieListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
