package group.tmg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Tag {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("artist")
    @Expose
    private Boolean artist;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getArtist() {
        return artist;
    }

    public void setArtist(Boolean artist) {
        this.artist = artist;
    }

    public static class List extends ArrayList<Tag> {
    }
}