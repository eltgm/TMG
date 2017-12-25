package group.tmg.di.modules.tagModules;

import com.octo.android.robospice.SpiceManager;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.tags.TagsLocalDataSource;
import group.tmg.data.repository.tags.TagsRemoteDataSource;
import group.tmg.di.scopes.DataIMPLScope;

@Module
public class DataIMPLModule {

    @Provides
    @DataIMPLScope
    public TagsRemoteDataSource provideTagsRemoteDataSource(SpiceManager spiceManager) {
        return new TagsRemoteDataSource(spiceManager);
    }


    @Provides
    @DataIMPLScope
    public TagsLocalDataSource provideTagsLocalDataSource() {
        return new TagsLocalDataSource();
        //TODO суда передать для бд
    }
}
