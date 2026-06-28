package a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ts implements rw, ua {
    public static final boolean z = Log.isLoggable("GlideRequest", 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uh f302a;
    public final Object b;
    public final rz c;
    public final la d;
    public final Object e;
    public final Class f;
    public final bb g;
    public final int h;
    public final int i;
    public final rf j;
    public final uy k;
    public final List l;
    public final kn m;
    public final ig n;
    public sf o;
    public z p;
    public volatile hq q;
    public Drawable r;
    public Drawable s;
    public Drawable t;
    public int u;
    public int v;
    public boolean w;
    public final RuntimeException x;
    public int y;

    public ts(Context context, la laVar, Object obj, Object obj2, Class cls, bb bbVar, int i, int i2, rf rfVar, uy uyVar, ArrayList arrayList, rz rzVar, hq hqVar, kn knVar) {
        ig igVar = vs.f335a;
        if (z) {
            String.valueOf(hashCode());
        }
        this.f302a = new uh();
        this.b = obj;
        this.d = laVar;
        this.e = obj2;
        this.f = cls;
        this.g = bbVar;
        this.h = i;
        this.i = i2;
        this.j = rfVar;
        this.k = uyVar;
        this.l = arrayList;
        this.c = rzVar;
        this.q = hqVar;
        this.m = knVar;
        this.n = igVar;
        this.y = 1;
        if (this.x == null && ((Map) laVar.h.b).containsKey(kz.class)) {
            this.x = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // a.rw
    public final boolean a() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.y == 4;
        }
        return z2;
    }

    @Override // a.rw
    public final boolean b() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.y == 6;
        }
        return z2;
    }

    @Override // a.rw
    public final boolean c(rw rwVar) {
        int i;
        int i2;
        Object obj;
        Class cls;
        bb bbVar;
        rf rfVar;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class cls2;
        bb bbVar2;
        rf rfVar2;
        int size2;
        if (!(rwVar instanceof ts)) {
            return false;
        }
        synchronized (this.b) {
            try {
                i = this.h;
                i2 = this.i;
                obj = this.e;
                cls = this.f;
                bbVar = this.g;
                rfVar = this.j;
                List list = this.l;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        ts tsVar = (ts) rwVar;
        synchronized (tsVar.b) {
            try {
                i3 = tsVar.h;
                i4 = tsVar.i;
                obj2 = tsVar.e;
                cls2 = tsVar.f;
                bbVar2 = tsVar.g;
                rfVar2 = tsVar.j;
                List list2 = tsVar.l;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        if (i == i3 && i2 == i4) {
            char[] cArr = wh.f346a;
            if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
                if ((bbVar == null ? bbVar2 == null : bbVar.e(bbVar2)) && rfVar == rfVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // a.rw
    public final void clear() {
        synchronized (this.b) {
            try {
                if (this.w) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f302a.a();
                if (this.y == 6) {
                    return;
                }
                e();
                sf sfVar = this.o;
                if (sfVar != null) {
                    this.o = null;
                } else {
                    sfVar = null;
                }
                rz rzVar = this.c;
                if (rzVar == null || rzVar.j(this)) {
                    this.k.h(g());
                }
                this.y = 6;
                if (sfVar != null) {
                    this.q.getClass();
                    hq.e(sfVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rw
    public final void d() {
        synchronized (this.b) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        if (this.w) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f302a.a();
        this.k.e(this);
        z zVar = this.p;
        if (zVar != null) {
            synchronized (((hq) zVar.d)) {
                ((hu) zVar.b).h((ts) zVar.c);
            }
            this.p = null;
        }
    }

    @Override // a.rw
    public final void f() {
        synchronized (this.b) {
            try {
                if (this.w) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f302a.a();
                int i = oj.f211a;
                SystemClock.elapsedRealtimeNanos();
                if (this.e == null) {
                    if (wh.i(this.h, this.i)) {
                        this.u = this.h;
                        this.v = this.i;
                    }
                    if (this.t == null) {
                        this.g.getClass();
                        this.t = null;
                    }
                    h(new lc("Received null model"), this.t == null ? 5 : 3);
                    return;
                }
                int i2 = this.y;
                if (i2 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i2 == 4) {
                    j(this.o, 5, false);
                    return;
                }
                List list = this.l;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() != null) {
                            throw new ClassCastException();
                        }
                    }
                }
                this.y = 3;
                if (wh.i(this.h, this.i)) {
                    l(this.h, this.i);
                } else {
                    this.k.a(this);
                }
                int i3 = this.y;
                if (i3 == 2 || i3 == 3) {
                    rz rzVar = this.c;
                    if (rzVar == null || rzVar.h(this)) {
                        this.k.f(g());
                    }
                }
                if (z) {
                    SystemClock.elapsedRealtimeNanos();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Drawable g() {
        if (this.s == null) {
            this.g.getClass();
            this.s = null;
        }
        return this.s;
    }

    public final void h(lc lcVar, int i) {
        Drawable drawableG;
        this.f302a.a();
        synchronized (this.b) {
            try {
                lcVar.getClass();
                int i2 = this.d.i;
                if (i2 <= i) {
                    Objects.toString(this.e);
                    if (i2 <= 4) {
                        ArrayList arrayList = new ArrayList();
                        lc.a(lcVar, arrayList);
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            int i4 = i3 + 1;
                            i3 = i4;
                        }
                    }
                }
                this.p = null;
                this.y = 5;
                rz rzVar = this.c;
                if (rzVar != null) {
                    rzVar.k(this);
                }
                boolean z2 = true;
                this.w = true;
                try {
                    List list = this.l;
                    if (list != null) {
                        Iterator it = list.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            rz rzVar2 = this.c;
                            if (rzVar2 == null) {
                                throw null;
                            }
                            rzVar2.getRoot().a();
                            throw null;
                        }
                    }
                    rz rzVar3 = this.c;
                    if (rzVar3 != null && !rzVar3.h(this)) {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.e == null) {
                            if (this.t == null) {
                                this.g.getClass();
                                this.t = null;
                            }
                            drawableG = this.t;
                        } else {
                            drawableG = null;
                        }
                        if (drawableG == null) {
                            if (this.r == null) {
                                this.g.getClass();
                                this.r = null;
                            }
                            drawableG = this.r;
                        }
                        if (drawableG == null) {
                            drawableG = g();
                        }
                        this.k.c(drawableG);
                    }
                } finally {
                    this.w = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rw
    public final boolean i() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.y == 4;
        }
        return z2;
    }

    @Override // a.rw
    public final boolean isRunning() {
        boolean z2;
        synchronized (this.b) {
            int i = this.y;
            z2 = i == 2 || i == 3;
        }
        return z2;
    }

    public final void j(sf sfVar, int i, boolean z2) {
        this.f302a.a();
        sf sfVar2 = null;
        try {
            synchronized (this.b) {
                try {
                    this.p = null;
                    if (sfVar == null) {
                        h(new lc("Expected to receive a Resource<R> with an object of " + this.f + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = sfVar.get();
                    try {
                        if (obj == null || !this.f.isAssignableFrom(obj.getClass())) {
                            this.o = null;
                            StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                            sb.append(this.f);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(sfVar);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            h(new lc(sb.toString()), 5);
                        } else {
                            rz rzVar = this.c;
                            if (rzVar == null || rzVar.g(this)) {
                                k(sfVar, obj, i);
                                return;
                            } else {
                                this.o = null;
                                this.y = 4;
                            }
                        }
                        this.q.getClass();
                        hq.e(sfVar);
                    } catch (Throwable th) {
                        sfVar2 = sfVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (sfVar2 != null) {
                this.q.getClass();
                hq.e(sfVar2);
            }
            throw th3;
        }
    }

    public final void k(sf sfVar, Object obj, int i) {
        rz rzVar = this.c;
        if (rzVar != null) {
            rzVar.getRoot().a();
        }
        this.y = 4;
        this.o = sfVar;
        if (this.d.i <= 3) {
            Objects.toString(this.e);
            int i2 = oj.f211a;
            SystemClock.elapsedRealtimeNanos();
        }
        if (rzVar != null) {
            rzVar.e(this);
        }
        this.w = true;
        try {
            List list = this.l;
            if (list != null) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
            this.m.getClass();
            this.k.i(obj);
            this.w = false;
        } catch (Throwable th) {
            this.w = false;
            throw th;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void l(int i, int i2) throws Throwable {
        Object obj;
        la laVar;
        Object obj2;
        nl nlVar;
        int i3;
        int i4;
        Class cls;
        Class cls2;
        rf rfVar;
        gd gdVar;
        cg cgVar;
        boolean z2;
        boolean z3;
        qu quVar;
        boolean z4;
        boolean z5;
        ig igVar;
        Object obj3;
        ts tsVar = this;
        int iRound = i;
        tsVar.f302a.a();
        Object obj4 = tsVar.b;
        synchronized (obj4) {
            try {
                try {
                    boolean z6 = z;
                    if (z6) {
                        int i5 = oj.f211a;
                        SystemClock.elapsedRealtimeNanos();
                    }
                    if (tsVar.y == 3) {
                        tsVar.y = 2;
                        tsVar.g.getClass();
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * 1.0f);
                        }
                        tsVar.u = iRound;
                        tsVar.v = i2 == Integer.MIN_VALUE ? i2 : Math.round(1.0f * i2);
                        if (z6) {
                            int i6 = oj.f211a;
                            SystemClock.elapsedRealtimeNanos();
                        }
                        hq hqVar = tsVar.q;
                        try {
                            laVar = tsVar.d;
                            obj2 = tsVar.e;
                            bb bbVar = tsVar.g;
                            try {
                                nlVar = bbVar.g;
                                i3 = tsVar.u;
                                try {
                                    i4 = tsVar.v;
                                    cls = bbVar.k;
                                    try {
                                        cls2 = tsVar.f;
                                        rfVar = tsVar.j;
                                        try {
                                            gdVar = bbVar.b;
                                            cgVar = bbVar.j;
                                            try {
                                                z2 = bbVar.h;
                                                z3 = bbVar.o;
                                                try {
                                                    quVar = bbVar.i;
                                                    z4 = bbVar.d;
                                                    z5 = bbVar.p;
                                                    igVar = tsVar.n;
                                                    obj3 = obj4;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    obj = obj4;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                obj = obj4;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj = obj4;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj = obj4;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    obj = obj4;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                obj = obj4;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            obj = obj4;
                        }
                        try {
                            tsVar.p = hqVar.a(laVar, obj2, nlVar, i3, i4, cls, cls2, rfVar, gdVar, cgVar, z2, z3, quVar, z4, z5, tsVar, igVar);
                            if (tsVar.y != 2) {
                                tsVar.p = null;
                            }
                            if (z6) {
                                int i7 = oj.f211a;
                                SystemClock.elapsedRealtimeNanos();
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            obj = obj3;
                            throw th;
                        }
                    }
                } catch (Throwable th9) {
                    th = th9;
                    obj = obj4;
                }
            } catch (Throwable th10) {
                th = th10;
                obj = tsVar;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.b) {
            obj = this.e;
            cls = this.f;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
