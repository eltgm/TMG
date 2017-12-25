package group.tmg.view;


import android.support.design.widget.NavigationView;

import java.util.List;

import group.tmg.data.model.Tag;

public interface MainView extends NavigationView.OnNavigationItemSelectedListener {
    void initMenu(List<Tag> artists);

    //TODO струткура данных
    void showHome();

    //TODO добавить экраны, которые будет отображать изображение
    void showError(String error);
}
