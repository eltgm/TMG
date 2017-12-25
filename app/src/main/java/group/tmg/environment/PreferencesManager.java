package group.tmg.environment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import static group.tmg.App.USER_REQUEST_TAG;

public class PreferencesManager {
    private static final String PREFERENCES_NAME = "TMG";
    private static SharedPreferences sharedPreferences;
    @Inject
    Context context;

    public PreferencesManager(Context context) {
        this.context = context;
    }

    public void putString(String value) {
        getSharedPreferences().edit().putString(USER_REQUEST_TAG, value).apply();
    }

    @Nullable
    public String getString() {
        return getSharedPreferences().getString(USER_REQUEST_TAG, null);
    }

    private SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }
}
