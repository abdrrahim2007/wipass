package a;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class fj implements ex, Runnable, Comparable, in {
    public boolean aa;
    public int ab;
    public int ac;
    public int ad;
    public final hp d;
    public final Pools.Pool e;
    public la h;
    public nl i;
    public rf j;
    public hw k;
    public int l;
    public int m;
    public gd n;
    public qu o;
    public hu p;
    public int q;
    public Object r;
    public Thread s;
    public nl t;
    public nl u;
    public Object v;
    public ew w;
    public volatile ey x;
    public volatile boolean y;
    public volatile boolean z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fh f83a = new fh();
    public final ArrayList b = new ArrayList();
    public final uh c = new uh();
    public final z f = new z(2);
    public final fi g = new fi();

    public fj(hp hpVar, im imVar) {
        this.d = hpVar;
        this.e = imVar;
    }

    @Override // a.ex
    public final void a(nl nlVar, Object obj, ew ewVar, int i, nl nlVar2) {
        this.t = nlVar;
        this.v = obj;
        this.w = ewVar;
        this.ad = i;
        this.u = nlVar2;
        this.aa = nlVar != this.f83a.a().get(0);
        if (Thread.currentThread() != this.s) {
            k(3);
        } else {
            f();
        }
    }

    @Override // a.ex
    public final void b(nl nlVar, Exception exc, ew ewVar, int i) {
        ewVar.b();
        lc lcVar = new lc("Fetching data failed", Collections.singletonList(exc));
        Class clsA = ewVar.a();
        lcVar.b = nlVar;
        lcVar.c = i;
        lcVar.d = clsA;
        this.b.add(lcVar);
        if (Thread.currentThread() != this.s) {
            k(2);
        } else {
            l();
        }
    }

    @Override // a.in
    public final uh c() {
        return this.c;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        fj fjVar = (fj) obj;
        int iOrdinal = this.j.ordinal() - fjVar.j.ordinal();
        return iOrdinal == 0 ? this.q - fjVar.q : iOrdinal;
    }

    public final sf d(ew ewVar, Object obj, int i) {
        if (obj == null) {
            ewVar.b();
            return null;
        }
        try {
            int i2 = oj.f211a;
            SystemClock.elapsedRealtimeNanos();
            sf sfVarE = e(i, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                sfVarE.toString();
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(this.k);
                Thread.currentThread().getName();
            }
            return sfVarE;
        } finally {
            ewVar.b();
        }
    }

    public final sf e(int i, Object obj) {
        Class<?> cls = obj.getClass();
        fh fhVar = this.f83a;
        oa oaVarC = fhVar.c(cls);
        qu quVar = this.o;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = i == 4 || fhVar.r;
            qt qtVar = gt.i;
            Boolean bool = (Boolean) quVar.c(qtVar);
            if (bool == null || (bool.booleanValue() && !z)) {
                quVar = new qu();
                cg cgVar = this.o.b;
                cg cgVar2 = quVar.b;
                cgVar2.putAll((SimpleArrayMap) cgVar);
                cgVar2.put(qtVar, Boolean.valueOf(z));
            }
        }
        qu quVar2 = quVar;
        fa faVarG = this.h.a().g(obj);
        try {
            return oaVarC.a(this.l, this.m, new bd(this, i), faVarG, quVar2);
        } finally {
            faVarG.b();
        }
    }

    public final void f() {
        sf sfVarD;
        boolean zA;
        if (Log.isLoggable("DecodeJob", 2)) {
            String str = "data: " + this.v + ", cache key: " + this.t + ", fetcher: " + this.w;
            int i = oj.f211a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(this.k);
            if (str != null) {
                ", ".concat(str);
            }
            Thread.currentThread().getName();
        }
        oi oiVar = null;
        try {
            sfVarD = d(this.w, this.v, this.ad);
        } catch (lc e) {
            nl nlVar = this.u;
            int i2 = this.ad;
            e.b = nlVar;
            e.c = i2;
            e.d = null;
            this.b.add(e);
            sfVarD = null;
        }
        if (sfVarD == null) {
            l();
            return;
        }
        int i3 = this.ad;
        boolean z = this.aa;
        if (sfVarD instanceof ma) {
            ((ma) sfVarD).initialize();
        }
        int i4 = 1;
        if (((oi) this.f.d) != null) {
            oiVar = (oi) oi.e.acquire();
            oiVar.d = false;
            oiVar.c = true;
            oiVar.b = sfVarD;
            sfVarD = oiVar;
        }
        n();
        hu huVar = this.p;
        synchronized (huVar) {
            huVar.n = sfVarD;
            huVar.o = i3;
            huVar.v = z;
        }
        synchronized (huVar) {
            try {
                huVar.b.a();
                if (huVar.u) {
                    huVar.n.recycle();
                    huVar.g();
                } else {
                    if (huVar.f126a.f125a.isEmpty()) {
                        throw new IllegalStateException("Received a resource without any callbacks to notify");
                    }
                    if (huVar.p) {
                        throw new IllegalStateException("Already have resource");
                    }
                    ee eeVar = huVar.e;
                    sf sfVar = huVar.n;
                    boolean z2 = huVar.l;
                    hw hwVar = huVar.k;
                    hx hxVar = huVar.c;
                    eeVar.getClass();
                    huVar.s = new hy(sfVar, z2, true, hwVar, hxVar);
                    huVar.p = true;
                    ht htVar = huVar.f126a;
                    htVar.getClass();
                    ArrayList arrayList = new ArrayList(htVar.f125a);
                    huVar.e(arrayList.size() + 1);
                    ((hq) huVar.f).c(huVar, huVar.k, huVar.s);
                    int size = arrayList.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        i5++;
                        hs hsVar = (hs) obj;
                        hsVar.b.execute(new hr(huVar, hsVar.f124a, i4));
                    }
                    huVar.d();
                }
            } finally {
            }
        }
        this.ab = 5;
        try {
            z zVar = this.f;
            if (((oi) zVar.d) != null) {
                hp hpVar = this.d;
                qu quVar = this.o;
                zVar.getClass();
                try {
                    hpVar.a().g((nl) zVar.b, new z((sl) zVar.c, (oi) zVar.d, quVar, i4));
                    ((oi) zVar.d).d();
                } catch (Throwable th) {
                    ((oi) zVar.d).d();
                    throw th;
                }
            }
            fi fiVar = this.g;
            synchronized (fiVar) {
                fiVar.b = true;
                zA = fiVar.a();
            }
            if (zA) {
                j();
            }
        } finally {
            if (oiVar != null) {
                oiVar.d();
            }
        }
    }

    public final ey g() {
        int iT = pt.t(this.ab);
        fh fhVar = this.f83a;
        if (iT == 1) {
            return new sg(fhVar, this);
        }
        if (iT == 2) {
            return new et(fhVar.a(), fhVar, this);
        }
        if (iT == 3) {
            return new uc(fhVar, this);
        }
        if (iT == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(pt.u(this.ab)));
    }

    public final int h(int i) {
        boolean z;
        boolean z2;
        int iT = pt.t(i);
        if (iT == 0) {
            switch (this.n.f94a) {
                case 0:
                case 1:
                    z = false;
                    break;
                case 2:
                default:
                    z = true;
                    break;
            }
            if (z) {
                return 2;
            }
            return h(2);
        }
        if (iT != 1) {
            if (iT == 2) {
                return 4;
            }
            if (iT == 3 || iT == 5) {
                return 6;
            }
            throw new IllegalArgumentException("Unrecognized stage: ".concat(pt.u(i)));
        }
        switch (this.n.f94a) {
            case 0:
            case 2:
                z2 = false;
                break;
            case 1:
            default:
                z2 = true;
                break;
        }
        if (z2) {
            return 3;
        }
        return h(3);
    }

    public final void i() {
        boolean zA;
        n();
        lc lcVar = new lc("Failed to load resource", new ArrayList(this.b));
        hu huVar = this.p;
        synchronized (huVar) {
            huVar.q = lcVar;
        }
        synchronized (huVar) {
            try {
                huVar.b.a();
                if (huVar.u) {
                    huVar.g();
                } else {
                    if (huVar.f126a.f125a.isEmpty()) {
                        throw new IllegalStateException("Received an exception without any callbacks to notify");
                    }
                    if (huVar.r) {
                        throw new IllegalStateException("Already failed once");
                    }
                    huVar.r = true;
                    hw hwVar = huVar.k;
                    ht htVar = huVar.f126a;
                    htVar.getClass();
                    ArrayList arrayList = new ArrayList(htVar.f125a);
                    huVar.e(arrayList.size() + 1);
                    ((hq) huVar.f).c(huVar, hwVar, null);
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        hs hsVar = (hs) obj;
                        hsVar.b.execute(new hr(huVar, hsVar.f124a, 0));
                    }
                    huVar.d();
                }
            } finally {
            }
        }
        fi fiVar = this.g;
        synchronized (fiVar) {
            fiVar.c = true;
            zA = fiVar.a();
        }
        if (zA) {
            j();
        }
    }

    public final void j() {
        fi fiVar = this.g;
        synchronized (fiVar) {
            fiVar.b = false;
            fiVar.f82a = false;
            fiVar.c = false;
        }
        z zVar = this.f;
        zVar.b = null;
        zVar.c = null;
        zVar.d = null;
        fh fhVar = this.f83a;
        fhVar.c = null;
        fhVar.d = null;
        fhVar.n = null;
        fhVar.g = null;
        fhVar.k = null;
        fhVar.i = null;
        fhVar.o = null;
        fhVar.j = null;
        fhVar.p = null;
        fhVar.f81a.clear();
        fhVar.l = false;
        fhVar.b.clear();
        fhVar.m = false;
        this.y = false;
        this.h = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.k = null;
        this.p = null;
        this.ab = 0;
        this.x = null;
        this.s = null;
        this.t = null;
        this.v = null;
        this.ad = 0;
        this.w = null;
        this.z = false;
        this.r = null;
        this.b.clear();
        this.e.release(this);
    }

    public final void k(int i) {
        this.ac = i;
        hu huVar = this.p;
        (huVar.m ? huVar.i : huVar.h).execute(this);
    }

    public final void l() {
        this.s = Thread.currentThread();
        int i = oj.f211a;
        SystemClock.elapsedRealtimeNanos();
        boolean zE = false;
        while (!this.z && this.x != null && !(zE = this.x.e())) {
            this.ab = h(this.ab);
            this.x = g();
            if (this.ab == 4) {
                k(2);
                return;
            }
        }
        if ((this.ab == 6 || this.z) && !zE) {
            i();
        }
    }

    public final void m() {
        int iT = pt.t(this.ac);
        if (iT == 0) {
            this.ab = h(1);
            this.x = g();
            l();
        } else if (iT == 1) {
            l();
        } else if (iT == 2) {
            f();
        } else {
            int i = this.ac;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    public final void n() {
        Throwable th;
        this.c.a();
        if (!this.y) {
            this.y = true;
            return;
        }
        if (this.b.isEmpty()) {
            th = null;
        } else {
            ArrayList arrayList = this.b;
            th = (Throwable) arrayList.get(arrayList.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ew ewVar = this.w;
        try {
            try {
                try {
                    if (this.z) {
                        i();
                        if (ewVar != null) {
                            ewVar.b();
                            return;
                        }
                        return;
                    }
                    m();
                    if (ewVar != null) {
                        ewVar.b();
                    }
                } catch (Throwable th) {
                    Log.isLoggable("DecodeJob", 3);
                    if (this.ab != 5) {
                        this.b.add(th);
                        i();
                    }
                    if (!this.z) {
                        throw th;
                    }
                    throw th;
                }
            } catch (cj e) {
                throw e;
            }
        } catch (Throwable th2) {
            if (ewVar != null) {
                ewVar.b();
            }
            throw th2;
        }
    }
}
