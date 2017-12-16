package group.tmg.data.repository.main;

import group.tmg.data.model.User;

public interface MainDataSource {
    interface MainCallback{
        void onLoadCompleted(User user);

        void onLoadError(String error);
    }
}
