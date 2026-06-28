package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class gn extends sz {
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(gn.class, "_decision");
    private volatile /* synthetic */ int _decision;

    public gn(ec ecVar, ei eiVar) {
        super(ecVar, eiVar);
        this._decision = 0;
    }

    public final Object ab() throws Throwable {
        ly lyVar;
        do {
            int i = this._decision;
            if (i != 0) {
                if (i != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                Object objP = p();
                lz lzVar = objP instanceof lz ? (lz) objP : null;
                if (lzVar != null && (lyVar = lzVar.f176a) != null) {
                    objP = lyVar;
                }
                if (objP instanceof dn) {
                    throw ((dn) objP).f58a;
                }
                return objP;
            }
        } while (!d.compareAndSet(this, 0, 1));
        return eq.f74a;
    }

    @Override // a.sz, a.na
    public final void c(Object obj) {
        d(obj);
    }

    @Override // a.sz, a.na
    public final void d(Object obj) {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                ky.f(mk.l(obj), pd.e(this.c));
                return;
            }
        } while (!d.compareAndSet(this, 0, 2));
    }
}
