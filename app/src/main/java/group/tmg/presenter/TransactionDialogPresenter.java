package group.tmg.presenter;

import group.tmg.interactor.TransactionInteractor;
import group.tmg.view.TransactionDialogView;

public class TransactionDialogPresenter extends BasePresenter<TransactionDialogView> {
    private final TransactionInteractor transactionInteractor;

    public TransactionDialogPresenter(TransactionInteractor transactionInteractor) {
        this.transactionInteractor = transactionInteractor;
    }

    public void addNewTransaction(String tags, String transName, String artist, String sender, String recipient, String currency, Double amount) {
        transactionInteractor.addNewTransaction(tags, transName, artist, sender, recipient, currency, amount);
    }
}
