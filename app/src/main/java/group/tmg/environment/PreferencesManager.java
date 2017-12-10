package group.tmg.environment;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import javax.inject.Inject;

public class PreferencesManager {
    private static final String PREFERENCES_NAME = "TMG";

    @Inject
    Context context;

    private static SharedPreferences sharedPreferences;

    public PreferencesManager(Context context) {
        this.context = context;
    }

    public void putString(String value) {
        getSharedPreferences().edit().putString(group.tmg.ui.activity.LoginActivity.USER_TAG, value).apply();
    }

    @Nullable
    public String getString() {
        return getSharedPreferences().getString(group.tmg.ui.activity.LoginActivity.USER_TAG, null);
    }

    private SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }
}
