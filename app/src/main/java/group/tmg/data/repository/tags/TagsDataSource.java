package group.tmg.data.repository.tags;

import java.util.List;

import group.tmg.data.model.Tag;

public interface TagsDataSource {
    void getTags(MainCallback callback);

    void getTags(MainCallback callback, CharSequence charSequence);

    void saveTags(List<Tag> tags);

    void unsubscribe();

    interface MainCallback {
        void onLoadCompleted(List<Tag> tags);

        void onLoadError(String error);
    }
}
