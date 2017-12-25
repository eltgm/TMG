package group.tmg.di.modules;

import android.content.Context;

import com.octo.android.robospice.SpiceManager;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.network.TMGSpiceService;
import group.tmg.di.scopes.DataScope;
import group.tmg.environment.PreferencesManager;

@Module
public class DataModule {

    @Provides
    @DataScope
    public PreferencesManager providePreferencesManager(Context context) {
        return new PreferencesManager(context);
    }

    @Provides
    @DataScope
    public SpiceManager provideSpiceManager() {
        return new SpiceManager(TMGSpiceService.class);
    }
}
