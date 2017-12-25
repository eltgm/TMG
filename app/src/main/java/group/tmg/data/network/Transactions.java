package group.tmg.data.network;

import group.tmg.data.model.Transaction;
import retrofit.http.GET;

public interface Transactions {
    @GET("")
    Transaction.TransactionList transactions();
}
