package group.tmg.di.modules.mainModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.interactor.LoginInteractor;
import group.tmg.interactor.MainInteractor;
import group.tmg.presenter.LoginPresenter;
import group.tmg.presenter.MainPresenter;

@Module
public class PresenterModule {

    @Provides
    @PresenterScope
    public MainPresenter provideMainPresenter(MainInteractor mainInteractor){
        return new MainPresenter(mainInteractor);
    }
}
