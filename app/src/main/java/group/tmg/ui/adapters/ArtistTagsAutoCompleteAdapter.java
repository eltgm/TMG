package group.tmg.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.List;

import group.tmg.R;
import group.tmg.data.model.Tag;

public class ArtistTagsAutoCompleteAdapter extends BaseAdapter implements Filterable {

    private final Context context;
    private List<Tag> mResults;
    private Filter filter;

    public ArtistTagsAutoCompleteAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return mResults.size();
    }

    @Override
    public Tag getItem(int i) {
        return mResults.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.tag_item, viewGroup, false);
        }
        Tag category = getItem(i);
        ((TextView) view.findViewById(R.id.textView10)).setText(category.getName());

        return view;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void setResults(List<Tag> results) {
        mResults = results;
    }
}
