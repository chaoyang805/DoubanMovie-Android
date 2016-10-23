package me.chaoyang805.doubanmovie.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;

import me.chaoyang805.doubanmovie.R;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public abstract class ToolbarActivity extends BaseActivity {

    /**
     * Toolbar Click Handler
     */
    public void onToolbarClick() {}

    /**
     * Called by setContentView, let subclass implement this.
     * @return contentView layout resId
     */
    abstract protected int provideContentViewId();

    protected AppBarLayout mAppBar;
    protected Toolbar mToolbar;
    protected boolean mIsHidden = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());

        setupToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        mAppBar = (AppBarLayout) findViewById(R.id.appbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mToolbar == null || mAppBar == null) {
            throw new IllegalStateException(
                "The subclass of ToolbarActivity must contain a toolbar."
            );
        }

        mToolbar.setOnClickListener(v -> onToolbarClick());
        setSupportActionBar(mToolbar);

        if (canBack()) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            mAppBar.setElevation(10.6f);
        }
    }

    /**
     * Is activity can back
     * @return
     */
    public boolean canBack() {
        return false;
    }

    /**
     * set Appbar's alpha
     * @param alpha
     */
    protected void setAppBarAlpha(float alpha) {
        mAppBar.setAlpha(alpha);
    }

    /**
     * hide or show toolbar
     */
    protected void hideOrShowToolbar() {
        mAppBar.animate()
            .translationY(mIsHidden ? 0 : -mAppBar.getHeight())
            .setInterpolator(new DecelerateInterpolator(2))
            .start();
        mIsHidden = !mIsHidden;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }


}
