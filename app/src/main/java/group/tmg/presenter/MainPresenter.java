package group.tmg.presenter;

import group.tmg.R;
import group.tmg.data.model.User;
import group.tmg.data.repository.main.MainDataSource;
import group.tmg.interactor.MainInteractor;
import group.tmg.view.MainView;

import static group.tmg.App.USER_REQUEST_TAG;

public class MainPresenter extends BasePresenter<MainView>{

    private final MainInteractor mainInteractor;

    public MainPresenter(MainInteractor mainInteractor){
        this.mainInteractor = mainInteractor;
    }

    @Override
    void onViewAttach() {
        super.onViewAttach();
    }

    @Override
    void onDestroy() {
        super.onDestroy();
    }

    public void onMainStart(){
        mainInteractor.getUser(new MainDataSource.MainCallback() {
            @Override
            public void onLoadCompleted(User user) {
                getView().initMenu(user);
            }

            @Override
            public void onLoadError(String error) {

            }
        });
    }

    public void onNavigationItemSelected(int id){
        switch (id){
            case R.id.general:
                getView().showGeneral();
                break;
        }
    }
}
