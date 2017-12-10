package group.tmg.di.modules.loginModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.di.scopes.PresenterScope;
import group.tmg.interactor.LoginInteractor;
import group.tmg.presenter.LoginPresenter;

@Module
public class PresenterModule {

    @Provides
    @PresenterScope
    public LoginPresenter provideLoginPresenter(LoginInteractor loginInteractor){
        return new LoginPresenter(loginInteractor);
    }
}
