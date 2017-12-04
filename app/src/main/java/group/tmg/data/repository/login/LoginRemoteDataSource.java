package group.tmg.data.repository.login;


import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import group.tmg.data.model.User;
import group.tmg.data.network.LoginSpiceRequest;

public class LoginRemoteDataSource implements LoginDataSource{
    private final SpiceManager spiceManager;

    public LoginRemoteDataSource(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    @Override
    public void login(LoginCallback callback, String username, String password) {
        LoginSpiceRequest request = new LoginSpiceRequest(username, password);
        spiceManager.execute(request, null, DurationInMillis.ALWAYS_EXPIRED, new LoginRequestListener(callback));
    }

    @Override
    public void saveUser(String user) {
        throw new UnsupportedOperationException("saveUser should be called on local data source!");
    }

    @Override
    public User getUser() {
        throw new UnsupportedOperationException("getUser should be called on local data source!");
    }

    @Override
    public void unsubscribe() {
        spiceManager.shouldStop();
    }

    private class LoginRequestListener implements RequestListener<User.List>{
        private final LoginCallback callback;

        public LoginRequestListener(LoginCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onRequestFailure(SpiceException spiceException) {
            callback.onLoadError(spiceException.toString());
        }

        @Override
        public void onRequestSuccess(User.List users) {
            callback.onLoadCompleted(users);
        }
    }
}
