package me.chaoyang805.doubanmovie.moviedetail;

import android.os.Bundle;
import android.support.annotation.Nullable;

import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.base.ToolbarActivity;
import me.chaoyang805.doubanmovie.data.source.MoviesRepository;
import me.chaoyang805.doubanmovie.utils.ActivityUtils;

/**
 * Created by chaoyang805 on 16/10/15.
 */

public class MovieDetailActivity extends ToolbarActivity {

    public static final String EXTRA_MOVIE_ID = "movie_id";

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_detail;
    }

    @Override
    public boolean canBack() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MovieDetailFragment detailFragment = MovieDetailFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), detailFragment, R.id.content_frame);

        String movieId = getIntent().getStringExtra(EXTRA_MOVIE_ID);
        new MovieDetailPresenter(movieId, MoviesRepository.getInstance(getApplicationContext()), detailFragment);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
