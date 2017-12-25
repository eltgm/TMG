package group.tmg.view;

import android.content.Context;

import java.util.List;

import group.tmg.data.model.Contractor;
import group.tmg.data.model.Transaction;
import group.tmg.ui.adapters.ArtistTagsAutoCompleteAdapter;

public interface HomeView {
    void showTransactions(List<Transaction> transactions);

    void addTransactionToView(Transaction transaction);

    void showError(String error);

    void initArtistTV(ArtistTagsAutoCompleteAdapter artistAdapter);

    void initSpinnerData(List<Contractor> contractors);

    Context getContext();
}
