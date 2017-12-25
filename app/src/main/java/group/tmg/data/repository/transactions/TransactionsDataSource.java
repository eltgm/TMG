package group.tmg.data.repository.transactions;


import java.util.List;

import group.tmg.data.model.Transaction;

public interface TransactionsDataSource {
    void getTransaction(TransactionCallback callback);

    void getTransactions(TransactionsCallback transactionsCallback);

    void saveTransactions(List<Transaction> transactions);

    void unsubscribe();

    void addNewTransaction(String tags, String transName, String artist, String sender, String recipient, String currency, Double amount);

    interface TransactionsCallback {
        void onLoadCompleted(List<Transaction> transactions);

        void onLoadError(String error);
    }

    interface TransactionCallback {
        void onLoadCompleted(Transaction transaction);

        void onLoadError(String error);
    }
}
