package a;

import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: loaded from: classes.dex */
public final class tv extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gh f305a;

    public tv(gh ghVar) {
        this.f305a = ghVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        wh.f().post(new tu(this, true));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        wh.f().post(new tu(this, false));
    }
}
