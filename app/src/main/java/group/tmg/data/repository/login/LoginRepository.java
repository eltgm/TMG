package group.tmg.data.repository.login;


import group.tmg.data.model.User;

public class LoginRepository {
    private final LoginDataSource remoteDataSource;
    private final LoginDataSource localDataSource;

    public LoginRepository(LoginDataSource remoteDataSource, LoginDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public void unsubscribe() {remoteDataSource.unsubscribe();}

    public void login(LoginDataSource.LoginCallback callback, final String username, final String password){
        remoteDataSource.login(callback, username, password);
    }

    void saveUser(String user){
        localDataSource.saveUser(user);
    }

    User getUser(){
        return new User();
    }
}
