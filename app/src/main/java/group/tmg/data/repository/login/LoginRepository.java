package group.tmg.data.repository.login;


import group.tmg.data.model.Message;
import group.tmg.data.storage.Storage;

public class LoginRepository {

    private final LoginDataSource remoteDataSource;

    private final Storage storage;

    public LoginRepository(LoginDataSource remoteDataSource, Storage storage) {
        this.remoteDataSource = remoteDataSource;
        this.storage = storage;
    }

    public void unsubscribe() {
        remoteDataSource.unsubscribe();
    }

    public void login(final LoginDataSource.LoginCallback callback, final String username, final String password) {
        //TODO убрать тест
        Message message = new Message();
        message.setMessage("ЗАЛУПКА");
        message.setSuccess(true);
        if (message.getSuccess()) {
            //TODO сохранение пользователя
            callback.onLoadCompleted(message);
        } else
            callback.onLoadError(message.getMessage());
        //storage.saveUser(user);
        remoteDataSource.login(new LoginDataSource.LoginCallback() {
            @Override
            public void onLoadCompleted(Message message) {
                if (message.getSuccess()) {
                    //TODO сохранение пользователя
                    callback.onLoadCompleted(message);
                } else
                    callback.onLoadError(message.getMessage());
            }

            //TODO восстановить
            @Override
            public void onLoadError(String error) {
                callback.onLoadError(error);
            }
        }, username, password);
    }
}
