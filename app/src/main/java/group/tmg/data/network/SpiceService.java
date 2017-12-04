package group.tmg.data.network;


import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

public class SpiceService extends RetrofitGsonSpiceService{
    private static final String BASE_URL = "";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(Login.class);

    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }
}
