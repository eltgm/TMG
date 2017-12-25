package group.tmg.di.modules.loginModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.data.storage.StorageImpl;
import group.tmg.di.scopes.RepositoryScope;

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public LoginRepository provideLoginRepository(LoginRemoteDataSource loginDataSource,
                                                  StorageImpl loginStorage) {
        return new LoginRepository(loginDataSource, loginStorage);
    }
}
