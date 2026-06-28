package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class mz extends ay {
    public final mw b;
    public ql c;
    public final /* synthetic */ na d;
    public final /* synthetic */ ly e;

    public mz(mw mwVar, na naVar, ly lyVar) {
        this.d = naVar;
        this.e = lyVar;
        this.b = mwVar;
    }

    @Override // a.ay
    public final void b(Object obj, Object obj2) {
        oe oeVar = (oe) obj;
        boolean z = obj2 == null;
        mw mwVar = this.b;
        ly lyVar = z ? mwVar : this.c;
        if (lyVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = oe.f206a;
            while (!atomicReferenceFieldUpdater.compareAndSet(oeVar, this, lyVar)) {
                if (atomicReferenceFieldUpdater.get(oeVar) != this) {
                    return;
                }
            }
            if (z) {
                ql qlVar = this.c;
                mk.c(qlVar);
                mwVar.f(qlVar);
            }
        }
    }

    @Override // a.ay
    public final fb c(Object obj) {
        if (this.d.p() == this.e) {
            return null;
        }
        return pd.b;
    }
}
