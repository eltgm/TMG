package group.tmg.data.network;


import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import group.tmg.data.model.Transaction;

public class TransactionsSpiceRequest extends RetrofitSpiceRequest<Transaction.TransactionList, Transactions> {


    public TransactionsSpiceRequest() {
        super(Transaction.TransactionList.class, Transactions.class);
    }


    @Override
    public Transaction.TransactionList loadDataFromNetwork() throws Exception {
        return getService().transactions();
    }
}