package group.tmg.data.repository.main;

import group.tmg.data.model.User;
import group.tmg.data.storage.Storage;

public class MainRepository {

    private final Storage storage;

    public MainRepository(Storage storage) {
        this.storage = storage;
    }


    public void getUser(final MainDataSource.MainCallback callback){
        callback.onLoadCompleted(storage.getUser());
    }
}
