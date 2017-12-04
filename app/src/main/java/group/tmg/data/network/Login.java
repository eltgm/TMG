package group.tmg.data.network;


import group.tmg.data.model.User;
import retrofit.http.GET;
import retrofit.http.Path;

interface Login {
    @GET("")
    User.List user(@Path("username") String username, @Path("password") String password);
}
