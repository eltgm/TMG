package group.tmg.interactor;

import group.tmg.data.repository.login.LoginDataSource;
import group.tmg.data.repository.login.LoginRepository;

public class LoginInteractor {


    private final LoginRepository loginRepository;

    public LoginInteractor(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public void login(LoginDataSource.LoginCallback callback, final String username, final String password){
        loginRepository.login(callback, username, password);
    }

    public void unsubscribe() {loginRepository.unsubscribe();}
}
