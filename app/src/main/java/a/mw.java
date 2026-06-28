package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class mw extends oe implements gq, ly, js {
    public na d;

    @Override // a.ly
    public final boolean a() {
        return true;
    }

    @Override // a.ly
    public final ql c() {
        return null;
    }

    @Override // a.gq
    public final void dispose() {
        na naVarL = l();
        while (true) {
            Object objP = naVarL.p();
            if (!(objP instanceof mw)) {
                if (!(objP instanceof ly) || ((ly) objP).c() == null) {
                    return;
                }
                k();
                return;
            }
            if (objP != this) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.f192a;
            ha haVar = bs.h;
            while (!atomicReferenceFieldUpdater.compareAndSet(naVarL, objP, haVar)) {
                if (atomicReferenceFieldUpdater.get(naVarL) != objP) {
                    break;
                }
            }
            return;
        }
    }

    public final na l() {
        na naVar = this.d;
        if (naVar != null) {
            return naVar;
        }
        dq dqVar = new dq("lateinit property job has not been initialized");
        mk.o(dqVar, mk.class.getName());
        throw dqVar;
    }

    public abstract void m(Throwable th);

    @Override // a.oe
    public final String toString() {
        return getClass().getSimpleName() + '@' + pd.d(this) + "[job@" + pd.d(l()) + ']';
    }
}
