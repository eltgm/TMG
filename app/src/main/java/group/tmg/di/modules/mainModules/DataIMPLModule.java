package group.tmg.di.modules.mainModules;

import com.octo.android.robospice.SpiceManager;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.storage.StorageImpl;
import group.tmg.di.scopes.DataIMPLScope;
import group.tmg.environment.PreferencesManager;

@Module
public class DataIMPLModule {

    @Provides
    @DataIMPLScope
    public StorageImpl provideMainStorage(PreferencesManager preferencesManager){
        return new StorageImpl(preferencesManager);
    }
}
