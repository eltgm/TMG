package group.tmg.di.modules.artistsModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.tags.TagsRepository;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.ArtistsInteractor;

@Module
public class InteractorModule {

    @Provides
    @InteractorScope
    public ArtistsInteractor provideArtistsInteractor(TagsRepository tagsRepository) {
        return new ArtistsInteractor(tagsRepository);
    }
}
