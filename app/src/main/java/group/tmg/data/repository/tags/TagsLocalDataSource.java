package group.tmg.data.repository.tags;

import java.util.List;

import group.tmg.data.model.Tag;

public class TagsLocalDataSource implements TagsDataSource {
    @Override
    public void getTags(MainCallback callback) {

    }

    @Override
    public void getTags(MainCallback callback, CharSequence charSequence) {

    }

    @Override
    public void saveTags(List<Tag> tags) {
        //TODO прикрутить БД
    }

    @Override
    public void unsubscribe() {
        throw new UnsupportedOperationException("Может быть вызвано только из локального хранилища");
    }
}
