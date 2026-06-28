package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class mo extends mv {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(mo.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;
    public final mw e;

    public mo(mw mwVar) {
        this.e = mwVar;
    }

    @Override // a.js
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m((Throwable) obj);
        return vx.f338a;
    }

    @Override // a.mw
    public final void m(Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }
}
