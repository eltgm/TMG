package group.tmg.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import group.tmg.R;
import group.tmg.data.model.Contractor;

public class SpinnerAdapter extends ArrayAdapter<Contractor> {
    private final LayoutInflater mInflater;
    private final Context mContext;
    private final int mResource;
    private List<Contractor> items;

    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, List<Contractor> contractors) {
        super(context, resource, R.id.contractorName, contractors);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = contractors;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {

        View view = mInflater.inflate(mResource, parent, false);

        TextView offTypeTv = view.findViewById(R.id.contractorName);


        Contractor contractor = items.get(position);

        offTypeTv.setText(contractor.getName());

        return view;
    }
}
