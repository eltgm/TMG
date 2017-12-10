package group.tmg.data.storage;


import group.tmg.data.model.User;

public interface LoginStorage {

    void saveUser(String user);

    User getUser();
}
