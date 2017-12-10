package group.tmg.data.storage;

import group.tmg.data.model.User;
import group.tmg.environment.PreferencesManager;

public class LoginStorageImpl implements LoginStorage {


    private final PreferencesManager preferenceManager;

    public LoginStorageImpl(PreferencesManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    @Override
    public void saveUser(String user) {
        preferenceManager.putString(user);
    }

    @Override
    public User getUser() {
        preferenceManager.getString();
        return null;
    }
}
