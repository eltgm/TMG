package group.tmg.data.storage;

import com.google.gson.GsonBuilder;

import group.tmg.data.model.Message;
import group.tmg.environment.PreferencesManager;

public class StorageImpl implements Storage {


    private final PreferencesManager preferenceManager;

    public StorageImpl(PreferencesManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    @Override
    public void saveUser(Message message) {
        String serializedUser = new GsonBuilder().create().toJson(message);
        preferenceManager.putString(serializedUser);
    }

    @Override
    public Message getUser() {
        String serializedUser = preferenceManager.getString();

        return new GsonBuilder().create().fromJson(serializedUser, Message.class);
    }
}
