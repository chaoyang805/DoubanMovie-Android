package me.chaoyang805.doubanmovie.home;

import android.content.Loader;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.Realm;
import me.chaoyang805.doubanmovie.R;
import me.chaoyang805.doubanmovie.base.ToolbarActivity;
import me.chaoyang805.doubanmovie.data.DoubanMovie;
import me.chaoyang805.doubanmovie.data.source.MoviesRepository;
import me.chaoyang805.doubanmovie.utils.ActivityUtils;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends ToolbarActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    private HomePresenter mPresenter;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        HomeFragment homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (homeFragment == null) {
            homeFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), homeFragment, R.id.content_frame);
        }
        mPresenter = new HomePresenter(new MoviesRepository(), homeFragment);
        testGson();
    }

    private void testGson() {

        String jsonString = "{\n" +
            "    \"rating\": {\n" +
            "        \"max\": 10,\n" +
            "        \"average\": 8.2,\n" +
            "        \"stars\": \"40\",\n" +
            "        \"min\": 0\n" +
            "    },\n" +
            "    \"genres\": [\n" +
            "        \"动作\",\n" +
            "        \"犯罪\"\n" +
            "    ],\n" +
            "    \"title\": \"湄公河行动\",\n" +
            "    \"casts\": [\n" +
            "        {\n" +
            "            \"alt\": \"https://movie.douban.com/celebrity/1274319/\",\n" +
            "            \"avatars\": {\n" +
            "                \"small\": \"https://img1.doubanio.com/img/celebrity/small/49047.jpg\",\n" +
            "                \"large\": \"https://img1.doubanio.com/img/celebrity/large/49047.jpg\",\n" +
            "                \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/49047.jpg\"\n" +
            "            },\n" +
            "            \"name\": \"张涵予\",\n" +
            "            \"id\": \"1274319\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"alt\": \"https://movie.douban.com/celebrity/1013782/\",\n" +
            "            \"avatars\": {\n" +
            "                \"small\": \"https://img3.doubanio.com/img/celebrity/small/1368156632.65.jpg\",\n" +
            "                \"large\": \"https://img3.doubanio.com/img/celebrity/large/1368156632.65.jpg\",\n" +
            "                \"medium\": \"https://img3.doubanio.com/img/celebrity/medium/1368156632.65.jpg\"\n" +
            "            },\n" +
            "            \"name\": \"彭于晏\",\n" +
            "            \"id\": \"1013782\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"alt\": \"https://movie.douban.com/celebrity/1274640/\",\n" +
            "            \"avatars\": {\n" +
            "                \"small\": \"https://img1.doubanio.com/img/celebrity/small/5979.jpg\",\n" +
            "                \"large\": \"https://img1.doubanio.com/img/celebrity/large/5979.jpg\",\n" +
            "                \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/5979.jpg\"\n" +
            "            },\n" +
            "            \"name\": \"孙淳\",\n" +
            "            \"id\": \"1274640\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"collect_count\": 171100,\n" +
            "    \"original_title\": \"湄公河行动\",\n" +
            "    \"subtype\": \"movie\",\n" +
            "    \"directors\": [\n" +
            "        {\n" +
            "            \"alt\": \"https://movie.douban.com/celebrity/1275075/\",\n" +
            "            \"avatars\": {\n" +
            "                \"small\": \"https://img1.doubanio.com/img/celebrity/small/1372934445.18.jpg\",\n" +
            "                \"large\": \"https://img1.doubanio.com/img/celebrity/large/1372934445.18.jpg\",\n" +
            "                \"medium\": \"https://img1.doubanio.com/img/celebrity/medium/1372934445.18.jpg\"\n" +
            "            },\n" +
            "            \"name\": \"林超贤\",\n" +
            "            \"id\": \"1275075\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"year\": \"2016\",\n" +
            "    \"images\": {\n" +
            "        \"small\": \"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2380677316.jpg\",\n" +
            "        \"large\": \"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2380677316.jpg\",\n" +
            "        \"medium\": \"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p2380677316.jpg\"\n" +
            "    },\n" +
            "    \"alt\": \"https://movie.douban.com/subject/25815034/\",\n" +
            "    \"id\": \"25815034\"\n" +
            "}";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        DoubanMovie movie = gson.fromJson(jsonString, DoubanMovie.class);
        movie.getTitle();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
