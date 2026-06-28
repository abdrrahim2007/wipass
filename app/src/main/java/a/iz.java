package a;

import android.net.ConnectivityManager;
import android.os.StrictMode;
import android.util.Log;
import com.root4arab.wipass.WifiDetailsActivity;

/* JADX INFO: loaded from: classes.dex */
public final class iz implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f139a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ iz(int i, Object obj, Object obj2) {
        this.f139a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConnectivityManager connectivityManager;
        switch (this.f139a) {
            case 0:
                lm lmVarA = lm.a();
                lmVarA.getClass();
                wh.a();
                lmVarA.d.set(true);
                ((ja) this.c).b.b = true;
                ((ja) this.c).f140a.getViewTreeObserver().removeOnDrawListener((ja) this.b);
                ((ja) this.c).b.f141a.clear();
                break;
            case 1:
                le leVar = (le) this.c;
                if (leVar.d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.b).run();
                } catch (Throwable unused) {
                    leVar.c.getClass();
                    Log.isLoggable("GlideExecutor", 6);
                    return;
                }
                break;
            default:
                WifiDetailsActivity wifiDetailsActivity = (WifiDetailsActivity) this.c;
                if (wifiDetailsActivity.ac) {
                    if (!wifiDetailsActivity.k(wifiDetailsActivity.p)) {
                        int i = wifiDetailsActivity.af + 1;
                        wifiDetailsActivity.af = i;
                        if (i < 15) {
                            wifiDetailsActivity.aa.postDelayed(this, 400L);
                        }
                    } else {
                        wifiDetailsActivity.z.removeCallbacksAndMessages(null);
                        xb xbVar = wifiDetailsActivity.ab;
                        if (xbVar != null && (connectivityManager = wifiDetailsActivity.t) != null) {
                            try {
                                connectivityManager.unregisterNetworkCallback(xbVar);
                                wifiDetailsActivity.ab = null;
                                break;
                            } catch (Exception unused2) {
                            }
                        }
                        wifiDetailsActivity.runOnUiThread(new gl(9, this, (String) this.b));
                    }
                    break;
                }
                break;
        }
    }
}
