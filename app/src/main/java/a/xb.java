package a;

import android.net.ConnectivityManager;
import android.net.Network;
import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final class xb extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f363a;
    public final /* synthetic */ WifiDetailsActivity b;

    public xb(WifiDetailsActivity wifiDetailsActivity, String str) {
        this.b = wifiDetailsActivity;
        this.f363a = str;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        WifiDetailsActivity wifiDetailsActivity = this.b;
        wifiDetailsActivity.z.removeCallbacksAndMessages(null);
        wifiDetailsActivity.aa.removeCallbacksAndMessages(null);
        wifiDetailsActivity.runOnUiThread(new gl(8, this, this.f363a));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        super.onUnavailable();
        WifiDetailsActivity wifiDetailsActivity = this.b;
        wifiDetailsActivity.z.removeCallbacksAndMessages(null);
        wifiDetailsActivity.aa.removeCallbacksAndMessages(null);
        wifiDetailsActivity.y++;
        wifiDetailsActivity.runOnUiThread(new aa(17, this));
    }
}
