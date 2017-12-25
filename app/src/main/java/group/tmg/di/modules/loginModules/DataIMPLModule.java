package group.tmg.di.modules.loginModules;

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
    public StorageImpl provideLoginStorage(PreferencesManager preferencesManager) {
        return new StorageImpl(preferencesManager);
    }

    @Provides
    @DataIMPLScope
    public LoginRemoteDataSource provideLoginDataSource(SpiceManager spiceManager) {
        return new LoginRemoteDataSource(spiceManager);
    }
}
