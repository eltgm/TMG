package group.tmg.interactor;

import group.tmg.data.repository.tags.TagsDataSource;
import group.tmg.data.repository.tags.TagsRepository;

public class ArtistsInteractor {

    private TagsRepository tagsRepository;

    public ArtistsInteractor(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public void getArtists(TagsDataSource.MainCallback callback) {
        tagsRepository.getArtists(callback);
    }

    public void getArtists(TagsDataSource.MainCallback callback, CharSequence charSequence) {
        tagsRepository.getArtists(callback, charSequence);
    }

    public void unsubscribe() {
        tagsRepository.unsubscribe();
    }
}
