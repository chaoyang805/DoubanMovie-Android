package me.chaoyang805.doubanmovie.home;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.base.DrawerActivity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.MoviesRepository;
import me.chaoyang805.doubanmovie.data.source.remote.MoviesRemoteDataSource;
import me.chaoyang805.doubanmovie.favorites.FavoritesFragment;
import me.chaoyang805.doubanmovie.movielist.MovieListFragment;
import me.chaoyang805.doubanmovie.search.SearchFragment;
import me.chaoyang805.doubanmovie.utils.ActivityUtils;

public class HomeActivity extends DrawerActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHomePage();

    }

    @Override
    protected NavigationView.OnNavigationItemSelectedListener onSetNavigationItemListener() {
        return this;
    }


    private void testNetwork() {
        MoviesRemoteDataSource remoteDataSource = new MoviesRemoteDataSource();
        Disposable disposable = remoteDataSource.loadMovies(0, 5)
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap(Observable::fromIterable)
            .subscribe(this::showMovie, Throwable::printStackTrace);
    }

    private void showMovie(DoubanMovie movie) {
        Log.d("HomeActivity", movie.getTitle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (!popFragmentIfNeeded()){
            finish();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all) {
            showMovieListPage();
        } else if (id == R.id.nav_now) {
            showHomePage();
        } else if (id == R.id.nav_search) {
            showSearchPage();
        } else if (id == R.id.nav_favorite) {
            showFavoritePage();
        } else if (id == R.id.nav_settings) {
            showSettings();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @IdRes
    private final int mContainer = R.id.content_frame;

    private final Fragment[] mManagedFragments = new Fragment[4];

    private void showMovieListPage() {

        popFragmentIfNeeded();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = getMovieListFragment();
        ActivityUtils.addFragmentToActivity(fm, fragment, mContainer);
        mToolbar.setTitle(R.string.title_movielist);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mToolbar.setTitle(R.string.title_now);
    }

    private void showHomePage() {
        popFragmentIfNeeded();
        Fragment homeFragment = mManagedFragments[0];
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homeFragment, R.id.content_frame);
            mManagedFragments[0] = homeFragment;
        }
        mPresenter = new HomePresenter(new MoviesRepository(), (HomeFragment)homeFragment);
        mToolbar.setTitle(R.string.title_now);

    }

    private void showSearchPage() {
        popFragmentIfNeeded();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = getSearchFragment();
        ActivityUtils.addFragmentToActivity(fm, fragment, mContainer);
        mToolbar.setTitle(R.string.title_search);
    }

    private void showFavoritePage() {
        popFragmentIfNeeded();
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = getFavoriteFragment();
        ActivityUtils.addFragmentToActivity(fm, fragment, mContainer);
        mToolbar.setTitle(R.string.title_favorite);

    }

    private void showSettings() {

    }

    private boolean popFragmentIfNeeded() {
        int stackCount = getSupportFragmentManager().getBackStackEntryCount();
        Log.d("HomeActivity", "StackCount:" + stackCount);
        if (stackCount >= 2) {
            getSupportFragmentManager().popBackStack();
            return true;
        }
        return false;
    }
    // home  all search favorite
    @NonNull
    private Fragment getMovieListFragment() {
        Fragment f = mManagedFragments[1];
        if (f == null) {
            f = MovieListFragment.newInstance();
            mManagedFragments[1] = f;
        }
        return f;
    }

    private Fragment getSearchFragment() {
        Fragment f = mManagedFragments[2];
        if (f == null) {
            f = SearchFragment.newInstance();
            mManagedFragments[2] = f;

        }
        return f;
    }
    private Fragment getFavoriteFragment() {
        Fragment f = mManagedFragments[3];
        if (f == null) {

            f = FavoritesFragment.newInstance();
            mManagedFragments[3] = f;
        }
        return f;
    }
}
