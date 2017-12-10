package group.tmg.di.modules.loginModules;

import com.octo.android.robospice.SpiceManager;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.storage.LoginStorageImpl;
import group.tmg.di.scopes.DataIMPLScope;
import group.tmg.environment.PreferencesManager;

@Module
public class DataIMPLModule {

    @Provides
    @DataIMPLScope
    public LoginStorageImpl provideLoginStorage(PreferencesManager preferencesManager){
        return new LoginStorageImpl(preferencesManager);
    }

    @Provides
    @DataIMPLScope
    public LoginRemoteDataSource provideLoginDataSource(SpiceManager spiceManager){
        return new LoginRemoteDataSource(spiceManager);
    }
}
