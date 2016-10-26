package me.chaoyang805.doubanmovie.favorites;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class FavoritesFragment extends Fragment implements FavoritesContract.View {

    private FavoritesContract.Presenter mPresenter;

    public static FavoritesFragment newInstance() {
        return new FavoritesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void showFavoritesView(List<DoubanMovie> movies) {

    }

    @Override
    public void showDeleteSuccessView(String movieId) {

    }

    @Override
    public void showAddFavoriteSuccessView(DoubanMovie doubanMovie) {

    }

    @Override
    public void setPresenter(FavoritesContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
