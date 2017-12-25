package group.tmg.data.network;


import group.tmg.data.model.Message;
import retrofit.http.GET;
import retrofit.http.Path;

interface Login {
    @GET("")
    Message user(@Path("username") String username, @Path("password") String password);
}
