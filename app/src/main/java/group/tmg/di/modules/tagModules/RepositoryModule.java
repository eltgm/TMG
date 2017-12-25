package group.tmg.di.modules.tagModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.tags.TagsLocalDataSource;
import group.tmg.data.repository.tags.TagsRemoteDataSource;
import group.tmg.data.repository.tags.TagsRepository;
import group.tmg.di.scopes.RepositoryScope;

@Module
public class RepositoryModule {

    @Provides
    @RepositoryScope
    public TagsRepository provideArtistsRepository(TagsRemoteDataSource tagsRemoteDataSource, TagsLocalDataSource tagsLocalDataSource) {
        return new TagsRepository(tagsRemoteDataSource, tagsLocalDataSource);
    }
}
