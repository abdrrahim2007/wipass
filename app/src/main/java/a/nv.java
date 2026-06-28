package a;

/* JADX INFO: loaded from: classes.dex */
public final class nv extends el implements Runnable, fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final el f199a;
    public final int b;
    public final of c;
    public final Object d;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public nv(el elVar, int i) {
        this.f199a = elVar;
        this.b = i;
        if ((elVar instanceof fx ? (fx) elVar : null) == null) {
            int i2 = fo.f86a;
        }
        this.c = new of();
        this.d = new Object();
    }

    public final boolean b() {
        synchronized (this.d) {
            if (this.runningWorkers >= this.b) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // a.el
    public final void dispatch(ei eiVar, Runnable runnable) {
        this.c.a(runnable);
        if (this.runningWorkers < this.b && b()) {
            this.f199a.dispatch(this, this);
        }
    }

    @Override // a.el
    public final void dispatchYield(ei eiVar, Runnable runnable) {
        this.c.a(runnable);
        if (this.runningWorkers < this.b && b()) {
            this.f199a.dispatchYield(this, this);
        }
    }

    @Override // a.el
    public final el limitedParallelism(int i) {
        mk.i(i);
        return i >= this.b ? this : super.limitedParallelism(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r1 = r4.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r4.c.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r4.runningWorkers++;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            a.of r2 = r4.c
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            a.hb r3 = a.hb.f109a
            a.ky.b(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            a.el r2 = r4.f199a
            boolean r2 = r2.isDispatchNeeded(r4)
            if (r2 == 0) goto L2
            a.el r0 = r4.f199a
            r0.dispatch(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.d
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L45
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L45
            a.of r2 = r4.c     // Catch: java.lang.Throwable -> L45
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L45
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L45
            monitor-exit(r1)
            goto L1
        L45:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.nv.run():void");
    }
}
