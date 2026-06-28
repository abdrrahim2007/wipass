package a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.collection.SimpleArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class bb implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22a;
    public boolean h;
    public boolean l;
    public Resources.Theme m;
    public boolean n;
    public boolean p;
    public gd b = gd.e;
    public rf c = rf.c;
    public boolean d = true;
    public int e = -1;
    public int f = -1;
    public nl g = hh.b;
    public qu i = new qu();
    public cg j = new cg();
    public Class k = Object.class;
    public boolean o = true;

    public static boolean f(int i, int i2) {
        return (i & i2) != 0;
    }

    public bb a(bb bbVar) {
        if (this.n) {
            return clone().a(bbVar);
        }
        int i = bbVar.f22a;
        if (f(bbVar.f22a, 1048576)) {
            this.p = bbVar.p;
        }
        if (f(bbVar.f22a, 4)) {
            this.b = bbVar.b;
        }
        if (f(bbVar.f22a, 8)) {
            this.c = bbVar.c;
        }
        if (f(bbVar.f22a, 16)) {
            this.f22a &= -33;
        }
        if (f(bbVar.f22a, 32)) {
            this.f22a &= -17;
        }
        if (f(bbVar.f22a, 64)) {
            this.f22a &= -129;
        }
        if (f(bbVar.f22a, 128)) {
            this.f22a &= -65;
        }
        if (f(bbVar.f22a, 256)) {
            this.d = bbVar.d;
        }
        if (f(bbVar.f22a, 512)) {
            this.f = bbVar.f;
            this.e = bbVar.e;
        }
        if (f(bbVar.f22a, 1024)) {
            this.g = bbVar.g;
        }
        if (f(bbVar.f22a, 4096)) {
            this.k = bbVar.k;
        }
        if (f(bbVar.f22a, 8192)) {
            this.f22a &= -16385;
        }
        if (f(bbVar.f22a, 16384)) {
            this.f22a &= -8193;
        }
        if (f(bbVar.f22a, 32768)) {
            this.m = bbVar.m;
        }
        if (f(bbVar.f22a, 131072)) {
            this.h = bbVar.h;
        }
        if (f(bbVar.f22a, 2048)) {
            this.j.putAll((Map) bbVar.j);
            this.o = bbVar.o;
        }
        this.f22a |= bbVar.f22a;
        this.i.b.putAll((SimpleArrayMap) bbVar.i.b);
        k();
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public bb clone() {
        try {
            bb bbVar = (bb) super.clone();
            qu quVar = new qu();
            bbVar.i = quVar;
            quVar.b.putAll((SimpleArrayMap) this.i.b);
            cg cgVar = new cg();
            bbVar.j = cgVar;
            cgVar.putAll((Map) this.j);
            bbVar.l = false;
            bbVar.n = false;
            return bbVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final bb c(Class cls) {
        if (this.n) {
            return clone().c(cls);
        }
        this.k = cls;
        this.f22a |= 4096;
        k();
        return this;
    }

    public final bb d(gd gdVar) {
        if (this.n) {
            return clone().d(gdVar);
        }
        this.b = gdVar;
        this.f22a |= 4;
        k();
        return this;
    }

    public final boolean e(bb bbVar) {
        bbVar.getClass();
        if (Float.compare(1.0f, 1.0f) != 0) {
            return false;
        }
        char[] cArr = wh.f346a;
        return this.d == bbVar.d && this.e == bbVar.e && this.f == bbVar.f && this.h == bbVar.h && this.b.equals(bbVar.b) && this.c == bbVar.c && this.i.equals(bbVar.i) && this.j.equals(bbVar.j) && this.k.equals(bbVar.k) && this.g.equals(bbVar.g) && wh.b(this.m, bbVar.m);
    }

    public boolean equals(Object obj) {
        if (obj instanceof bb) {
            return e((bb) obj);
        }
        return false;
    }

    public final bb g(gr grVar, bl blVar) {
        if (this.n) {
            return clone().g(grVar, blVar);
        }
        l(gr.g, grVar);
        return p(blVar, false);
    }

    public final bb h(int i, int i2) {
        if (this.n) {
            return clone().h(i, i2);
        }
        this.f = i;
        this.e = i2;
        this.f22a |= 512;
        k();
        return this;
    }

    public int hashCode() {
        char[] cArr = wh.f346a;
        return wh.h(wh.h(wh.h(wh.h(wh.h(wh.h(wh.h(wh.g(0, wh.g(0, wh.g(1, wh.g(this.h ? 1 : 0, wh.g(this.f, wh.g(this.e, wh.g(this.d ? 1 : 0, wh.h(wh.g(0, wh.h(wh.g(0, wh.h(wh.g(0, wh.g(Float.floatToIntBits(1.0f), 17)), null)), null)), null)))))))), this.b), this.c), this.i), this.j), this.k), this.g), this.m);
    }

    public final bb i() {
        if (this.n) {
            return clone().i();
        }
        this.c = rf.d;
        this.f22a |= 8;
        k();
        return this;
    }

    public final bb j(qt qtVar) {
        if (this.n) {
            return clone().j(qtVar);
        }
        this.i.b.remove(qtVar);
        k();
        return this;
    }

    public final void k() {
        if (this.l) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
    }

    public final bb l(qt qtVar, Object obj) {
        if (this.n) {
            return clone().l(qtVar, obj);
        }
        mk.e(qtVar);
        mk.e(obj);
        this.i.b.put(qtVar, obj);
        k();
        return this;
    }

    public final bb m(nl nlVar) {
        if (this.n) {
            return clone().m(nlVar);
        }
        this.g = nlVar;
        this.f22a |= 1024;
        k();
        return this;
    }

    public final bb n() {
        if (this.n) {
            return clone().n();
        }
        this.d = false;
        this.f22a |= 256;
        k();
        return this;
    }

    public final bb o(Resources.Theme theme) {
        if (this.n) {
            return clone().o(theme);
        }
        this.m = theme;
        if (theme != null) {
            this.f22a |= 32768;
            return l(sk.b, theme);
        }
        this.f22a &= -32769;
        return j(sk.b);
    }

    public final bb p(vo voVar, boolean z) {
        if (this.n) {
            return clone().p(voVar, z);
        }
        gx gxVar = new gx(voVar, z);
        q(Bitmap.class, voVar, z);
        q(Drawable.class, gxVar, z);
        q(BitmapDrawable.class, gxVar, z);
        q(km.class, new kp(voVar), z);
        k();
        return this;
    }

    public final bb q(Class cls, vo voVar, boolean z) {
        if (this.n) {
            return clone().q(cls, voVar, z);
        }
        mk.e(voVar);
        this.j.put(cls, voVar);
        int i = this.f22a;
        this.f22a = 67584 | i;
        this.o = false;
        if (z) {
            this.f22a = i | 198656;
            this.h = true;
        }
        k();
        return this;
    }

    public final bb r() {
        if (this.n) {
            return clone().r();
        }
        this.p = true;
        this.f22a |= 1048576;
        k();
        return this;
    }
}
