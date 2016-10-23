package me.chaoyang805.doubanmovie.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import me.chaoyang805.doubanmovie.R;

/**
 * Created by chaoyang805 on 16/10/23.
 */

public abstract class DrawerActivity extends ToolbarActivity {

    @LayoutRes
    protected int mContentViewId = R.layout.activity_home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(onSetNavigationItemListener());

    }


    @Override
    protected int provideContentViewId() {
        return mContentViewId;
    }

    protected abstract NavigationView.OnNavigationItemSelectedListener onSetNavigationItemListener();

}
