package group.tmg.data.repository.tags;


import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.List;

import group.tmg.data.model.Tag;
import group.tmg.data.network.TagsSpiceRequest;

public class TagsRemoteDataSource implements TagsDataSource {

    private final SpiceManager spiceManager;

    public TagsRemoteDataSource(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    @Override
    public void getTags(MainCallback callback) {
        TagsSpiceRequest request = new TagsSpiceRequest();
        spiceManager.execute(request, "artists", DurationInMillis.ONE_HOUR, new TagsRequestListener(callback));
    }

    @Override
    public void getTags(MainCallback callback, CharSequence charSequence) {

    }

    @Override
    public void saveTags(List<Tag> tag) {
        throw new UnsupportedOperationException("Может быть вызвано только из локального хранилища");
    }

    @Override
    public void unsubscribe() {
        spiceManager.shouldStop();
    }

    private class TagsRequestListener implements RequestListener<Tag.List> {
        private final MainCallback callback;


        private TagsRequestListener(MainCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onRequestFailure(SpiceException e) {
            callback.onLoadError(e.toString());
        }

        @Override
        public void onRequestSuccess(Tag.List tags) {

            callback.onLoadCompleted(tags);
        }
    }
}
