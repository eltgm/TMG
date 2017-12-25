package group.tmg.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import group.tmg.R;
import group.tmg.data.model.Transaction;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private List<Transaction> transactions = new ArrayList<>();


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.transaction_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Transaction transaction = transactions.get(i);
        //TODO вьюхи
        viewHolder.setTransactionName(transaction.getName());
        viewHolder.setArtist((transaction.getArtist()).getName());
        viewHolder.setSender((transaction.getSender()).getName());
        viewHolder.setRecipient((transaction.getReceiver()).getName());
        viewHolder.setAmount(transaction.getSum());
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public void setDataSet(List<Transaction> transactions) {
        this.transactions = transactions;
        notifyDataSetChanged();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyItemInserted(transactions.size() - 1);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTransaction;
        private final TextView tvArtist;
        private final TextView tvSender;
        private final TextView tvRecipient;
        private final TextView tvAmount;
//TODO вьюхи

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvTransaction = itemView.findViewById(R.id.tvTransactionName);
            this.tvArtist = itemView.findViewById(R.id.tvArtist);
            this.tvSender = itemView.findViewById(R.id.tvSender);
            this.tvRecipient = itemView.findViewById(R.id.tvRecipient);
            this.tvAmount = itemView.findViewById(R.id.tvAmount);
        }

        public void setTransactionName(String transactionName) {
            tvTransaction.setText(transactionName);
        }

        public void setArtist(String artist) {
            tvArtist.setText(artist);
        }

        public void setSender(String sender) {
            tvSender.setText(sender);
        }

        public void setRecipient(String recipient) {
            tvRecipient.setText(recipient);
        }

        public void setAmount(double amount) {
            tvAmount.setText(String.format("$%g", amount));
        }
    }
}
