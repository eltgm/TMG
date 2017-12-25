package group.tmg.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sender")
    @Expose
    private Contractor sender;
    @SerializedName("receiver")
    @Expose
    private Contractor receiver;
    @SerializedName("sum")
    @Expose
    private Double sum;
    @SerializedName("currency")
    @Expose
    private Integer currency;
    @SerializedName("artist")
    @Expose
    private Tag artist;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();
    @SerializedName("date")
    @Expose
    private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contractor getSender() {
        return sender;
    }

    public void setSender(Contractor sender) {
        this.sender = sender;
    }

    public Contractor getReceiver() {
        return receiver;
    }

    public void setReceiver(Contractor receiver) {
        this.receiver = receiver;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Tag getArtist() {
        return artist;
    }

    public void setArtist(Tag artist) {
        this.artist = artist;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static class TransactionList extends ArrayList<Transaction> {
    }
}