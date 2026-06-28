package a;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class pv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f244a;
    public final int b;
    public final int c;

    public pv(pu puVar) {
        Context context = puVar.f243a;
        float f = puVar.d;
        ActivityManager activityManager = puVar.b;
        int i = activityManager.isLowRamDevice() ? 2097152 : 4194304;
        this.c = i;
        int iRound = Math.round(activityManager.getMemoryClass() * 1048576 * (activityManager.isLowRamDevice() ? 0.33f : 0.4f));
        DisplayMetrics displayMetrics = (DisplayMetrics) puVar.c.b;
        float f2 = displayMetrics.widthPixels * displayMetrics.heightPixels * 4;
        int iRound2 = Math.round(f2 * f);
        int iRound3 = Math.round(f2 * 2.0f);
        int i2 = iRound - i;
        if (iRound3 + iRound2 <= i2) {
            this.b = iRound3;
            this.f244a = iRound2;
        } else {
            float f3 = i2 / (f + 2.0f);
            this.b = Math.round(2.0f * f3);
            this.f244a = Math.round(f3 * f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Formatter.formatFileSize(context, this.b);
            Formatter.formatFileSize(context, this.f244a);
            Formatter.formatFileSize(context, i);
            Formatter.formatFileSize(context, iRound);
            activityManager.getMemoryClass();
            activityManager.isLowRamDevice();
        }
    }
}
