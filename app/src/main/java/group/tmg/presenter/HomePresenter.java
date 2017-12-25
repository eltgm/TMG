package group.tmg.presenter;

import android.widget.Filter;

import java.util.List;

import group.tmg.data.model.Contractor;
import group.tmg.data.model.Tag;
import group.tmg.data.model.Transaction;
import group.tmg.data.repository.contractors.ContractorDataSource;
import group.tmg.data.repository.tags.TagsDataSource;
import group.tmg.data.repository.transactions.TransactionsDataSource;
import group.tmg.interactor.ArtistsInteractor;
import group.tmg.interactor.ContractorInteractor;
import group.tmg.interactor.TagInteractor;
import group.tmg.interactor.TransactionInteractor;
import group.tmg.ui.adapters.ArtistTagsAutoCompleteAdapter;
import group.tmg.view.HomeView;

public class HomePresenter extends BasePresenter<HomeView> {

    private final TransactionInteractor transactionInteractor;
    private final TagInteractor tagInteractor;
    private final ArtistsInteractor artistsInteractor;
    private final ContractorInteractor contractorInteractor;

    private ArtistTagsAutoCompleteAdapter artistAdapter;

    public HomePresenter(TransactionInteractor transactionInteractor, TagInteractor tagInteractor, ArtistsInteractor artistsInteractor, ContractorInteractor contractorInteractor) {
        this.transactionInteractor = transactionInteractor;
        this.tagInteractor = tagInteractor;
        this.artistsInteractor = artistsInteractor;
        this.contractorInteractor = contractorInteractor;
    }

    @Override
    void onViewAttach() {
        super.onViewAttach();
        transactionInteractor.getTransactions(new TransactionsDataSource.TransactionsCallback() {
            @Override
            public void onLoadCompleted(List<Transaction> transactions) {
                getView().showTransactions(transactions);
            }

            @Override
            public void onLoadError(String error) {
                getView().showError(error);
            }
        });
        artistAdapter = new ArtistTagsAutoCompleteAdapter(getView().getContext());

        artistAdapter.setFilter(new Filter() {
            @Override
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {

                final FilterResults filterResults = new FilterResults();
                if (charSequence != null) {
                    artistsInteractor.getArtists(new TagsDataSource.MainCallback() {
                        @Override
                        public void onLoadCompleted(List<Tag> tag) {
                            List<Tag> tags = tag;
                            filterResults.values = tags;
                            filterResults.count = tags.size();
                        }

                        @Override
                        public void onLoadError(String error) {

                        }
                    }, charSequence);


                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults != null && filterResults.count > 0) {
                    artistAdapter.setResults((List<Tag>) filterResults.values);
                    artistAdapter.notifyDataSetChanged();
                } else {
                    artistAdapter.notifyDataSetInvalidated();
                }
            }
        });
        getView().initArtistTV(artistAdapter);

        contractorInteractor.getContractors(new ContractorDataSource.ContractorsCallback() {
            @Override
            public void onLoadCompleted(List<Contractor> contractors) {
                getView().initSpinnerData(contractors);
            }

            @Override
            public void onLoadError(String error) {

            }
        });

        transactionInteractor.subscribeTransaction(new TransactionsDataSource.TransactionCallback() {
            @Override
            public void onLoadCompleted(Transaction transaction) {
                getView().addTransactionToView(transaction);
            }

            @Override
            public void onLoadError(String error) {
                getView().showError(error);
            }
        });
    }

    @Override
    void onDestroy() {
        super.onDestroy();
        tagInteractor.unsubscribe();
        artistsInteractor.unsubscribe();
        transactionInteractor.unsubscribe();
        contractorInteractor.unsubscribe();
    }
}
