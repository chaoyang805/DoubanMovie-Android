package me.chaoyang805.doubanmovie.home;

import android.databinding.DataBindingUtil;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.databinding.FragmentPagerItemBinding;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class PagerItemFragment extends Fragment {

    private DoubanMovie mMovie;
    private HomeContract.Presenter mActionHandler;
    public static PagerItemFragment newInstance(DoubanMovie movie, HomeContract.Presenter presenter) {
        PagerItemFragment fragment = new PagerItemFragment();
        fragment.setMovie(movie);
        fragment.setActionHandler(presenter);
        return fragment;
    }

    private void setActionHandler(HomeContract.Presenter actionHandler) {
        mActionHandler = actionHandler;
    }

    private void setMovie(DoubanMovie  movie) {
        this.mMovie = movie;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPagerItemBinding binding = FragmentPagerItemBinding.inflate(inflater);
        binding.setMovie(mMovie);
        binding.setActionHandler(mActionHandler);
        return binding.getRoot();
    }
}
