package group.tmg.data.storage;


import group.tmg.data.model.Message;

public interface Storage {

    void saveUser(Message message);

    Message getUser();
}
