package me.chaoyang805.doubanmovie.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.chaoyang805.doubanmovie.data.Movie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    private HomeContract.Presenter mPresenter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void showMovies() {

    }

    @Override
    public void showMoviesDetailUI(Movie movie) {

    }

    @Override
    public void showLoadingMoviesError() {

    }

    @Override
    public boolean isActive() {
        return false;
    }
}
