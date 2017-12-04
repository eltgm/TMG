package group.tmg.data.network;


import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import group.tmg.data.model.User;

public class LoginSpiceRequest extends RetrofitSpiceRequest<User.List, Login> {

    private final String username;
    private final String password;

    public LoginSpiceRequest(String username, String password) {
        super(User.List.class, Login.class);
        this.username = username;
        this.password = password;
    }


    @Override
    public User.List loadDataFromNetwork() throws Exception {
        return getService().user(username, password);
    }
}
