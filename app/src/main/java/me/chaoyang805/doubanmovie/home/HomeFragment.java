package me.chaoyang805.doubanmovie.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.data.DoubanMovie;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    private static final String TAG = "HomeFragment";
    private HomeContract.Presenter mPresenter;
    private MoviePagerAdapter mPagerAdapter;

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
        mPagerAdapter = new MoviePagerAdapter(mPresenter, getActivity().getSupportFragmentManager(), new ArrayList<>(0));
        pager.setAdapter(mPagerAdapter);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void showMovies(List<DoubanMovie> movies) {
        mPagerAdapter.replaceData(movies);
    }

    @Override
    public void showLoadingIndicator() {

    }

    @Override
    public void hideLoadingIndicator() {

    }

    @Override
    public void showMoviesDetailUI(DoubanMovie doubanMovie) {
        Log.d(TAG, String.format("movie title:%s", doubanMovie.getTitle()));
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
            Log.d("HomeFragment", "new Fragment");
            return PagerItemFragment.newInstance(mMovies.get(position), mPresenter);
        }

        @Override
        public int getCount() {
            return mMovies.size();
        }

        public void replaceData(List<DoubanMovie> movies) {
            mMovies = movies;
            notifyDataSetChanged();
        }
    }
}
