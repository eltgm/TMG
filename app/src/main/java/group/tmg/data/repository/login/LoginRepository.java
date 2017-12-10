package group.tmg.data.repository.login;


import group.tmg.data.model.User;
import group.tmg.data.storage.LoginStorage;

public class LoginRepository {


    private final LoginDataSource remoteDataSource;


    private final LoginStorage loginStorage;


    public LoginRepository(LoginDataSource remoteDataSource, LoginStorage loginStorage) {
        this.remoteDataSource = remoteDataSource;
        this.loginStorage = loginStorage;
    }

    public void unsubscribe() {remoteDataSource.unsubscribe();}

    public void login(final LoginDataSource.LoginCallback callback, final String username, final String password){
        remoteDataSource.login(new LoginDataSource.LoginCallback() {
            @Override
            public void onLoadCompleted(User.List users) {
                loginStorage.saveUser(users.toString()); //из User в String
                callback.onLoadCompleted(users);
            }

            @Override
            public void onLoadError(String error) {
                callback.onLoadError(error);
            }
        }, username, password);
    }
}
