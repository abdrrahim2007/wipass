package a;

import android.net.wifi.WifiNetworkSpecifier;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class wu {
    public static /* synthetic */ WifiNetworkSpecifier.Builder b() {
        return new WifiNetworkSpecifier.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder e() {
        return new WindowInsets.Builder();
    }

    public static /* synthetic */ WindowInsets.Builder f(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }
}
