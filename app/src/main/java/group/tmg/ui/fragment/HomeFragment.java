package group.tmg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import group.tmg.App;
import group.tmg.R;
import group.tmg.data.model.Contractor;
import group.tmg.data.model.Tag;
import group.tmg.data.model.Transaction;
import group.tmg.environment.DelayAutoCompleteTextView;
import group.tmg.presenter.HomePresenter;
import group.tmg.ui.adapters.ArtistTagsAutoCompleteAdapter;
import group.tmg.ui.adapters.SpinnerAdapter;
import group.tmg.ui.adapters.TransactionAdapter;
import group.tmg.view.HomeView;


public class HomeFragment extends BaseFragment<HomePresenter>
        implements HomeView, View.OnClickListener {
    @Inject
    HomePresenter presenter;

    private RecyclerView rvTransactions;
    private TransactionAdapter adapter;
    private TransactionDialog transactionDialog;
    private DelayAutoCompleteTextView acArtists;
    private Spinner sSender;
    private SpinnerAdapter spinnerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_general, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        presenter = super.instantiatePresenter();

    }

    @Override
    public void showTransactions(List<Transaction> transactions) {
        adapter.setDataSet(transactions);
    }

    @Override
    public void addTransactionToView(Transaction transaction) {
        adapter.addTransaction(transaction);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void initArtistTV(ArtistTagsAutoCompleteAdapter artistAdapter) {
        acArtists.setThreshold(2);
        acArtists.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        acArtists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tag tag = (Tag) adapterView.getItemAtPosition(i);
                acArtists.setText(tag.getName());
            }
        });
        acArtists.setAdapter(artistAdapter);
    }

    @Override
    public void initSpinnerData(List<Contractor> contractors) {
        spinnerAdapter = new SpinnerAdapter(getContext(), R.layout.spinner_item, contractors);
        sSender.setAdapter(spinnerAdapter);
    }


    void initViews(View view) {
        rvTransactions = view.findViewById(R.id.rvTransaction);
        adapter = new TransactionAdapter();
        rvTransactions.setAdapter(adapter);
        rvTransactions.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext()));

        transactionDialog = new TransactionDialog();

        view.findViewById(R.id.bAddTransaction).setOnClickListener(this);

        acArtists = view.findViewById(R.id.acArtist);

        sSender = view.findViewById(R.id.mainSender);

    }

    @Override
    protected HomePresenter providePresenter() {
        App.getPresenterComponent().inject(this);
        return presenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void onClick(View view) {
        transactionDialog.show(getFragmentManager(), "transactionDialog");
    }
}
