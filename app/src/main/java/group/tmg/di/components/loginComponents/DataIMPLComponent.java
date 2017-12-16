package group.tmg.di.components.loginComponents;

import com.octo.android.robospice.SpiceManager;

import dagger.Component;
import group.tmg.data.repository.login.LoginRemoteDataSource;
import group.tmg.data.storage.StorageImpl;
import group.tmg.di.modules.loginModules.DataIMPLModule;
import group.tmg.di.scopes.DataIMPLScope;
import group.tmg.environment.PreferencesManager;

@Component(dependencies = DataComponent.class, modules = {DataIMPLModule.class})
@DataIMPLScope
public interface DataIMPLComponent {

    PreferencesManager preferencesManager();

    SpiceManager spiceManager();

    LoginRemoteDataSource loginDataSource();

    StorageImpl loginStorage();
}
