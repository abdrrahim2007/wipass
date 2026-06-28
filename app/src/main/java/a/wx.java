package a;

import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wx implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f358a;
    public final /* synthetic */ WifiDetailsActivity b;

    public /* synthetic */ wx(WifiDetailsActivity wifiDetailsActivity, int i) {
        this.f358a = i;
        this.b = wifiDetailsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f358a;
        WifiDetailsActivity wifiDetailsActivity = this.b;
        switch (i) {
            case 0:
                xb xbVar = wifiDetailsActivity.ab;
                if (xbVar != null) {
                    wifiDetailsActivity.t.unregisterNetworkCallback(xbVar);
                    wifiDetailsActivity.ab = null;
                }
                wifiDetailsActivity.aa.removeCallbacksAndMessages(null);
                wifiDetailsActivity.y++;
                wifiDetailsActivity.runOnUiThread(new wx(wifiDetailsActivity, 2));
                break;
            case 1:
                int i2 = WifiDetailsActivity.ag;
                wifiDetailsActivity.m();
                break;
            default:
                int i3 = WifiDetailsActivity.ag;
                wifiDetailsActivity.m();
                break;
        }
    }
}
