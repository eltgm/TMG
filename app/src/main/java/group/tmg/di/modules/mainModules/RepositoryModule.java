package group.tmg.di.modules.mainModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.repository.login.LoginRepository;
import group.tmg.data.repository.main.MainRepository;
import group.tmg.data.storage.StorageImpl;
import group.tmg.di.scopes.RepositoryScope;

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public MainRepository provideMainRepository(StorageImpl mainStorage){
        return new MainRepository(mainStorage);
    }

}
