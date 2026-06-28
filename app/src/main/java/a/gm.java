package a;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class gm extends go implements er, ec {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(gm.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public final el d;
    public final ec e;
    public Object f;
    public final Object g;

    public gm(el elVar, ec ecVar) {
        super(-1);
        this.d = elVar;
        this.e = ecVar;
        this.f = ky.f159a;
        Object objFold = ecVar.getContext().fold(0, di.f);
        mk.c(objFold);
        this.g = objFold;
        this._reusableCancellableContinuation = null;
    }

    @Override // a.go
    public final void a(Object obj, CancellationException cancellationException) {
        if (obj instanceof dp) {
            throw null;
        }
    }

    @Override // a.go
    public final Object f() {
        Object obj = this.f;
        this.f = ky.f159a;
        return obj;
    }

    public final boolean g() {
        return this._reusableCancellableContinuation != null;
    }

    @Override // a.er
    public final er getCallerFrame() {
        ec ecVar = this.e;
        if (ecVar instanceof er) {
            return (er) ecVar;
        }
        return null;
    }

    @Override // a.ec
    public final ei getContext() {
        return this.e.getContext();
    }

    public final boolean h(CancellationException cancellationException) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            fb fbVar = ky.b;
            if (mk.a(obj, fbVar)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, fbVar, cancellationException)) {
                    if (atomicReferenceFieldUpdater.get(this) != fbVar) {
                        break;
                    }
                }
                return true;
            }
            if (obj instanceof Throwable) {
                return true;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj) {
                    break;
                }
            }
            return false;
        }
    }

    public final void i() {
        gq gqVar;
        Object obj = this._reusableCancellableContinuation;
        cl clVar = obj instanceof cl ? (cl) obj : null;
        if (clVar == null || (gqVar = clVar.f) == null) {
            return;
        }
        gqVar.dispose();
        clVar.f = qm.f256a;
    }

    public final Throwable j(cl clVar) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            fb fbVar = ky.b;
            if (obj == fbVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, fbVar, clVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != fbVar) {
                        break;
                    }
                }
                return null;
            }
            if (!(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, null)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            return (Throwable) obj;
        }
    }

    @Override // a.ec
    public final void resumeWith(Object obj) {
        ec ecVar = this.e;
        ei context = ecVar.getContext();
        Throwable thA = su.a(obj);
        Object dnVar = thA == null ? obj : new dn(false, thA);
        el elVar = this.d;
        if (elVar.isDispatchNeeded(context)) {
            this.f = dnVar;
            this.c = 0;
            elVar.dispatch(context, this);
            return;
        }
        ic icVarA = vf.a();
        if (icVarA.f130a >= 4294967296L) {
            this.f = dnVar;
            this.c = 0;
            icVarA.c(this);
            return;
        }
        icVarA.e(true);
        try {
            ei context2 = ecVar.getContext();
            Object objP = mk.p(context2, this.g);
            try {
                ecVar.resumeWith(obj);
                while (icVarA.f()) {
                }
            } finally {
                mk.n(context2, objP);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.d + ", " + pd.k(this.e) + ']';
    }

    @Override // a.go
    public final ec b() {
        return this;
    }
}
