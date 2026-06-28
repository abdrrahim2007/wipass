package a;

import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class hq implements hv, hx {
    public static final boolean h = Log.isLoggable("Engine", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fc f122a;
    public final ee b;
    public final or c;
    public final ho d;
    public final so e;
    public final hm f;
    public final z g;

    public hq(or orVar, fb fbVar, lf lfVar, lf lfVar2, lf lfVar3, lf lfVar4) throws Throwable {
        this.c = orVar;
        hp hpVar = new hp(fbVar);
        z zVar = new z(0);
        this.g = zVar;
        synchronized (this) {
            try {
                try {
                    synchronized (zVar) {
                        try {
                            zVar.d = this;
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    }
                    this.b = new ee(24);
                    this.f122a = new fc(2);
                    this.d = new ho(lfVar, lfVar2, lfVar3, lfVar4, this, this);
                    this.f = new hm(hpVar);
                    this.e = new so();
                    orVar.d = this;
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    public static void e(sf sfVar) {
        if (!(sfVar instanceof hy)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((hy) sfVar).d();
    }

    public final z a(la laVar, Object obj, nl nlVar, int i, int i2, Class cls, Class cls2, rf rfVar, gd gdVar, cg cgVar, boolean z, boolean z2, qu quVar, boolean z3, boolean z4, ts tsVar, ig igVar) {
        long jElapsedRealtimeNanos;
        if (h) {
            int i3 = oj.f211a;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        this.b.getClass();
        hw hwVar = new hw(obj, nlVar, i, i2, cgVar, cls, cls2, quVar);
        synchronized (this) {
            try {
                hy hyVarB = b(hwVar, z3, jElapsedRealtimeNanos);
                if (hyVarB == null) {
                    return f(laVar, obj, nlVar, i, i2, cls, cls2, rfVar, gdVar, cgVar, z, z2, quVar, z3, z4, tsVar, igVar, hwVar, jElapsedRealtimeNanos);
                }
                tsVar.j(hyVarB, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    public final hy b(hw hwVar, boolean z, long j) throws Throwable {
        Throwable th;
        hy hyVar;
        Object obj;
        hq hqVar;
        hw hwVar2;
        hy hyVar2;
        if (z) {
            z zVar = this.g;
            synchronized (zVar) {
                try {
                    y yVar = (y) ((HashMap) zVar.b).get(hwVar);
                    if (yVar == null) {
                        hyVar = null;
                    } else {
                        hyVar = (hy) yVar.get();
                        if (hyVar == null) {
                            try {
                                zVar.c(yVar);
                            } catch (Throwable th2) {
                                th = th2;
                                while (true) {
                                    try {
                                        throw th;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    th = th3;
                                }
                            }
                        }
                    }
                    if (hyVar != null) {
                        hyVar.c();
                    }
                    if (hyVar != null) {
                        if (h) {
                            int i = oj.f211a;
                            SystemClock.elapsedRealtimeNanos();
                            Objects.toString(hwVar);
                        }
                        return hyVar;
                    }
                    or orVar = this.c;
                    synchronized (orVar) {
                        try {
                            op opVar = (op) orVar.f216a.remove(hwVar);
                            if (opVar == null) {
                                obj = null;
                            } else {
                                orVar.c -= (long) opVar.b;
                                obj = opVar.f215a;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        }
                    }
                    sf sfVar = (sf) obj;
                    if (sfVar == null) {
                        hqVar = this;
                        hwVar2 = hwVar;
                        hyVar2 = null;
                    } else if (sfVar instanceof hy) {
                        hyVar2 = (hy) sfVar;
                        hqVar = this;
                        hwVar2 = hwVar;
                    } else {
                        hqVar = this;
                        hwVar2 = hwVar;
                        hyVar2 = new hy(sfVar, true, true, hwVar2, hqVar);
                    }
                    if (hyVar2 != null) {
                        hyVar2.c();
                        hqVar.g.a(hwVar2, hyVar2);
                    }
                    if (hyVar2 != null) {
                        if (h) {
                            int i2 = oj.f211a;
                            SystemClock.elapsedRealtimeNanos();
                            Objects.toString(hwVar2);
                        }
                        return hyVar2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        }
        return null;
    }

    public final synchronized void c(hu huVar, nl nlVar, hy hyVar) {
        if (hyVar != null) {
            try {
                if (hyVar.f127a) {
                    this.g.a(nlVar, hyVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        fc fcVar = this.f122a;
        fcVar.getClass();
        huVar.getClass();
        HashMap map = fcVar.f77a;
        if (huVar.equals(map.get(nlVar))) {
            map.remove(nlVar);
        }
    }

    public final void d(nl nlVar, hy hyVar) {
        z zVar = this.g;
        synchronized (zVar) {
            y yVar = (y) ((HashMap) zVar.b).remove(nlVar);
            if (yVar != null) {
                yVar.c = null;
                yVar.clear();
            }
        }
        if (hyVar.f127a) {
        } else {
            this.e.a(hyVar, false);
        }
    }

    public final z f(la laVar, Object obj, nl nlVar, int i, int i2, Class cls, Class cls2, rf rfVar, gd gdVar, Map map, boolean z, boolean z2, qu quVar, boolean z3, boolean z4, ts tsVar, Executor executor, hw hwVar, long j) {
        hu huVar = (hu) this.f122a.f77a.get(hwVar);
        if (huVar != null) {
            huVar.a(tsVar, executor);
            if (h) {
                int i3 = oj.f211a;
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(hwVar);
            }
            return new z(this, tsVar, huVar);
        }
        hu huVar2 = (hu) this.d.g.acquire();
        synchronized (huVar2) {
            huVar2.k = hwVar;
            huVar2.l = z3;
            huVar2.m = z4;
        }
        hm hmVar = this.f;
        fj fjVar = (fj) hmVar.b.acquire();
        int i4 = hmVar.c;
        hmVar.c = i4 + 1;
        fh fhVar = fjVar.f83a;
        hp hpVar = fjVar.d;
        fhVar.c = laVar;
        fhVar.d = obj;
        fhVar.n = nlVar;
        fhVar.e = i;
        fhVar.f = i2;
        fhVar.p = gdVar;
        fhVar.g = cls;
        fhVar.h = hpVar;
        fhVar.k = cls2;
        fhVar.o = rfVar;
        fhVar.i = quVar;
        fhVar.j = map;
        fhVar.q = z;
        fhVar.r = z2;
        fjVar.h = laVar;
        fjVar.i = nlVar;
        fjVar.j = rfVar;
        fjVar.k = hwVar;
        fjVar.l = i;
        fjVar.m = i2;
        fjVar.n = gdVar;
        fjVar.o = quVar;
        fjVar.p = huVar2;
        fjVar.q = i4;
        fjVar.ac = 1;
        fjVar.r = obj;
        fc fcVar = this.f122a;
        fcVar.getClass();
        fcVar.f77a.put(hwVar, huVar2);
        huVar2.a(tsVar, executor);
        synchronized (huVar2) {
            huVar2.t = fjVar;
            int iH = fjVar.h(1);
            ((iH == 2 || iH == 3) ? huVar2.g : huVar2.m ? huVar2.i : huVar2.h).execute(fjVar);
        }
        if (h) {
            int i5 = oj.f211a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(hwVar);
        }
        return new z(this, tsVar, huVar2);
    }
}
