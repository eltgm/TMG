package group.tmg.di.modules.loginModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.data.repository.main.MainRepository;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.LoginInteractor;
import group.tmg.interactor.MainInteractor;

@Module
public class InteractorModule {

    @Provides
    @InteractorScope
    public LoginInteractor provideLoginInteractor(LoginRepository loginRepository){
        return new LoginInteractor(loginRepository);
    }
}
