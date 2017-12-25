package group.tmg.interactor;

import group.tmg.data.repository.tags.TagsDataSource;
import group.tmg.data.repository.tags.TagsRepository;

public class TagInteractor {
    private final TagsRepository tagsRepository;

    public TagInteractor(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public void getTags(TagsDataSource.MainCallback callback) {
        tagsRepository.getTags(callback);
    }

    public void getTags(TagsDataSource.MainCallback callback, CharSequence charSequence) {
        tagsRepository.getTags(callback, charSequence);
    }

    public void unsubscribe() {
        tagsRepository.unsubscribe();
    }
}
