package a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.root4arab.wipass.MainActivity;
import com.root4arab.wipass.WifiDetailsActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ow extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f221a;
    public final /* synthetic */ AppCompatActivity b;

    public /* synthetic */ ow(AppCompatActivity appCompatActivity, int i) {
        this.f221a = i;
        this.b = appCompatActivity;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        int i = this.f221a;
        AppCompatActivity appCompatActivity = this.b;
        switch (i) {
            case 0:
                MainActivity mainActivity = (MainActivity) appCompatActivity;
                if (intent != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    int i2 = 0;
                    if (intent.getBooleanExtra("resultsUpdated", false)) {
                        mainActivity.j.removeCallbacksAndMessages(null);
                        if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                            mainActivity.m();
                        } else {
                            WifiManager wifiManager = mainActivity.c;
                            if (wifiManager == null) {
                                mainActivity.m();
                            } else {
                                List<ScanResult> scanResults = wifiManager.getScanResults();
                                if (scanResults == null) {
                                    mainActivity.m();
                                } else {
                                    if (mainActivity.e == null) {
                                        mainActivity.e = new ArrayList();
                                    }
                                    mainActivity.e.clear();
                                    WifiInfo connectionInfo = mainActivity.c.getConnectionInfo();
                                    String strReplace = "";
                                    if (connectionInfo != null && connectionInfo.getSSID() != null) {
                                        strReplace = connectionInfo.getSSID().replace("\"", "");
                                    }
                                    for (ScanResult scanResult : scanResults) {
                                        if (scanResult != null && (str = scanResult.SSID) != null && !str.isEmpty()) {
                                            boolean zEquals = scanResult.SSID.equals(strReplace);
                                            xc xcVar = new xc();
                                            xcVar.f364a = scanResult.SSID;
                                            xcVar.b = scanResult.BSSID;
                                            xcVar.c = WifiManager.calculateSignalLevel(scanResult.level, 5);
                                            xcVar.d = scanResult.frequency;
                                            xcVar.e = scanResult.capabilities;
                                            xcVar.f = zEquals;
                                            mainActivity.e.add(xcVar);
                                        }
                                    }
                                    Collections.sort(mainActivity.e, new ou(i2));
                                    if (mainActivity.b != null && mainActivity.e.size() > 0) {
                                        com.root4arab.wipass.b bVar = mainActivity.b;
                                        bVar.c = true;
                                        bVar.notifyDataSetChanged();
                                        View view = mainActivity.q;
                                        if (view != null) {
                                            view.setVisibility(8);
                                        }
                                        RecyclerView recyclerView = mainActivity.f432a;
                                        if (recyclerView != null) {
                                            recyclerView.setVisibility(0);
                                        }
                                    }
                                    mainActivity.m();
                                }
                            }
                        }
                    } else {
                        int i3 = MainActivity.u;
                        mainActivity.j.removeCallbacksAndMessages(null);
                        mainActivity.m();
                    }
                    break;
                }
                break;
            case 1:
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int i4 = MainActivity.u;
                    ((MainActivity) appCompatActivity).h();
                }
                break;
            case 2:
                if ("android.location.MODE_CHANGED".equals(intent.getAction())) {
                    int i5 = MainActivity.u;
                    ((MainActivity) appCompatActivity).h();
                }
                break;
            default:
                WifiDetailsActivity wifiDetailsActivity = (WifiDetailsActivity) appCompatActivity;
                if (wifiDetailsActivity.ac && "android.net.wifi.supplicant.STATE_CHANGE".equals(intent.getAction()) && intent.getIntExtra("supplicantError", -1) == 1) {
                    wifiDetailsActivity.runOnUiThread(new aa(16, this));
                    break;
                }
                break;
        }
    }
}
