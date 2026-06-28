package a;

import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ww implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f357a;
    public final /* synthetic */ WifiDetailsActivity b;
    public final /* synthetic */ String c;

    public /* synthetic */ ww(WifiDetailsActivity wifiDetailsActivity, String str, int i) {
        this.f357a = i;
        this.b = wifiDetailsActivity;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f357a;
        String str = this.c;
        WifiDetailsActivity wifiDetailsActivity = this.b;
        switch (i) {
            case 0:
                wifiDetailsActivity.aa.removeCallbacksAndMessages(null);
                int i2 = 1;
                if (!wifiDetailsActivity.k(wifiDetailsActivity.p)) {
                    wifiDetailsActivity.y++;
                    wifiDetailsActivity.runOnUiThread(new wx(wifiDetailsActivity, i2));
                } else {
                    wifiDetailsActivity.runOnUiThread(new ww(wifiDetailsActivity, str, i2));
                }
                break;
            default:
                int i3 = WifiDetailsActivity.ag;
                wifiDetailsActivity.h(str);
                break;
        }
    }
}
