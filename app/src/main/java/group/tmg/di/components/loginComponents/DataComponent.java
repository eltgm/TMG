package group.tmg.di.components.loginComponents;

import android.content.Context;

import com.octo.android.robospice.SpiceManager;

import dagger.Component;
import group.tmg.ContextComponent;
import group.tmg.di.modules.loginModules.DataModule;
import group.tmg.di.scopes.DataScope;
import group.tmg.environment.PreferencesManager;

@Component(dependencies = ContextComponent.class, modules = {DataModule.class})
@DataScope
public interface DataComponent {
    Context context();

    PreferencesManager preferencesManager();

    SpiceManager spiceManager();
}
