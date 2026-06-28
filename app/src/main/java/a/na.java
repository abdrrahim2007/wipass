package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class na implements mt, qx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f192a = AtomicReferenceFieldUpdater.newUpdater(na.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public na(boolean z) {
        this._state = z ? bs.h : bs.g;
        this._parentHandle = null;
    }

    public static ct v(oe oeVar) {
        while (oeVar.j()) {
            oeVar = oeVar.i();
        }
        while (true) {
            oeVar = oeVar.h();
            if (!oeVar.j()) {
                if (oeVar instanceof ct) {
                    return (ct) oeVar;
                }
                if (oeVar instanceof ql) {
                    return null;
                }
            }
        }
    }

    public static String z(Object obj) {
        if (!(obj instanceof my)) {
            return obj instanceof ly ? ((ly) obj).a() ? "Active" : "New" : obj instanceof dn ? "Cancelled" : "Completed";
        }
        my myVar = (my) obj;
        return myVar.e() ? "Cancelling" : myVar.f() ? "Completing" : "Active";
    }

    @Override // a.mt
    public boolean a() {
        Object objP = p();
        return (objP instanceof ly) && ((ly) objP).a();
    }

    public final Object aa(Object obj, Object obj2) {
        if (!(obj instanceof ly)) {
            return bs.b;
        }
        if (((obj instanceof ha) || (obj instanceof mw)) && !(obj instanceof ct) && !(obj2 instanceof dn)) {
            ly lyVar = (ly) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f192a;
            Object lzVar = obj2 instanceof ly ? new lz((ly) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, lyVar, lzVar)) {
                if (atomicReferenceFieldUpdater.get(this) != lyVar) {
                    return bs.d;
                }
            }
            i(lyVar, obj2);
            return obj2;
        }
        ly lyVar2 = (ly) obj;
        ql qlVarN = n(lyVar2);
        if (qlVarN == null) {
            return bs.d;
        }
        ct ctVarV = null;
        my myVar = lyVar2 instanceof my ? (my) lyVar2 : null;
        if (myVar == null) {
            myVar = new my(qlVarN, null);
        }
        synchronized (myVar) {
            if (myVar.f()) {
                return bs.b;
            }
            myVar.i();
            if (myVar != lyVar2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f192a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, lyVar2, myVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != lyVar2) {
                        return bs.d;
                    }
                }
            }
            boolean zE = myVar.e();
            dn dnVar = obj2 instanceof dn ? (dn) obj2 : null;
            if (dnVar != null) {
                myVar.b(dnVar.f58a);
            }
            Throwable thD = myVar.d();
            if (zE) {
                thD = null;
            }
            if (thD != null) {
                w(qlVarN, thD);
            }
            ct ctVar = lyVar2 instanceof ct ? (ct) lyVar2 : null;
            if (ctVar == null) {
                ql qlVarC = lyVar2.c();
                if (qlVarC != null) {
                    ctVarV = v(qlVarC);
                }
            } else {
                ctVarV = ctVar;
            }
            if (ctVarV != null) {
                while (ky.c(ctVarV.e, new mx(this, myVar, ctVarV, obj2), 1) == qm.f256a) {
                    ctVarV = v(ctVarV);
                    if (ctVarV == null) {
                    }
                }
                return bs.c;
            }
            return k(myVar, obj2);
        }
    }

    public final boolean b(ly lyVar, ql qlVar, mw mwVar) {
        oe oeVarI;
        mz mzVar = new mz(mwVar, this, lyVar);
        loop0: while (true) {
            oeVarI = qlVar.i();
            oe.b.lazySet(mwVar, oeVarI);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = oe.f206a;
            atomicReferenceFieldUpdater.lazySet(mwVar, qlVar);
            mzVar.c = qlVar;
            while (!atomicReferenceFieldUpdater.compareAndSet(oeVarI, qlVar, mzVar)) {
                if (atomicReferenceFieldUpdater.get(oeVarI) != qlVar) {
                    break;
                }
            }
        }
        return mzVar.a(oeVarI) == null;
    }

    public void d(Object obj) {
        c(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[PHI: r0
  0x0038: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x0006, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(java.lang.Object r10) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.na.e(java.lang.Object):boolean");
    }

    public final boolean f(Throwable th) {
        if (t()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        cs csVar = (cs) this._parentHandle;
        return (csVar == null || csVar == qm.f256a) ? z : csVar.b(th) || z;
    }

    @Override // a.ei
    public final Object fold(Object obj, jw jwVar) {
        return jwVar.invoke(obj, this);
    }

    public String g() {
        return "Job was cancelled";
    }

    @Override // a.ei
    public final eg get(eh ehVar) {
        mk.h(ehVar, "key");
        if (mk.a(ee.e, ehVar)) {
            return this;
        }
        return null;
    }

    @Override // a.eg
    public final eh getKey() {
        return ee.e;
    }

    public boolean h(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return e(th) && m();
    }

    public final void i(ly lyVar, Object obj) {
        cs csVar = (cs) this._parentHandle;
        if (csVar != null) {
            csVar.dispose();
            this._parentHandle = qm.f256a;
        }
        dq dqVar = null;
        dn dnVar = obj instanceof dn ? (dn) obj : null;
        Throwable th = dnVar != null ? dnVar.f58a : null;
        if (lyVar instanceof mw) {
            try {
                ((mw) lyVar).m(th);
                return;
            } catch (Throwable th2) {
                r(new dq("Exception in completion handler " + lyVar + " for " + this, th2));
                return;
            }
        }
        ql qlVarC = lyVar.c();
        if (qlVarC != null) {
            for (oe oeVarH = (oe) qlVarC.g(); !mk.a(oeVarH, qlVarC); oeVarH = oeVarH.h()) {
                if (oeVarH instanceof mw) {
                    mw mwVar = (mw) oeVarH;
                    try {
                        mwVar.m(th);
                    } catch (Throwable th3) {
                        if (dqVar != null) {
                            vs.a(dqVar, th3);
                        } else {
                            dqVar = new dq("Exception in completion handler " + mwVar + " for " + this, th3);
                        }
                    }
                }
            }
            if (dqVar != null) {
                r(dqVar);
            }
        }
    }

    public final Throwable j(Object obj) {
        Throwable thD;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        na naVar = (na) ((qx) obj);
        Object objP = naVar.p();
        if (objP instanceof my) {
            thD = ((my) objP).d();
        } else if (objP instanceof dn) {
            thD = ((dn) objP).f58a;
        } else {
            if (objP instanceof ly) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objP).toString());
            }
            thD = null;
        }
        CancellationException cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        return cancellationException == null ? new mu("Parent job is ".concat(z(objP)), thD, naVar) : cancellationException;
    }

    public final Object k(my myVar, Object obj) {
        Object obj2 = null;
        Throwable muVar = null;
        dn dnVar = obj instanceof dn ? (dn) obj : null;
        Throwable th = dnVar != null ? dnVar.f58a : null;
        synchronized (myVar) {
            myVar.e();
            ArrayList arrayListH = myVar.h(th);
            if (!arrayListH.isEmpty()) {
                int size = arrayListH.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Object obj3 = arrayListH.get(i);
                    i++;
                    if (!(((Throwable) obj3) instanceof CancellationException)) {
                        obj2 = obj3;
                        break;
                    }
                }
                muVar = (Throwable) obj2;
                if (muVar == null) {
                    muVar = (Throwable) arrayListH.get(0);
                }
            } else if (myVar.e()) {
                muVar = new mu(g(), null, this);
            }
            if (muVar != null && arrayListH.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListH.size()));
                int size2 = arrayListH.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj4 = arrayListH.get(i2);
                    i2++;
                    Throwable th2 = (Throwable) obj4;
                    if (th2 != muVar && th2 != muVar && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        vs.a(muVar, th2);
                    }
                }
            }
        }
        if (muVar != null && muVar != th) {
            obj = new dn(false, muVar);
        }
        if (muVar != null && (f(muVar) || q(muVar))) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            }
            dn.b.compareAndSet((dn) obj, 0, 1);
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f192a;
        Object lzVar = obj instanceof ly ? new lz((ly) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, myVar, lzVar) && atomicReferenceFieldUpdater.get(this) == myVar) {
        }
        i(myVar, obj);
        return obj;
    }

    public final CancellationException l() {
        CancellationException cancellationException;
        Object objP = p();
        if (!(objP instanceof my)) {
            if (objP instanceof ly) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objP instanceof dn)) {
                return new mu(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((dn) objP).f58a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new mu(g(), th, this) : cancellationException;
        }
        Throwable thD = ((my) objP).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = g();
        }
        return new mu(strConcat, thD, this);
    }

    public boolean m() {
        return true;
    }

    @Override // a.ei
    public final ei minusKey(eh ehVar) {
        return bs.e(this, ehVar);
    }

    public final ql n(ly lyVar) {
        ql qlVarC = lyVar.c();
        if (qlVarC != null) {
            return qlVarC;
        }
        if (lyVar instanceof ha) {
            return new ql();
        }
        if (lyVar instanceof mw) {
            y((mw) lyVar);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + lyVar).toString());
    }

    public final cs o() {
        return (cs) this._parentHandle;
    }

    public final Object p() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof qr)) {
                return obj;
            }
            ((qr) obj).a(this);
        }
    }

    @Override // a.ei
    public final ei plus(ei eiVar) {
        mk.h(eiVar, "context");
        return vs.c(this, eiVar);
    }

    public boolean q(Throwable th) {
        return false;
    }

    public final void s(mt mtVar) {
        qm qmVar = qm.f256a;
        if (mtVar == null) {
            this._parentHandle = qmVar;
            return;
        }
        na naVar = (na) mtVar;
        loop0: while (true) {
            Object objP = naVar.p();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f192a;
            if (!(objP instanceof ha)) {
                if (!(objP instanceof lx)) {
                    break;
                }
                ql qlVar = ((lx) objP).f175a;
                while (!atomicReferenceFieldUpdater.compareAndSet(naVar, objP, qlVar)) {
                    if (atomicReferenceFieldUpdater.get(naVar) != objP) {
                        break;
                    }
                }
                naVar.getClass();
                break loop0;
            }
            if (!((ha) objP).f108a) {
                ha haVar = bs.h;
                while (!atomicReferenceFieldUpdater.compareAndSet(naVar, objP, haVar)) {
                    if (atomicReferenceFieldUpdater.get(naVar) != objP) {
                        break;
                    }
                }
                naVar.getClass();
                break loop0;
            }
            break;
        }
        cs csVar = (cs) ky.c(naVar, new ct(this), 2);
        this._parentHandle = csVar;
        if (p() instanceof ly) {
            return;
        }
        csVar.dispose();
        this._parentHandle = qmVar;
    }

    public boolean t() {
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + z(p()) + '}');
        sb.append('@');
        sb.append(pd.d(this));
        return sb.toString();
    }

    public final Object u(Object obj) {
        Object objAa;
        do {
            objAa = aa(p(), obj);
            if (objAa == bs.b) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                dn dnVar = obj instanceof dn ? (dn) obj : null;
                throw new IllegalStateException(str, dnVar != null ? dnVar.f58a : null);
            }
        } while (objAa == bs.d);
        return objAa;
    }

    public final void w(ql qlVar, Throwable th) {
        dq dqVar = null;
        for (oe oeVarH = (oe) qlVar.g(); !mk.a(oeVarH, qlVar); oeVarH = oeVarH.h()) {
            if (oeVarH instanceof mv) {
                mw mwVar = (mw) oeVarH;
                try {
                    mwVar.m(th);
                } catch (Throwable th2) {
                    if (dqVar != null) {
                        vs.a(dqVar, th2);
                    } else {
                        dqVar = new dq("Exception in completion handler " + mwVar + " for " + this, th2);
                    }
                }
            }
        }
        if (dqVar != null) {
            r(dqVar);
        }
        f(th);
    }

    public final void y(mw mwVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ql qlVar = new ql();
        mwVar.getClass();
        oe.b.lazySet(qlVar, mwVar);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = oe.f206a;
        atomicReferenceFieldUpdater2.lazySet(qlVar, mwVar);
        loop0: while (true) {
            if (mwVar.g() == mwVar) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(mwVar, mwVar, qlVar)) {
                    if (atomicReferenceFieldUpdater2.get(mwVar) != mwVar) {
                        break;
                    }
                }
                qlVar.f(mwVar);
                break loop0;
            }
            break;
        }
        oe oeVarH = mwVar.h();
        do {
            atomicReferenceFieldUpdater = f192a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, mwVar, oeVarH)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == mwVar);
    }

    public void x() {
    }

    public void c(Object obj) {
    }

    public void r(dq dqVar) {
        throw dqVar;
    }
}
