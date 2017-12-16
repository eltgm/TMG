package group.tmg.data.storage;


import group.tmg.data.model.User;

public interface Storage {

    void saveUser(String user);

    User getUser();
}
