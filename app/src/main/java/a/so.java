package a;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class so {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f284a;
    public final Handler b = new Handler(Looper.getMainLooper(), new sn());

    public final synchronized void a(sf sfVar, boolean z) {
        try {
            if (this.f284a || z) {
                this.b.obtainMessage(1, sfVar).sendToTarget();
            } else {
                this.f284a = true;
                sfVar.recycle();
                this.f284a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
