package group.tmg.data.repository.transactions;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import java.util.List;

import group.tmg.data.model.Transaction;
import group.tmg.data.network.TransactionsSpiceRequest;


public class TransactionRemoteDataSource implements TransactionsDataSource {

    private final SpiceManager spiceManager;

    public TransactionRemoteDataSource(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }

    @Override
    public void getTransaction(TransactionCallback callback) {

    }

    @Override
    public void getTransactions(TransactionsCallback transactionsCallback) {
        TransactionsSpiceRequest request = new TransactionsSpiceRequest();
        spiceManager.execute(request, "transactions", DurationInMillis.ONE_HOUR, new TransactionsRequestListener(transactionsCallback));
    }

    @Override
    public void saveTransactions(List<Transaction> transactions) {
        throw new UnsupportedOperationException("Может быть вызвано только из локального хранилища");
    }

    @Override
    public void unsubscribe() {
        spiceManager.shouldStop();
    }

    @Override
    public void addNewTransaction(String tags, String transName, String artist, String sender, String recipient, String currency, Double amount) {

    }

    private class TransactionsRequestListener implements RequestListener<Transaction.TransactionList> {
        private final TransactionsCallback callback;


        private TransactionsRequestListener(TransactionsCallback callback) {
            this.callback = callback;
        }

        @Override
        public void onRequestFailure(SpiceException e) {
            callback.onLoadError(e.toString());
        }

        @Override
        public void onRequestSuccess(Transaction.TransactionList transactions) {

            callback.onLoadCompleted(transactions);
        }
    }
}
