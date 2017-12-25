package group.tmg.data.repository.login;

import group.tmg.data.model.Message;

public interface LoginDataSource {
    void login(LoginCallback callback, final String username, final String password);

    void unsubscribe();

    interface LoginCallback {
        void onLoadCompleted(Message message);

        void onLoadError(String error);
    }
}
