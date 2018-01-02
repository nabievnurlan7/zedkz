package info.qazaq.qazaqinfo.presentation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import info.qazaq.qazaqinfo.R;
import info.qazaq.qazaqinfo.data.cache.Cache;
import info.qazaq.qazaqinfo.data.cache.CacheImpl;
import info.qazaq.qazaqinfo.data.entity.mapper.Mapper;
import info.qazaq.qazaqinfo.data.repositry.DataRepository;
import info.qazaq.qazaqinfo.data.repositry.datasource.DataStoreFactory;
import info.qazaq.qazaqinfo.domain.interactor.GetNewsList;
import info.qazaq.qazaqinfo.presentation.model.PresentationModel;
import info.qazaq.qazaqinfo.presentation.model.mapper.ModelMapper;
import info.qazaq.qazaqinfo.presentation.presenter.NewsPresenter;
import info.qazaq.qazaqinfo.presentation.view.NewsView;
import info.qazaq.qazaqinfo.presentation.view.adapter.Adapter;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, NewsView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    LinearLayout toolbarLayout;
    @BindView(R.id.nav_header)
    LinearLayout navHeader;
    @BindView(R.id.menuItem)
    LinearLayout menuNews;
    @BindView(R.id.menuAbout)
    LinearLayout menuAbout;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.rclvNews)
    RecyclerView rclvNews;
    @BindView(R.id.progress)
    ProgressBar progress;

    private ActionBar actionBar;
    private Adapter adapter;
    private NewsPresenter newsPresenter;
    private GetNewsList getNewsList;
    private ModelMapper modelMapper;
    private DataRepository newsDataRepository;
    private Mapper mapper;
    private DataStoreFactory dataStoreFactory;
    private Cache cache;

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContext = getApplicationContext();

        initToolbar();
        initDrawerMenu();

        adapter = new Adapter();
        rclvNews.setLayoutManager(new LinearLayoutManager(this));
        rclvNews.setAdapter(adapter);

        modelMapper = new ModelMapper();
        mapper = new Mapper();
        cache = new CacheImpl(mContext);
        dataStoreFactory = new DataStoreFactory(cache);
        newsDataRepository = new DataRepository(dataStoreFactory, mapper);
        getNewsList = new GetNewsList(newsDataRepository);

        newsPresenter = new NewsPresenter(getNewsList, modelMapper);
        newsPresenter.setNewsView(this);
        newsPresenter.initialize();
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

    }

    private void initDrawerMenu() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                hideKeyboard();
                super.onDrawerOpened(drawerView);
            }
        };

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View menuView = navigationView.getRootView();
        drawer.openDrawer(Gravity.LEFT);
    }

    private void closeDrawer() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    @Override
    public void onRefresh()
    {
        newsPresenter.initialize();
    }

    @Override
    public void showLoading()
    {
        rclvNews.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
//        error.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading()
    {
        rclvNews.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);

//        error.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage)
    {
        rclvNews.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
//        error.setVisibility(View.VISIBLE);
//        error.setText(errorMessage);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void renderNewsList(List<PresentationModel> newslist)
    {
        adapter.setNews(newslist, mContext);
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        newsPresenter.resume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        newsPresenter.pause();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        newsPresenter.destroy();
    }

    @OnClick(R.id.menuItem)
    public void task() {
        actionBar.setTitle("Менюшка");
        closeDrawer();
    }
}