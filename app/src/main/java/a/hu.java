package a;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class hu implements in {
    public static final ee w = new ee(23);
    public final hx c;
    public final Pools.Pool d;
    public final hv f;
    public final lf g;
    public final lf h;
    public final lf i;
    public hw k;
    public boolean l;
    public boolean m;
    public sf n;
    public int o;
    public boolean p;
    public lc q;
    public boolean r;
    public hy s;
    public fj t;
    public volatile boolean u;
    public boolean v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ht f126a = new ht(new ArrayList(2));
    public final uh b = new uh();
    public final AtomicInteger j = new AtomicInteger();
    public final ee e = w;

    public hu(lf lfVar, lf lfVar2, lf lfVar3, lf lfVar4, hq hqVar, hq hqVar2, im imVar) {
        this.g = lfVar;
        this.h = lfVar2;
        this.i = lfVar4;
        this.f = hqVar;
        this.c = hqVar2;
        this.d = imVar;
    }

    public final synchronized void a(ts tsVar, Executor executor) {
        try {
            this.b.a();
            this.f126a.f125a.add(new hs(tsVar, executor));
            if (this.p) {
                e(1);
                executor.execute(new hr(this, tsVar, 1));
            } else if (this.r) {
                e(1);
                executor.execute(new hr(this, tsVar, 0));
            } else {
                mk.b(!this.u, "Cannot add callbacks to a cancelled EngineJob");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b() {
        if (f()) {
            return;
        }
        this.u = true;
        fj fjVar = this.t;
        fjVar.z = true;
        ey eyVar = fjVar.x;
        if (eyVar != null) {
            eyVar.cancel();
        }
        hv hvVar = this.f;
        hw hwVar = this.k;
        hq hqVar = (hq) hvVar;
        synchronized (hqVar) {
            fc fcVar = hqVar.f122a;
            fcVar.getClass();
            HashMap map = fcVar.f77a;
            if (equals(map.get(hwVar))) {
                map.remove(hwVar);
            }
        }
    }

    @Override // a.in
    public final uh c() {
        return this.b;
    }

    public final void d() {
        hy hyVar;
        synchronized (this) {
            try {
                this.b.a();
                mk.b(f(), "Not yet complete!");
                int iDecrementAndGet = this.j.decrementAndGet();
                mk.b(iDecrementAndGet >= 0, "Can't decrement below 0");
                if (iDecrementAndGet == 0) {
                    hyVar = this.s;
                    g();
                } else {
                    hyVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (hyVar != null) {
            hyVar.d();
        }
    }

    public final synchronized void e(int i) {
        hy hyVar;
        mk.b(f(), "Not yet complete!");
        if (this.j.getAndAdd(i) == 0 && (hyVar = this.s) != null) {
            hyVar.c();
        }
    }

    public final boolean f() {
        return this.r || this.p || this.u;
    }

    public final synchronized void g() {
        boolean zA;
        if (this.k == null) {
            throw new IllegalArgumentException();
        }
        this.f126a.f125a.clear();
        this.k = null;
        this.s = null;
        this.n = null;
        this.r = false;
        this.u = false;
        this.p = false;
        this.v = false;
        fj fjVar = this.t;
        fi fiVar = fjVar.g;
        synchronized (fiVar) {
            fiVar.f82a = true;
            zA = fiVar.a();
        }
        if (zA) {
            fjVar.j();
        }
        this.t = null;
        this.q = null;
        this.o = 0;
        this.d.release(this);
    }

    public final synchronized void h(ts tsVar) {
        try {
            this.b.a();
            this.f126a.f125a.remove(new hs(tsVar, vs.b));
            if (this.f126a.f125a.isEmpty()) {
                b();
                if (this.p || this.r) {
                    if (this.j.get() == 0) {
                        g();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
