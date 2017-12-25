package group.tmg.data.repository.transactions;


import java.util.ArrayList;
import java.util.List;

import group.tmg.data.model.Contractor;
import group.tmg.data.model.Tag;
import group.tmg.data.model.Transaction;

import static group.tmg.tools.ConnectivityReceiver.NETWORK_STATE;

public class TransactionRepository {
    private final TransactionsDataSource transactionsLocalDataSource;
    private final TransactionsDataSource transactionsRemoteDataSource;

    //TODO тест
    TransactionsDataSource.TransactionCallback callback;

    public TransactionRepository(TransactionsDataSource transactionsLocalDataSource, TransactionsDataSource transactionsRemoteDataSource) {
        this.transactionsLocalDataSource = transactionsLocalDataSource;
        this.transactionsRemoteDataSource = transactionsRemoteDataSource;
    }

    public void unsubscribe() {
        transactionsRemoteDataSource.unsubscribe();
    }

    public void getTransactions(final TransactionsDataSource.TransactionsCallback callback) {
        //TODO убрать тест
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        Transaction transaction2 = new Transaction();
        Transaction transaction3 = new Transaction();

        Tag tag2 = new Tag();
        tag2.setArtist(true);
        tag2.setId("2");
        tag2.setName("Sabi Miss");
        Tag tag3 = new Tag();
        tag3.setArtist(true);
        tag3.setId("3");
        tag3.setName("Нюша");
        Contractor contractor = new Contractor();
        contractor.setName("Махов А.С.");
        Contractor contractor1 = new Contractor();
        contractor1.setName("Мужик Ж.Ж.");

        transaction.setName("Оплата");
        transaction.setArtist(tag2);
        transaction.setSender(contractor);
        transaction.setReceiver(contractor1);
        transaction.setSum(55.);
        transaction2.setName("Съемки клипа");
        transaction2.setArtist(tag3);
        transaction2.setSender(contractor1);
        transaction2.setReceiver(contractor);
        transaction2.setSum(15.150);

        transactions.add(transaction);
        transactions.add(transaction2);
        callback.onLoadCompleted(transactions);

        if (NETWORK_STATE) {
            transactionsRemoteDataSource.getTransactions(new TransactionsDataSource.TransactionsCallback() {
                @Override
                public void onLoadCompleted(List<Transaction> transactions) {
                    callback.onLoadCompleted(transactions);
                }

                @Override
                public void onLoadError(String error) {
                    callback.onLoadError(error);
                }
            });
        } else
            transactionsLocalDataSource.getTransactions(new TransactionsDataSource.TransactionsCallback() {
                @Override
                public void onLoadCompleted(List<Transaction> transactions) {
                    callback.onLoadCompleted(transactions);
                }

                @Override
                public void onLoadError(String error) {
                    callback.onLoadError(error);
                }
            });
    }

    public void addNewTransaction(String tags, String transName, String artist, String sender, String recipient, String currency, Double amount) {
        transactionsRemoteDataSource.addNewTransaction(tags, transName, artist, sender, recipient, currency, amount);
        Transaction transaction = new Transaction();
        transaction.setName(transName);
        Tag tag = new Tag();
        tag.setName(artist);
        tag.setArtist(true);
        transaction.setArtist(tag);
        Contractor s = new Contractor();
        s.setName(sender);
        transaction.setSender(s);
        Contractor r = new Contractor();
        s.setName(recipient);
        transaction.setReceiver(r);
        transaction.setSum(amount);
        callback.onLoadCompleted(transaction);
    }

    public void subscribeTransaction(TransactionsDataSource.TransactionCallback callback) {
        this.callback = callback;
    }
}
