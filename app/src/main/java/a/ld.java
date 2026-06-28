package a;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
public final class ld extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(9);
        super.run();
    }
}
