package a;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class gf implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gj f96a;

    public gf(gj gjVar) {
        this.f96a = gjVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f96a) {
            try {
                gj gjVar = this.f96a;
                if (gjVar.i == null) {
                    return null;
                }
                gjVar.n();
                if (this.f96a.g()) {
                    this.f96a.l();
                    this.f96a.k = 0;
                }
                return null;
            } finally {
            }
        }
    }
}
