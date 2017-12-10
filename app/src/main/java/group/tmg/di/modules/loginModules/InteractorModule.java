package group.tmg.di.modules.loginModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.LoginInteractor;

@Module
public class InteractorModule {

    @Provides
    @InteractorScope
    public LoginInteractor provideLoginInteractor(LoginRepository loginRepository){
        return new LoginInteractor(loginRepository);
    }
}
