package me.chaoyang805.doubanmovie.moviedetail;

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

public class MovieDetailFragment extends Fragment implements MovieDetailContract.View {

    private MovieDetailContract.Presenter mPresenter;

    public static MovieDetailFragment newInstance() {
        return new MovieDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showMovieDetailView(Movie movie) {

    }

    @Override
    public void setPresenter(MovieDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
