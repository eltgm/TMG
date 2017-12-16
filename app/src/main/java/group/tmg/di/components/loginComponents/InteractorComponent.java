package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.data.repository.main.MainRepository;
import group.tmg.di.modules.loginModules.InteractorModule;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.LoginInteractor;
import group.tmg.interactor.MainInteractor;

@Component(dependencies = RepositoryComponent.class, modules = {InteractorModule.class,
        group.tmg.di.modules.mainModules.InteractorModule.class})
@InteractorScope
public interface InteractorComponent {

    LoginRepository loginRepository();

    LoginInteractor loginInteractor();

    MainRepository mainRepository();

    MainInteractor mainInteractor();
}
