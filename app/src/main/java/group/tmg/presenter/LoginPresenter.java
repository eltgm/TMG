package group.tmg.presenter;

import group.tmg.data.model.User;
import group.tmg.data.repository.login.LoginDataSource;
import group.tmg.interactor.LoginInteractor;
import group.tmg.view.LoginView;

public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginInteractor loginInteractor;

    public LoginPresenter(LoginInteractor loginInteractor) {

        this.loginInteractor = loginInteractor;
    }

    @Override
    protected void onViewAttach() {
        super.onViewAttach();
        //когда презентер привяжется к view
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginInteractor.unsubscribe();
    }

    public void onLoginClicked(final String username, final String password){
        getView().navigateToMainScreen();
        loginInteractor.login(new LoginDataSource.LoginCallback() {
            @Override
            public void onLoadCompleted(User.List users) {
                getView().navigateToMainScreen();
            }

            @Override
            public void onLoadError(String error) {
                getView().showLoginError(error);
            }
        }, username, password);
    }
}
