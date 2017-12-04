package group.tmg.data.repository.login;

import group.tmg.data.model.User;

public interface LoginDataSource {
    interface LoginCallback{
        void onLoadCompleted(User.List users);

        void onLoadError(String error);
    }

    void login(LoginCallback callback, final String username, final String password);

    void saveUser(String user);

    User getUser();

    void unsubscribe();
}
