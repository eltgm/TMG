package group.tmg.data.network;


import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import group.tmg.data.model.Tag;

public class TagsSpiceRequest extends RetrofitSpiceRequest<Tag.List, Tags> {


    public TagsSpiceRequest() {
        super(Tag.List.class, Tags.class);
    }


    @Override
    public Tag.List loadDataFromNetwork() throws Exception {
        return getService().tags();
    }
}