package group.tmg.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import group.tmg.App;
import group.tmg.R;
import group.tmg.data.model.Tag;
import group.tmg.presenter.MainPresenter;
import group.tmg.tools.ConnectivityReceiver;
import group.tmg.ui.fragment.HomeFragment;
import group.tmg.view.MainView;

public class MainActivity extends BaseActivity<MainPresenter>
        implements MainView {
    private static ConnectivityReceiver receiver;
    @Inject
    MainPresenter presenter;
    DrawerLayout drawer;

    public static ConnectivityReceiver getReceiver() {
        return receiver;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new ConnectivityReceiver(this);
        receiver.registerReceiver();

        presenter = super.instantiatePresenter();

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void initMenu(List<Tag> tags) {
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Menu menu = navigationView.getMenu();

        SubMenu subMenuEdit = menu.addSubMenu(R.string.all_artist);
        subMenuEdit.add(Menu.NONE, 0, Menu.NONE, R.string.add_artist);
        int count = 1;
        for (Tag tag
                : tags) {
            subMenuEdit.add(Menu.NONE, count, Menu.NONE, tag.getName());
            count++;
        }

        showHome();
    }

    public void initView() {

    }

    @Override
    public void showHome() {
        android.support.v4.app.FragmentTransaction ftGeneral = getSupportFragmentManager().beginTransaction();
        HomeFragment gf = new HomeFragment();
        ftGeneral.replace(R.id.flMain, gf);
        drawer.closeDrawers();
        ftGeneral.commit();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        receiver.unregisterReceiver();
    }
}
