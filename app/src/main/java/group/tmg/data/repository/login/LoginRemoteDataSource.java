package group.tmg.data.repository.login;


import android.util.Log;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import dagger.Module;
import group.tmg.data.model.User;
import group.tmg.data.network.LoginSpiceRequest;

import static android.content.ContentValues.TAG;
import static group.tmg.ui.activity.LoginActivity.USER_TAG;
@Module
public class LoginRemoteDataSource implements LoginDataSource{


    private final SpiceManager spiceManager;

    public LoginRemoteDataSource(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    @Override
    public void login(LoginCallback callback, String username, String password) {
        LoginSpiceRequest request = new LoginSpiceRequest(username, password);
        Log.d(TAG, "loadDataFromNetwork: YA RABOTAYU");
        spiceManager.execute(request, USER_TAG, DurationInMillis.ALWAYS_EXPIRED, new LoginRequestListener(callback));
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
