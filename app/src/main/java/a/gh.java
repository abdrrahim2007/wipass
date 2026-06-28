package a;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class gh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f97a;
    public final Object b;
    public final Object c;
    public final Object d;

    public gh(hp hpVar, tt ttVar) {
        this.d = new tv(this);
        this.c = hpVar;
        this.b = ttVar;
    }

    public void a() {
        gj.a((gj) this.d, this, false);
    }

    public File b() {
        File file;
        synchronized (((gj) this.d)) {
            try {
                gi giVar = (gi) this.b;
                if (giVar.f != this) {
                    throw new IllegalStateException();
                }
                if (!giVar.e) {
                    ((boolean[]) this.c)[0] = true;
                }
                file = giVar.d[0];
                ((gj) this.d).f99a.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public gh(gj gjVar, gi giVar) {
        this.d = gjVar;
        this.b = giVar;
        this.c = giVar.e ? null : new boolean[gjVar.g];
    }
}
