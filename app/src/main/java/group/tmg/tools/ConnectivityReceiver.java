package group.tmg.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectivityReceiver {
    public static boolean NETWORK_STATE;
    private final Context context;
    BroadcastReceiver br;

    public ConnectivityReceiver(Context context) {
        this.context = context;

        if (br == null) {
            br = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {

                    Bundle extras = intent.getExtras();

                    assert extras != null;
                    NetworkInfo info = extras
                            .getParcelable("networkInfo");

                    assert info != null;
                    NetworkInfo.State state = info.getState();
                    Log.d("TEST Internet", info.toString() + " "
                            + state.toString());

                    if (state == NetworkInfo.State.CONNECTED) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                NETWORK_STATE = isInternetWorking();
                            }
                        }).start();

                    } else {
                        Log.d("NETWORK", "perekl");
                    }
                }
            };
        }
    }

    private boolean isInternetWorking() {

        boolean success = false;
        try {
            URL url = new URL("https://google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(1000);
            connection.connect();

            success = connection.getResponseCode() == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return success;
    }

    public void registerReceiver() {
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        context.registerReceiver(br, intentFilter);
    }

    public void unregisterReceiver() {
        context.unregisterReceiver(br);
    }
}
