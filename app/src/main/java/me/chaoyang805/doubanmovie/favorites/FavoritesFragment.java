package me.chaoyang805.doubanmovie.favorites;

import android.app.Fragment;
import android.os.Bundle;

import java.util.List;

import me.chaoyang805.doubanmovie.data.Movie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class FavoritesFragment extends Fragment implements FavoritesContract.View {

    private FavoritesContract.Presenter mPresenter;

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Override
    public void showFavoritesView(List<Movie> movies) {

    }

    @Override
    public void showDeleteSuccessView(String movieId) {

    }

    @Override
    public void showAddFavoriteSuccessView(Movie movie) {

    }

    @Override
    public void setPresenter(FavoritesContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
