package group.tmg.data.repository.transactions;


import java.util.List;

import group.tmg.data.model.Transaction;

public class TransactionLocalDataSource implements TransactionsDataSource {
    @Override
    public void getTransaction(TransactionCallback callback) {

    }

    @Override
    public void getTransactions(TransactionsCallback transactionsCallback) {

    }

    @Override
    public void saveTransactions(List<Transaction> transactions) {

    }

    @Override
    public void unsubscribe() {
        throw new UnsupportedOperationException("Может быть вызвано только из удаленного хранилища");
    }

    @Override
    public void addNewTransaction(String tags, String transName, String artist, String sender, String recipient, String currency, Double amount) {

    }
}
