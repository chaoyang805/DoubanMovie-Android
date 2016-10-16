package me.chaoyang805.doubanmovie.home;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

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
        LinearLayout root = (LinearLayout) inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager pager = (ViewPager) root.findViewById(R.id.view_pager);
//        pager.setAdapter();
        return root;
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
    public void showMoviesDetailUI(DoubanMovie doubanMovie) {

    }

    @Override
    public void showLoadingMoviesError() {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    static class MoviePagerAdapter extends FragmentPagerAdapter {

        private HomeContract.Presenter mPresenter;
        private List<DoubanMovie> mMovies;
        public MoviePagerAdapter(HomeContract.Presenter presenter, FragmentManager fm, List<DoubanMovie> movies) {
            super(fm);
            mPresenter = presenter;
            mMovies = movies;
        }

        @Override
        public Fragment getItem(int position) {

            return new PagerItemFragment();
        }

        @Override
        public int getCount() {
            return mMovies.size();
        }
    }
}
