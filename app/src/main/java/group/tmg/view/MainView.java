package group.tmg.view;


import android.support.design.widget.NavigationView;

import group.tmg.data.model.User;

public interface MainView extends NavigationView.OnNavigationItemSelectedListener {
    void initMenu(User user);

    void showGeneral();

    //TODO добавить экраны, которые будет отображать изображение
}
