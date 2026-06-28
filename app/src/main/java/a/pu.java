package a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class pu {
    public static final int e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f243a;
    public final ActivityManager b;
    public final fb c;
    public final float d;

    static {
        e = Build.VERSION.SDK_INT < 26 ? 4 : 1;
    }

    public pu(Context context) {
        this.d = e;
        this.f243a = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.b = activityManager;
        this.c = new fb(8, context.getResources().getDisplayMetrics());
        if (Build.VERSION.SDK_INT < 26 || !activityManager.isLowRamDevice()) {
            return;
        }
        this.d = 0.0f;
    }
}
