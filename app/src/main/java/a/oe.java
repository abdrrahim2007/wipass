package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class oe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f206a = AtomicReferenceFieldUpdater.newUpdater(oe.class, Object.class, "_next");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(oe.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(oe.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        r5 = a.oe.f206a;
        r4 = ((a.rv) r4).f276a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
    
        if (r5.compareAndSet(r3, r2, r4) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        if (r5.get(r3) == r2) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final a.oe e() {
        /*
            r8 = this;
        L0:
            java.lang.Object r0 = r8._prev
            a.oe r0 = (a.oe) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r8) goto L1e
            if (r0 != r2) goto Le
            goto L27
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a.oe.b
        L10:
            boolean r1 = r5.compareAndSet(r8, r0, r2)
            if (r1 == 0) goto L17
            goto L27
        L17:
            java.lang.Object r1 = r5.get(r8)
            if (r1 == r0) goto L10
            goto L0
        L1e:
            boolean r5 = r8.j()
            if (r5 == 0) goto L25
            return r1
        L25:
            if (r4 != 0) goto L28
        L27:
            return r2
        L28:
            boolean r5 = r4 instanceof a.qr
            if (r5 == 0) goto L32
            a.qr r4 = (a.qr) r4
            r4.a(r2)
            goto L0
        L32:
            boolean r5 = r4 instanceof a.rv
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = a.oe.f206a
            a.rv r4 = (a.rv) r4
            a.oe r4 = r4.f276a
        L3e:
            boolean r6 = r5.compareAndSet(r3, r2, r4)
            if (r6 == 0) goto L46
            r2 = r3
            goto L6
        L46:
            java.lang.Object r6 = r5.get(r3)
            if (r6 == r2) goto L3e
            goto L0
        L4d:
            java.lang.Object r2 = r2._prev
            a.oe r2 = (a.oe) r2
            goto L7
        L52:
            r3 = r4
            a.oe r3 = (a.oe) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.oe.e():a.oe");
    }

    public final void f(oe oeVar) {
        while (true) {
            oe oeVar2 = (oe) oeVar._prev;
            if (g() != oeVar) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            while (!atomicReferenceFieldUpdater.compareAndSet(oeVar, oeVar2, this)) {
                if (atomicReferenceFieldUpdater.get(oeVar) != oeVar2) {
                    break;
                }
            }
            if (j()) {
                oeVar.e();
                return;
            }
            return;
        }
    }

    public final Object g() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof qr)) {
                return obj;
            }
            ((qr) obj).a(this);
        }
    }

    public final oe h() {
        oe oeVar;
        Object objG = g();
        rv rvVar = objG instanceof rv ? (rv) objG : null;
        return (rvVar == null || (oeVar = rvVar.f276a) == null) ? (oe) objG : oeVar;
    }

    public final oe i() {
        oe oeVarE = e();
        if (oeVarE != null) {
            return oeVarE;
        }
        Object obj = this._prev;
        while (true) {
            oe oeVar = (oe) obj;
            if (!oeVar.j()) {
                return oeVar;
            }
            obj = oeVar._prev;
        }
    }

    public boolean j() {
        return g() instanceof rv;
    }

    public final void k() {
        while (true) {
            Object objG = g();
            if (objG instanceof rv) {
                return;
            }
            if (objG == this) {
                return;
            }
            oe oeVar = (oe) objG;
            rv rvVar = (rv) oeVar._removedRef;
            if (rvVar == null) {
                rvVar = new rv(oeVar);
                c.lazySet(oeVar, rvVar);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f206a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, objG, rvVar)) {
                if (atomicReferenceFieldUpdater.get(this) != objG) {
                    break;
                }
            }
            oeVar.e();
            return;
        }
    }

    public String toString() {
        return new od(this) + '@' + pd.d(this);
    }
}
