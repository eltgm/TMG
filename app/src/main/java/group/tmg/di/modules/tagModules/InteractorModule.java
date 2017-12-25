package group.tmg.di.modules.tagModules;

import dagger.Module;
import dagger.Provides;
import group.tmg.data.repository.tags.TagsRepository;
import group.tmg.di.scopes.InteractorScope;
import group.tmg.interactor.TagInteractor;

@Module
public class InteractorModule {
    @Provides
    @InteractorScope
    public TagInteractor provideArtistsInteractor(TagsRepository tagsRepository) {
        return new TagInteractor(tagsRepository);
    }
}
