package a;

import androidx.activity.contextaware.ContextAwareKt$withContextAvailable$2$1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class cl extends go implements ck, er {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(cl.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(cl.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    public final ec d;
    public final ei e;
    public gq f;

    public cl(ec ecVar) {
        super(1);
        this.d = ecVar;
        this.e = ecVar.getContext();
        this._decision = 0;
        this._state = v.f322a;
    }

    public static void p(ContextAwareKt$withContextAvailable$2$1 contextAwareKt$withContextAvailable$2$1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + contextAwareKt$withContextAvailable$2$1 + ", already has " + obj).toString());
    }

    @Override // a.go
    public final void a(Object obj, CancellationException cancellationException) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof qn) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof dn) {
                return;
            }
            mn mnVar = null;
            if (!(obj2 instanceof dl)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                dl dlVar = new dl(obj2, mnVar, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, dlVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            dl dlVar2 = (dl) obj2;
            if (dlVar2.e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            dl dlVarA = dl.a(dlVar2, null, cancellationException, 15);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, dlVarA)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                    break;
                }
            }
            mn mnVar2 = dlVar2.b;
            if (mnVar2 != null) {
                g(mnVar2, cancellationException);
            }
            js jsVar = dlVar2.c;
            if (jsVar != null) {
                try {
                    jsVar.invoke(cancellationException);
                    return;
                } catch (Throwable th) {
                    ky.b(this.e, new dq("Exception in resume onCancellation handler for " + this, th));
                    return;
                }
            }
            return;
        }
    }

    @Override // a.go
    public final ec b() {
        return this.d;
    }

    @Override // a.go
    public final Throwable c(Object obj) {
        Throwable thC = super.c(obj);
        if (thC != null) {
            return thC;
        }
        return null;
    }

    @Override // a.go
    public final Object d(Object obj) {
        return obj instanceof dl ? ((dl) obj).f56a : obj;
    }

    @Override // a.go
    public final Object f() {
        return this._state;
    }

    public final void g(mn mnVar, Throwable th) {
        try {
            mnVar.f187a.invoke((Object) th);
        } catch (Throwable th2) {
            ky.b(this.e, new dq("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // a.er
    public final er getCallerFrame() {
        ec ecVar = this.d;
        if (ecVar instanceof er) {
            return (er) ecVar;
        }
        return null;
    }

    @Override // a.ec
    public final ei getContext() {
        return this.e;
    }

    public final void h(ContextAwareKt$withContextAvailable$2$1 contextAwareKt$withContextAvailable$2$1, Throwable th) {
        try {
            contextAwareKt$withContextAvailable$2$1.invoke((Object) th);
        } catch (Throwable th2) {
            ky.b(this.e, new dq("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void i(Throwable th) {
        gq gqVar;
        while (true) {
            Object obj = this._state;
            if (obj instanceof qn) {
                boolean z = obj instanceof mn;
                cm cmVar = new cm(this, th, z);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, cmVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                mn mnVar = z ? (mn) obj : null;
                if (mnVar != null) {
                    g(mnVar, th);
                }
                if (!o() && (gqVar = this.f) != null) {
                    gqVar.dispose();
                    this.f = qm.f256a;
                }
                j(this.c);
                return;
            }
            return;
        }
    }

    public final void j(int i) {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                ec ecVar = this.d;
                boolean z = i == 4;
                if (!z && (ecVar instanceof gm)) {
                    boolean z2 = i == 1 || i == 2;
                    int i3 = this.c;
                    if (z2 == (i3 == 1 || i3 == 2)) {
                        gm gmVar = (gm) ecVar;
                        el elVar = gmVar.d;
                        ei context = gmVar.e.getContext();
                        if (elVar.isDispatchNeeded(context)) {
                            elVar.dispatch(context, this);
                            return;
                        }
                        ic icVarA = vf.a();
                        if (icVarA.f130a >= 4294967296L) {
                            icVarA.c(this);
                            return;
                        }
                        icVarA.e(true);
                        try {
                            kz.f(this, this.d, true);
                            do {
                            } while (icVarA.f());
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        return;
                    }
                }
                kz.f(this, ecVar, z);
                return;
            }
        } while (!g.compareAndSet(this, 0, 2));
    }

    public final Object k() throws Throwable {
        mt mtVar;
        gm gmVar;
        Throwable thJ;
        Throwable thJ2;
        qm qmVar = qm.f256a;
        boolean zO = o();
        do {
            int i = this._decision;
            if (i != 0) {
                if (i != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zO) {
                    ec ecVar = this.d;
                    gmVar = ecVar instanceof gm ? (gm) ecVar : null;
                    if (gmVar != null && (thJ = gmVar.j(this)) != null) {
                        gq gqVar = this.f;
                        if (gqVar != null) {
                            gqVar.dispose();
                            this.f = qmVar;
                        }
                        i(thJ);
                    }
                }
                Object obj = this._state;
                if (obj instanceof dn) {
                    throw ((dn) obj).f58a;
                }
                int i2 = this.c;
                if ((i2 != 1 && i2 != 2) || (mtVar = (mt) this.e.get(ee.e)) == null || mtVar.a()) {
                    return d(obj);
                }
                CancellationException cancellationExceptionL = ((na) mtVar).l();
                a(obj, cancellationExceptionL);
                throw cancellationExceptionL;
            }
        } while (!g.compareAndSet(this, 0, 1));
        if (this.f == null) {
            m();
        }
        if (zO) {
            ec ecVar2 = this.d;
            gmVar = ecVar2 instanceof gm ? (gm) ecVar2 : null;
            if (gmVar != null && (thJ2 = gmVar.j(this)) != null) {
                gq gqVar2 = this.f;
                if (gqVar2 != null) {
                    gqVar2.dispose();
                    this.f = qmVar;
                }
                i(thJ2);
            }
        }
        return eq.f74a;
    }

    public final void l() {
        gq gqVarM = m();
        if (gqVarM == null || (this._state instanceof qn)) {
            return;
        }
        gqVarM.dispose();
        this.f = qm.f256a;
    }

    public final gq m() {
        mt mtVar = (mt) this.e.get(ee.e);
        if (mtVar == null) {
            return null;
        }
        gq gqVarC = ky.c(mtVar, new cr(this), 2);
        this.f = gqVarC;
        return gqVarC;
    }

    public final void n(ContextAwareKt$withContextAvailable$2$1 contextAwareKt$withContextAvailable$2$1) {
        mn mnVar = new mn(contextAwareKt$withContextAvailable$2$1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof v) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mnVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            CancellationException cancellationException = null;
            if (obj instanceof mn) {
                p(contextAwareKt$withContextAvailable$2$1, obj);
                throw null;
            }
            if (obj instanceof dn) {
                dn dnVar = (dn) obj;
                if (!dn.b.compareAndSet(dnVar, 0, 1)) {
                    p(contextAwareKt$withContextAvailable$2$1, obj);
                    throw null;
                }
                if (obj instanceof cm) {
                    h(contextAwareKt$withContextAvailable$2$1, dnVar.f58a);
                    return;
                }
                return;
            }
            if (!(obj instanceof dl)) {
                dl dlVar = new dl(obj, mnVar, cancellationException, 28);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, dlVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            dl dlVar2 = (dl) obj;
            if (dlVar2.b != null) {
                p(contextAwareKt$withContextAvailable$2$1, obj);
                throw null;
            }
            Throwable th = dlVar2.e;
            if (th != null) {
                h(contextAwareKt$withContextAvailable$2$1, th);
                return;
            }
            dl dlVarA = dl.a(dlVar2, mnVar, null, 29);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = h;
            while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, dlVarA)) {
                if (atomicReferenceFieldUpdater3.get(this) != obj) {
                    break;
                }
            }
            return;
        }
    }

    public final boolean o() {
        return this.c == 2 && ((gm) this.d).g();
    }

    @Override // a.ec
    public final void resumeWith(Object obj) {
        gq gqVar;
        Throwable thA = su.a(obj);
        if (thA != null) {
            obj = new dn(false, thA);
        }
        int i = this.c;
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof qn)) {
                if (obj2 instanceof cm) {
                    if (cm.c.compareAndSet((cm) obj2, 0, 1)) {
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            qn qnVar = (qn) obj2;
            Object dlVar = (!(obj instanceof dn) && (i == 1 || i == 2) && (qnVar instanceof mn)) ? new dl(obj, (mn) qnVar, null, 16) : obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, dlVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!o() && (gqVar = this.f) != null) {
                gqVar.dispose();
                this.f = qm.f256a;
            }
            j(i);
            return;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(pd.k(this.d));
        sb.append("){");
        Object obj = this._state;
        sb.append(obj instanceof qn ? "Active" : obj instanceof cm ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(pd.d(this));
        return sb.toString();
    }
}
