package group.tmg.data.network;


import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import group.tmg.data.model.Message;

public class LoginSpiceRequest extends RetrofitSpiceRequest<Message, Login> {

    private final String username;
    private final String password;

    public LoginSpiceRequest(String username, String password) {
        super(Message.class, Login.class);
        this.username = username;
        this.password = password;
    }


    @Override
    public Message loadDataFromNetwork() throws Exception {
        return getService().user(username, password);
    }
}
