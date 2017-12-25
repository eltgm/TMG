package group.tmg.data.network;


import group.tmg.data.model.Tag;
import retrofit.http.GET;

interface Tags {
    @GET("")
    Tag.List tags();
}
