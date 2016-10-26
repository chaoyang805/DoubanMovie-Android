package me.chaoyang805.doubanmovie.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.base.DrawerActivity;
import me.chaoyang805.doubanmovie.base.ToolbarActivity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.moviedetail.MovieDetailActivity;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class HomeFragment extends Fragment implements HomeContract.View {

    private static final String TAG = "HomeFragment";
    private HomeContract.Presenter mPresenter;
    private MoviePagerAdapter mPagerAdapter;
    private Toolbar mToolbar;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CoordinatorLayout root = (CoordinatorLayout) inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager pager = (ViewPager) root.findViewById(R.id.view_pager);
        mToolbar = (Toolbar) root.findViewById(R.id.toolbar);
        mPagerAdapter = new MoviePagerAdapter(mPresenter, getActivity().getSupportFragmentManager(), new ArrayList<>(0));
        pager.setAdapter(mPagerAdapter);
        ((ToolbarActivity)getActivity()).setupToolbar(mToolbar);
        ((DrawerActivity)getActivity()).setupDrawerToggle(mToolbar);
        ((DrawerActivity) getActivity()).getSupportActionBar().setTitle("正在热映");

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        Log.d(TAG, "onCreateOptionsMenu");
        inflater.inflate(R.menu.home, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Log.d(TAG, "settings");
            return true;
        } else if (id == R.id.action_refresh) {
            Log.d(TAG, "refresh");
            mPresenter.loadMovies(true);
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        Intent intent = new Intent(getContext(), MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_ID, doubanMovie.getId());
        startActivity(intent);
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
            Log.d(TAG, "replaceData");
            mMovies = movies;
            notifyDataSetChanged();
        }
    }
}
