package a;

import android.os.Process;
import java.lang.ref.ReferenceQueue;

/* JADX INFO: loaded from: classes.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f340a;
    public final /* synthetic */ Object b;

    public /* synthetic */ w(int i, Object obj) {
        this.f340a = i;
        this.b = obj;
    }

    /* JADX INFO: Infinite loop detected, blocks: 8, insns: 0 */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f340a) {
            case 0:
                Process.setThreadPriority(10);
                ((Runnable) this.b).run();
                break;
            case 1:
                z zVar = (z) this.b;
                zVar.getClass();
                while (true) {
                    try {
                        zVar.c((y) ((ReferenceQueue) zVar.c).remove());
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                break;
            default:
                sb sbVar = (sb) this.b;
                sbVar.c.r(sbVar);
                break;
        }
    }
}
