package a;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class eo implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73a;
    public final int b;
    public final long c;
    volatile /* synthetic */ long controlState;
    public final li d;
    public final li e;
    public final se f;
    private volatile /* synthetic */ long parkedWorkersStack;
    public static final fb j = new fb(11, "NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater g = AtomicLongFieldUpdater.newUpdater(eo.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(eo.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(eo.class, "_isTerminated");

    public eo(long j2, int i2, int i3) {
        this.f73a = i2;
        this.b = i3;
        this.c = j2;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.d = new li();
        this.e = new li();
        this.parkedWorkersStack = 0L;
        this.f = new se(i2 + 1);
        this.controlState = ((long) i2) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void c(eo eoVar, Runnable runnable, int i2) {
        eoVar.b(runnable, vd.f, (i2 & 4) == 0);
    }

    public final int a() {
        synchronized (this.f) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= this.f73a) {
                return 0;
            }
            if (i2 >= this.b) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (i4 <= 0 || this.f.b(i4) != null) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            en enVar = new en(this, i4);
            this.f.c(i4, enVar);
            if (i4 != ((int) (2097151 & h.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            enVar.start();
            return i3 + 1;
        }
    }

    public final void b(Runnable runnable, vb vbVar, boolean z) {
        va vcVar;
        int i2;
        vd.e.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof va) {
            vcVar = (va) runnable;
            vcVar.f323a = jNanoTime;
            vcVar.b = vbVar;
        } else {
            vcVar = new vc(runnable, jNanoTime, vbVar);
        }
        Thread threadCurrentThread = Thread.currentThread();
        va vaVarA = null;
        en enVar = threadCurrentThread instanceof en ? (en) threadCurrentThread : null;
        if (enVar == null || !mk.a(enVar.g, this)) {
            enVar = null;
        }
        if (enVar == null || (i2 = enVar.b) == 5 || (vcVar.b.f324a == 0 && i2 == 2)) {
            vaVarA = vcVar;
        } else {
            enVar.f = true;
            xf xfVar = enVar.f72a;
            if (z) {
                vaVarA = xfVar.a(vcVar);
            } else {
                xfVar.getClass();
                va vaVar = (va) xf.b.getAndSet(xfVar, vcVar);
                if (vaVar != null) {
                    vaVarA = xfVar.a(vaVar);
                }
            }
        }
        if (vaVarA != null) {
            if (!(vaVarA.b.f324a == 1 ? this.e.a(vaVarA) : this.d.a(vaVarA))) {
                throw new RejectedExecutionException("DefaultDispatcher was terminated");
            }
        }
        boolean z2 = z && enVar != null;
        if (vcVar.b.f324a == 0) {
            if (z2 || g() || f(this.controlState)) {
                return;
            }
            g();
            return;
        }
        long jAddAndGet = h.addAndGet(this, 2097152L);
        if (z2 || g() || f(jAddAndGet)) {
            return;
        }
        g();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a.eo.i
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof a.en
            r3 = 0
            if (r1 == 0) goto L17
            a.en r0 = (a.en) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            a.eo r1 = r0.g
            boolean r1 = a.mk.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            a.se r1 = r8.f
            monitor-enter(r1)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb6
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L72
            r1 = r2
        L32:
            a.se r5 = r8.f
            java.lang.Object r5 = r5.b(r1)
            a.mk.c(r5)
            a.en r5 = (a.en) r5
            if (r5 == r0) goto L6d
        L3f:
            boolean r6 = r5.isAlive()
            if (r6 == 0) goto L4e
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L3f
        L4e:
            a.xf r5 = r5.f72a
            a.li r6 = r8.e
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = a.xf.b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            a.va r7 = (a.va) r7
            if (r7 == 0) goto L62
            r6.a(r7)
        L62:
            a.va r7 = r5.c()
            if (r7 != 0) goto L69
            goto L6d
        L69:
            r6.a(r7)
            goto L62
        L6d:
            if (r1 == r4) goto L72
            int r1 = r1 + 1
            goto L32
        L72:
            a.li r1 = r8.e
            r1.b()
            a.li r1 = r8.d
            r1.b()
        L7c:
            if (r0 == 0) goto L84
            a.va r1 = r0.a(r2)
            if (r1 != 0) goto La5
        L84:
            a.li r1 = r8.d
            java.lang.Object r1 = r1.d()
            a.va r1 = (a.va) r1
            if (r1 != 0) goto La5
            a.li r1 = r8.e
            java.lang.Object r1 = r1.d()
            a.va r1 = (a.va) r1
            if (r1 != 0) goto La5
            if (r0 == 0) goto L9e
            r1 = 5
            r0.h(r1)
        L9e:
            r0 = 0
            r8.parkedWorkersStack = r0
            r8.controlState = r0
            return
        La5:
            r1.run()     // Catch: java.lang.Throwable -> La9
            goto L7c
        La9:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L7c
        Lb6:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.eo.close():void");
    }

    public final void d(en enVar) {
        long j2;
        int iB;
        if (enVar.c() != j) {
            return;
        }
        do {
            j2 = this.parkedWorkersStack;
            iB = enVar.b();
            enVar.g(this.f.b((int) (2097151 & j2)));
        } while (!g.compareAndSet(this, j2, ((long) iB) | ((2097152 + j2) & (-2097152))));
    }

    public final void e(en enVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object objC = enVar.c();
                    while (true) {
                        if (objC == j) {
                            i4 = -1;
                            break;
                        }
                        if (objC == null) {
                            i4 = 0;
                            break;
                        }
                        en enVar2 = (en) objC;
                        int iB = enVar2.b();
                        if (iB != 0) {
                            i4 = iB;
                            break;
                        }
                        objC = enVar2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (g.compareAndSet(this, j2, j3 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(this, runnable, 6);
    }

    public final boolean f(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f73a;
        if (i2 < i3) {
            int iA = a();
            if (iA == 1 && i3 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean g() {
        fb fbVar;
        int iB;
        while (true) {
            long j2 = this.parkedWorkersStack;
            en enVar = (en) this.f.b((int) (2097151 & j2));
            if (enVar == null) {
                enVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objC = enVar.c();
                while (true) {
                    fbVar = j;
                    if (objC == fbVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    en enVar2 = (en) objC;
                    iB = enVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = enVar2.c();
                }
                if (iB >= 0 && g.compareAndSet(this, j2, ((long) iB) | j3)) {
                    enVar.g(fbVar);
                }
            }
            if (enVar == null) {
                return false;
            }
            if (en.h.compareAndSet(enVar, -1, 0)) {
                LockSupport.unpark(enVar);
                return true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            en enVar = (en) this.f.b(i7);
            if (enVar != null) {
                int iB = enVar.f72a.b();
                int iT = pt.t(enVar.b);
                if (iT == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iB);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iT == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iB);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iT == 2) {
                    i4++;
                } else if (iT == 3) {
                    i5++;
                    if (iB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iB);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iT == 4) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return "DefaultDispatcher@" + pd.d(this) + "[Pool Size {core = " + this.f73a + ", max = " + this.b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.d.c() + ", global blocking queue size = " + this.e.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f73a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
