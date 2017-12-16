package group.tmg.ui.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import javax.inject.Inject;

import group.tmg.App;
import group.tmg.R;
import group.tmg.data.model.User;
import group.tmg.presenter.MainPresenter;
import group.tmg.ui.fragment.GeneralFragment;
import group.tmg.view.MainView;

public class MainActivity extends BaseActivity<MainPresenter>
        implements MainView{

    @Inject
    MainPresenter presenter;

    DrawerLayout drawer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = super.instantiatePresenter();

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        //presenter.onMainStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void initMenu(User user) {
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void initView(){
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void showGeneral() {
        android.support.v4.app.FragmentTransaction ftGeneral = getSupportFragmentManager().beginTransaction();
        GeneralFragment gf = new GeneralFragment();
        ftGeneral.replace(R.id.flMain, gf);
        drawer.closeDrawers();
        ftGeneral.commit();
    }

    @Override
    protected MainPresenter providePresenter() {
        App.getPresenterComponent().inject(this);

        return presenter;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        presenter.onNavigationItemSelected(id);

        return true;
    }
}
