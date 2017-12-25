package group.tmg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;

import javax.inject.Inject;

import group.tmg.App;
import group.tmg.R;
import group.tmg.presenter.TransactionDialogPresenter;
import group.tmg.view.TransactionDialogView;

public class TransactionDialog extends BaseDialogFragment<TransactionDialogPresenter> implements TransactionDialogView {
    MultiAutoCompleteTextView acTags;
    EditText edNewTags;
    EditText edTransName;
    Spinner sArtist;
    Spinner sSender;
    Spinner sRecipient;
    Spinner sCurrency;
    EditText edAmount;

    @Inject
    TransactionDialogPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle(R.string.new_transaction);
        View v = inflater.inflate(R.layout.transaction_dialog_fragment, container);
        initView(v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = super.instantiatePresenter();
    }

    public void initView(View v) {
        acTags = v.findViewById(R.id.acTags);
        edNewTags = v.findViewById(R.id.newTags);
        edTransName = v.findViewById(R.id.edTransactionName);
        sArtist = v.findViewById(R.id.sArtist);
        sSender = v.findViewById(R.id.sSender);
        sRecipient = v.findViewById(R.id.sRecipient);
        sCurrency = v.findViewById(R.id.sCurrency);
        edAmount = v.findViewById(R.id.etAmount);


        v.findViewById(R.id.bCloseTransDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().cancel();
            }
        });
        v.findViewById(R.id.bAddTransFromDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addNewTransaction(acTags.getText().toString(), edTransName.getText().toString(), sArtist.getSelectedItem().toString(),
                        sSender.getSelectedItem().toString(), sRecipient.getSelectedItem().toString(),
                        sCurrency.getSelectedItem().toString(), Double.valueOf(String.valueOf(edAmount.getText())));
                getDialog().cancel();
            }
        });
    }


    @Override
    protected TransactionDialogPresenter providePresenter() {
        App.getPresenterComponent().inject(this);
        return presenter;
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView(this);
    }
}
