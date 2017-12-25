package group.tmg.interactor;

import group.tmg.data.repository.transactions.TransactionRepository;
import group.tmg.data.repository.transactions.TransactionsDataSource;

public class TransactionInteractor {
    private final TransactionRepository repository;

    public TransactionInteractor(TransactionRepository repository) {
        this.repository = repository;
    }

    public void getTransactions(final TransactionsDataSource.TransactionsCallback callback) {
        repository.getTransactions(callback);
    }

    public void unsubscribe() {
        repository.unsubscribe();
    }

    public void addNewTransaction(String tags, String transName, String artist, String sender, String recipient, String currency, Double amount) {
        repository.addNewTransaction(tags, transName, artist, sender, recipient, currency, amount);
    }

    public void subscribeTransaction(final TransactionsDataSource.TransactionCallback callback) {
        repository.subscribeTransaction(callback);
    }
}
