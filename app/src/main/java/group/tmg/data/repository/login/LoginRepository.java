package group.tmg.data.repository.login;


import group.tmg.data.model.User;
import group.tmg.data.storage.Storage;

public class LoginRepository {

    private final LoginDataSource remoteDataSource;

    private final Storage storage;

    public LoginRepository(LoginDataSource remoteDataSource, Storage storage) {
        this.remoteDataSource = remoteDataSource;
        this.storage = storage;
    }

    public void unsubscribe() {remoteDataSource.unsubscribe();}

    public void login(final LoginDataSource.LoginCallback callback, final String username, final String password){
        remoteDataSource.login(new LoginDataSource.LoginCallback() {
            @Override
            public void onLoadCompleted(User.List users) {
                storage.saveUser(users.toString()); //из User в String
                callback.onLoadCompleted(users);
            }

            @Override
            public void onLoadError(String error) {
                callback.onLoadError(error);
            }
        }, username, password);
    }
}
