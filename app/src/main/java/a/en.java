package a;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class en extends Thread {
    public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(en.class, "workerCtl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xf f72a;
    public int b;
    public long c;
    public long d;
    public int e;
    public boolean f;
    public final /* synthetic */ eo g;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    volatile /* synthetic */ int workerCtl;

    public en(eo eoVar, int i) {
        this.g = eoVar;
        setDaemon(true);
        this.f72a = new xf();
        this.b = 4;
        this.workerCtl = 0;
        this.nextParkedWorker = eo.j;
        this.e = rm.b.a();
        f(i);
    }

    public final va a(boolean z) {
        va vaVarE;
        va vaVarE2;
        long j;
        va vaVarC;
        if (this.b != 1) {
            eo eoVar = this.g;
            do {
                j = eoVar.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    if (z) {
                        xf xfVar = this.f72a;
                        xfVar.getClass();
                        vaVarC = (va) xf.b.getAndSet(xfVar, null);
                        if (vaVarC == null) {
                            vaVarC = xfVar.c();
                        }
                        if (vaVarC == null) {
                            vaVarC = (va) this.g.e.d();
                        }
                    } else {
                        vaVarC = (va) this.g.e.d();
                    }
                    return vaVarC == null ? i(true) : vaVarC;
                }
            } while (!eo.h.compareAndSet(eoVar, j, j - 4398046511104L));
            this.b = 1;
        }
        if (z) {
            boolean z2 = d(this.g.f73a * 2) == 0;
            if (z2 && (vaVarE2 = e()) != null) {
                return vaVarE2;
            }
            xf xfVar2 = this.f72a;
            xfVar2.getClass();
            va vaVarC2 = (va) xf.b.getAndSet(xfVar2, null);
            if (vaVarC2 == null) {
                vaVarC2 = xfVar2.c();
            }
            if (vaVarC2 != null) {
                return vaVarC2;
            }
            if (!z2 && (vaVarE = e()) != null) {
                return vaVarE;
            }
        } else {
            va vaVarE3 = e();
            if (vaVarE3 != null) {
                return vaVarE3;
            }
        }
        return i(false);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.e;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.e = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
    }

    public final va e() {
        int iD = d(2);
        eo eoVar = this.g;
        if (iD == 0) {
            va vaVar = (va) eoVar.d.d();
            return vaVar != null ? vaVar : (va) eoVar.e.d();
        }
        va vaVar2 = (va) eoVar.e.d();
        return vaVar2 != null ? vaVar2 : (va) eoVar.d.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder("DefaultDispatcher-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i) {
        int i2 = this.b;
        boolean z = i2 == 1;
        if (z) {
            eo.h.addAndGet(this.g, 4398046511104L);
        }
        if (i2 != i) {
            this.b = i;
        }
        return z;
    }

    public final va i(boolean z) {
        long jE;
        int i = (int) (this.g.controlState & 2097151);
        if (i < 2) {
            return null;
        }
        int iD = d(i);
        eo eoVar = this.g;
        long jMin = LocationRequestCompat.PASSIVE_INTERVAL;
        for (int i2 = 0; i2 < i; i2++) {
            iD++;
            if (iD > i) {
                iD = 1;
            }
            en enVar = (en) eoVar.f.b(iD);
            if (enVar != null && enVar != this) {
                if (z) {
                    jE = this.f72a.d(enVar.f72a);
                } else {
                    xf xfVar = this.f72a;
                    xf xfVar2 = enVar.f72a;
                    xfVar.getClass();
                    va vaVarC = xfVar2.c();
                    if (vaVarC != null) {
                        va vaVar = (va) xf.b.getAndSet(xfVar, vaVarC);
                        if (vaVar != null) {
                            xfVar.a(vaVar);
                        }
                        jE = -1;
                    } else {
                        jE = xfVar.e(xfVar2, false);
                    }
                }
                if (jE == -1) {
                    xf xfVar3 = this.f72a;
                    xfVar3.getClass();
                    va vaVar2 = (va) xf.b.getAndSet(xfVar3, null);
                    return vaVar2 == null ? xfVar3.c() : vaVar2;
                }
                if (jE > 0) {
                    jMin = Math.min(jMin, jE);
                }
            }
        }
        if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
            jMin = 0;
        }
        this.d = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        loop0: while (true) {
            boolean z = false;
            while (!this.g.isTerminated() && this.b != 5) {
                va vaVarA = a(this.f);
                if (vaVarA != null) {
                    this.d = 0L;
                    eo eoVar = this.g;
                    int i = vaVarA.b.f324a;
                    this.c = 0L;
                    if (this.b == 3) {
                        this.b = 2;
                    }
                    if (i != 0 && h(2) && !eoVar.g() && !eoVar.f(eoVar.controlState)) {
                        eoVar.g();
                    }
                    try {
                        vaVarA.run();
                    } catch (Throwable th) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                    }
                    if (i != 0) {
                        eo.h.addAndGet(eoVar, -2097152L);
                        if (this.b != 5) {
                            this.b = 4;
                        }
                    }
                } else {
                    this.f = false;
                    if (this.d != 0) {
                        if (z) {
                            h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.d);
                            this.d = 0L;
                        } else {
                            z = true;
                        }
                    } else if (this.nextParkedWorker != eo.j) {
                        this.workerCtl = -1;
                        while (this.nextParkedWorker != eo.j && this.workerCtl == -1 && !this.g.isTerminated() && this.b != 5) {
                            h(3);
                            Thread.interrupted();
                            if (this.c == 0) {
                                this.c = System.nanoTime() + this.g.c;
                            }
                            LockSupport.parkNanos(this.g.c);
                            if (System.nanoTime() - this.c >= 0) {
                                this.c = 0L;
                                eo eoVar2 = this.g;
                                synchronized (eoVar2.f) {
                                    try {
                                        if (!eoVar2.isTerminated()) {
                                            if (((int) (eoVar2.controlState & 2097151)) > eoVar2.f73a) {
                                                if (h.compareAndSet(this, -1, 1)) {
                                                    int i2 = this.indexInArray;
                                                    f(0);
                                                    eoVar2.e(this, i2, 0);
                                                    int andDecrement = (int) (eo.h.getAndDecrement(eoVar2) & 2097151);
                                                    if (andDecrement != i2) {
                                                        Object objB = eoVar2.f.b(andDecrement);
                                                        mk.c(objB);
                                                        en enVar = (en) objB;
                                                        eoVar2.f.c(i2, enVar);
                                                        enVar.f(i2);
                                                        eoVar2.e(enVar, andDecrement, i2);
                                                    }
                                                    eoVar2.f.c(andDecrement, null);
                                                    this.b = 5;
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        this.g.d(this);
                    }
                }
            }
            break loop0;
        }
        h(5);
    }
}
