package group.tmg.data.repository.tags;

import java.util.ArrayList;
import java.util.List;

import group.tmg.data.model.Tag;

import static group.tmg.tools.ConnectivityReceiver.NETWORK_STATE;

public class TagsRepository {

    private final TagsDataSource tagsRemoteDataSource;

    private final TagsDataSource tagsLocalDataSource;


    public TagsRepository(TagsDataSource tagsRemoteDataSource, TagsDataSource tagsLocalDataSource) {
        this.tagsRemoteDataSource = tagsRemoteDataSource;

        this.tagsLocalDataSource = tagsLocalDataSource;
    }


    public void getArtists(final TagsDataSource.MainCallback callback) {
        List<Tag> art = new ArrayList<>();
        List<Tag> artists = new ArrayList<>();
        Tag tag1 = new Tag();
        tag1.setArtist(false);
        tag1.setId("1");
        tag1.setName("Трек");
        Tag tag2 = new Tag();
        tag2.setArtist(true);
        tag2.setId("2");
        tag2.setName("Sabi Miss");
        Tag tag3 = new Tag();
        tag3.setArtist(true);
        tag3.setId("3");
        tag3.setName("Нюша");
        art.add(tag1);
        art.add(tag2);
        art.add(tag3);
        for (Tag tag :
                art) {
            if (tag.getArtist())
                artists.add(tag);
        }

        callback.onLoadCompleted(artists);
        if (NETWORK_STATE) {
            tagsRemoteDataSource.getTags(new TagsDataSource.MainCallback() {
                @Override
                public void onLoadCompleted(List<Tag> tags) {
                    List<Tag> artists = new ArrayList<>();
                    for (Tag tag :
                            tags) {
                        if (tag.getArtist())
                            artists.add(tag);
                    }
                    callback.onLoadCompleted(artists);
                    tagsLocalDataSource.saveTags(artists);
                }

                @Override
                public void onLoadError(String error) {
                    callback.onLoadError(error);
                }
            });
        } else {
            tagsLocalDataSource.getTags(callback);
        }
    }

    public void getTags(final TagsDataSource.MainCallback callback) {
        if (NETWORK_STATE) {
            tagsRemoteDataSource.getTags(new TagsDataSource.MainCallback() {
                @Override
                public void onLoadCompleted(List<Tag> tags) {
                    List<Tag> ts = new ArrayList<>();
                    for (Tag tag :
                            ts) {
                        if (!tag.getArtist())
                            ts.add(tag);
                    }
                    callback.onLoadCompleted(ts);
                    tagsLocalDataSource.saveTags(ts);
                }

                @Override
                public void onLoadError(String error) {
                    callback.onLoadError(error);
                }
            });
        } else {
            tagsLocalDataSource.getTags(callback);
        }
    }

    public void getTags(final TagsDataSource.MainCallback callback, final CharSequence charSequence) {
        Tag tag = new Tag();
        tag.setName(charSequence.toString());
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        //TODO тест
        callback.onLoadCompleted(tags);
        tagsRemoteDataSource.getTags(new TagsDataSource.MainCallback() {
            @Override
            public void onLoadCompleted(List<Tag> tags) {
                List<Tag> ts = new ArrayList<>();
                for (Tag tag :
                        ts) {
                    if (!tag.getArtist())
                        ts.add(tag);
                }
            }

            @Override
            public void onLoadError(String error) {

            }
        }, charSequence);
    }

    public void getArtists(final TagsDataSource.MainCallback callback, final CharSequence charSequence) {
        Tag tag = new Tag();
        tag.setName(charSequence.toString());
        List<Tag> tags = new ArrayList<>();
        tags.add(tag);
        //TODO тест
        callback.onLoadCompleted(tags);
        tagsRemoteDataSource.getTags(new TagsDataSource.MainCallback() {
            @Override
            public void onLoadCompleted(List<Tag> tags) {
                List<Tag> ts = new ArrayList<>();
                for (Tag tag :
                        ts) {
                    if (tag.getArtist())
                        ts.add(tag);
                }
            }

            @Override
            public void onLoadError(String error) {

            }
        }, charSequence);
    }

    public void unsubscribe() {
        tagsRemoteDataSource.unsubscribe();
    }
}
