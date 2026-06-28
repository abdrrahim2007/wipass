package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class my implements ly {
    private volatile /* synthetic */ Object _rootCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ql f191a;
    private volatile /* synthetic */ int _isCompleting = 0;
    private volatile /* synthetic */ Object _exceptionsHolder = null;

    public my(ql qlVar, Throwable th) {
        this.f191a = qlVar;
        this._rootCause = th;
    }

    @Override // a.ly
    public final boolean a() {
        return ((Throwable) this._rootCause) == null;
    }

    public final void b(Throwable th) {
        Throwable th2 = (Throwable) this._rootCause;
        if (th2 == null) {
            this._rootCause = th;
            return;
        }
        if (th == th2) {
            return;
        }
        Object obj = this._exceptionsHolder;
        if (obj == null) {
            this._exceptionsHolder = th;
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        this._exceptionsHolder = arrayList;
    }

    @Override // a.ly
    public final ql c() {
        return this.f191a;
    }

    public final Throwable d() {
        return (Throwable) this._rootCause;
    }

    public final boolean e() {
        return ((Throwable) this._rootCause) != null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean f() {
        return this._isCompleting;
    }

    public final boolean g() {
        return this._exceptionsHolder == bs.f;
    }

    public final ArrayList h(Throwable th) {
        ArrayList arrayList;
        Object obj = this._exceptionsHolder;
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable th2 = (Throwable) this._rootCause;
        if (th2 != null) {
            arrayList.add(0, th2);
        }
        if (th != null && !th.equals(th2)) {
            arrayList.add(th);
        }
        this._exceptionsHolder = bs.f;
        return arrayList;
    }

    public final void i() {
        this._isCompleting = 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
    public final String toString() {
        return "Finishing[cancelling=" + e() + ", completing=" + ((boolean) this._isCompleting) + ", rootCause=" + ((Throwable) this._rootCause) + ", exceptions=" + this._exceptionsHolder + ", list=" + this.f191a + ']';
    }
}
