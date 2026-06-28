package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class ib extends ic implements fx {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(ib.class, Object.class, "_queue");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    static {
        AtomicReferenceFieldUpdater.newUpdater(ib.class, Object.class, "_delayed");
    }

    @Override // a.el
    public final void dispatch(ei eiVar, Runnable runnable) {
        g(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        a.fn.e.g(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(java.lang.Runnable r5) {
        /*
            r4 = this;
        L0:
            java.lang.Object r0 = r4._queue
            int r1 = r4._isCompleted
            if (r1 == 0) goto L7
            goto L46
        L7:
            if (r0 != 0) goto L1a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = a.ib.d
        Lb:
            r0 = 0
            boolean r0 = r1.compareAndSet(r4, r0, r5)
            if (r0 == 0) goto L13
            goto L64
        L13:
            java.lang.Object r0 = r1.get(r4)
            if (r0 == 0) goto Lb
            goto L0
        L1a:
            boolean r1 = r0 instanceof a.oh
            r2 = 1
            if (r1 == 0) goto L42
            r1 = r0
            a.oh r1 = (a.oh) r1
            int r3 = r1.a(r5)
            if (r3 == 0) goto L64
            if (r3 == r2) goto L2e
            r0 = 2
            if (r3 == r0) goto L46
            goto L0
        L2e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = a.ib.d
            a.oh r1 = r1.e()
        L34:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L3b
            goto L0
        L3b:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L34
            goto L0
        L42:
            a.fb r1 = a.mk.f184a
            if (r0 != r1) goto L4c
        L46:
            a.fn r0 = a.fn.e
            r0.g(r5)
            return
        L4c:
            a.oh r1 = new a.oh
            r3 = 8
            r1.<init>(r3, r2)
            r2 = r0
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.a(r2)
            r1.a(r5)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = a.ib.d
        L5e:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L72
        L64:
            java.lang.Thread r5 = r4.d()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r5) goto L71
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L71:
            return
        L72:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L5e
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ib.g(java.lang.Runnable):void");
    }

    public final boolean h() {
        as asVar = this.c;
        if (asVar != null && asVar.f15a != asVar.b) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        return obj instanceof oh ? ((oh) obj).d() : obj == mk.f184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0077, code lost:
    
        if (((a.oh) r0).d() == false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long i() {
        /*
            r7 = this;
            boolean r0 = r7.f()
            r1 = 0
            if (r0 == 0) goto La
            goto L7f
        La:
            java.lang.Object r0 = r7._delayed
            a.ia r0 = (a.ia) r0
        Le:
            java.lang.Object r0 = r7._queue
            r3 = 0
            if (r0 != 0) goto L14
            goto L4b
        L14:
            boolean r4 = r0 instanceof a.oh
            if (r4 == 0) goto L3b
            r3 = r0
            a.oh r3 = (a.oh) r3
            java.lang.Object r4 = r3.f()
            a.fb r5 = a.oh.g
            if (r4 == r5) goto L27
            r3 = r4
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            goto L4b
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a.ib.d
            a.oh r5 = r3.e()
        L2d:
            boolean r3 = r4.compareAndSet(r7, r0, r5)
            if (r3 == 0) goto L34
            goto Le
        L34:
            java.lang.Object r3 = r4.get(r7)
            if (r3 == r0) goto L2d
            goto Le
        L3b:
            a.fb r4 = a.mk.f184a
            if (r0 != r4) goto L40
            goto L4b
        L40:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = a.ib.d
        L42:
            boolean r5 = r4.compareAndSet(r7, r0, r3)
            if (r5 == 0) goto L85
            r3 = r0
            java.lang.Runnable r3 = (java.lang.Runnable) r3
        L4b:
            if (r3 == 0) goto L51
            r3.run()
            return r1
        L51:
            a.as r0 = r7.c
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto L5c
        L5a:
            r5 = r3
            goto L64
        L5c:
            int r5 = r0.f15a
            int r0 = r0.b
            if (r5 != r0) goto L63
            goto L5a
        L63:
            r5 = r1
        L64:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 != 0) goto L69
            goto L7f
        L69:
            java.lang.Object r0 = r7._queue
            if (r0 == 0) goto L80
            boolean r5 = r0 instanceof a.oh
            if (r5 == 0) goto L7a
            a.oh r0 = (a.oh) r0
            boolean r0 = r0.d()
            if (r0 != 0) goto L80
            goto L7f
        L7a:
            a.fb r5 = a.mk.f184a
            if (r0 != r5) goto L7f
            goto L84
        L7f:
            return r1
        L80:
            java.lang.Object r0 = r7._delayed
            a.ia r0 = (a.ia) r0
        L84:
            return r3
        L85:
            java.lang.Object r5 = r4.get(r7)
            if (r5 == r0) goto L42
            goto Le
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ib.i():long");
    }

    public final void j() {
        this._queue = null;
        this._delayed = null;
    }

    @Override // a.ic
    public void shutdown() {
        vf.f326a.set(null);
        this._isCompleted = 1;
        fb fbVar = mk.f184a;
        loop0: while (true) {
            Object obj = this._queue;
            if (obj != null) {
                if (!(obj instanceof oh)) {
                    if (obj != fbVar) {
                        oh ohVar = new oh(8, true);
                        ohVar.a((Runnable) obj);
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, ohVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((oh) obj).b();
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = d;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, null, fbVar)) {
                if (atomicReferenceFieldUpdater2.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (i() <= 0) {
        }
        System.nanoTime();
    }
}
