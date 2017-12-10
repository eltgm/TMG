package group.tmg.di.components.loginComponents;

import dagger.Component;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.data.storage.LoginStorageImpl;
import group.tmg.di.modules.loginModules.RepositoryModule;
import group.tmg.di.scopes.RepositoryScope;

@Component(dependencies = DataIMPLComponent.class, modules = {RepositoryModule.class})
@RepositoryScope
public interface RepositoryComponent {

    LoginRemoteDataSource loginDataSource();

    LoginStorageImpl loginStorage();

    LoginRepository loginRepository();
}
