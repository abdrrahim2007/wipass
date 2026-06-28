package a;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ry extends bb {
    public boolean aa;
    public boolean ab;
    public final Context q;
    public final sb r;
    public final Class s;
    public final la t;
    public kk u;
    public Object v;
    public ArrayList w;
    public ry x;
    public ry y;
    public final boolean z = true;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ry(com.bumptech.glide.a aVar, sb sbVar, Class cls, Context context) {
        sd sdVar;
        this.r = sbVar;
        this.s = cls;
        this.q = context;
        ArrayMap arrayMap = sbVar.f279a.c.f;
        kk kkVar = (kk) arrayMap.get(cls);
        if (kkVar == null) {
            Iterator it = arrayMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    kkVar = (kk) entry.getValue();
                }
            }
        }
        this.u = kkVar == null ? la.k : kkVar;
        this.t = aVar.c;
        Iterator it2 = sbVar.i.iterator();
        while (it2.hasNext()) {
            if (it2.next() != null) {
                throw new ClassCastException();
            }
            s();
        }
        synchronized (sbVar) {
            sdVar = sbVar.j;
        }
        a(sdVar);
    }

    @Override // a.bb
    public final boolean equals(Object obj) {
        if (!(obj instanceof ry)) {
            return false;
        }
        ry ryVar = (ry) obj;
        return super.equals(ryVar) && Objects.equals(this.s, ryVar.s) && this.u.equals(ryVar.u) && Objects.equals(this.v, ryVar.v) && Objects.equals(this.w, ryVar.w) && Objects.equals(this.x, ryVar.x) && Objects.equals(this.y, ryVar.y) && this.z == ryVar.z && this.aa == ryVar.aa;
    }

    @Override // a.bb
    public final int hashCode() {
        return wh.g(this.aa ? 1 : 0, wh.g(this.z ? 1 : 0, wh.h(wh.h(wh.h(wh.h(wh.h(wh.h(wh.h(super.hashCode(), this.s), this.u), this.v), this.w), this.x), this.y), null)));
    }

    public final ry s() {
        if (this.n) {
            return clone().s();
        }
        k();
        return this;
    }

    @Override // a.bb
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final ry a(bb bbVar) {
        mk.e(bbVar);
        return (ry) super.a(bbVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final rw u(Object obj, uy uyVar, rz rzVar, kk kkVar, rf rfVar, int i, int i2, bb bbVar) {
        rz rzVar2;
        rz hzVar;
        bb bbVar2;
        rw tsVar;
        rf rfVar2;
        if (this.y != null) {
            hzVar = new hz(obj, rzVar);
            rzVar2 = hzVar;
        } else {
            rzVar2 = null;
            hzVar = rzVar;
        }
        ry ryVar = this.x;
        if (ryVar == null) {
            Context context = this.q;
            la laVar = this.t;
            bbVar2 = bbVar;
            tsVar = new ts(context, laVar, obj, this.v, this.s, bbVar2, i, i2, rfVar, uyVar, this.w, hzVar, laVar.g, kkVar.f147a);
        } else {
            if (this.ab) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            kk kkVar2 = ryVar.z ? kkVar : ryVar.u;
            if (bb.f(ryVar.f22a, 8)) {
                rfVar2 = this.x.c;
            } else {
                int iOrdinal = rfVar.ordinal();
                if (iOrdinal == 0 || iOrdinal == 1) {
                    rfVar2 = rf.f264a;
                } else if (iOrdinal == 2) {
                    rfVar2 = rf.b;
                } else {
                    if (iOrdinal != 3) {
                        throw new IllegalArgumentException("unknown priority: " + this.c);
                    }
                    rfVar2 = rf.c;
                }
            }
            rf rfVar3 = rfVar2;
            ry ryVar2 = this.x;
            int i3 = ryVar2.f;
            int i4 = ryVar2.e;
            if (wh.i(i, i2)) {
                ry ryVar3 = this.x;
                if (!wh.i(ryVar3.f, ryVar3.e)) {
                    i3 = bbVar.f;
                    i4 = bbVar.e;
                }
            }
            int i5 = i4;
            vj vjVar = new vj(obj, hzVar);
            Context context2 = this.q;
            vj vjVar2 = vjVar;
            la laVar2 = this.t;
            ts tsVar2 = new ts(context2, laVar2, obj, this.v, this.s, bbVar, i, i2, rfVar, uyVar, this.w, vjVar2, laVar2.g, kkVar.f147a);
            this.ab = true;
            ry ryVar4 = this.x;
            rw rwVarU = ryVar4.u(obj, uyVar, vjVar2, kkVar2, rfVar3, i3, i5, ryVar4);
            this.ab = false;
            vjVar2.c = tsVar2;
            vjVar2.d = rwVarU;
            bbVar2 = bbVar;
            tsVar = vjVar2;
        }
        if (rzVar2 == null) {
            return tsVar;
        }
        ry ryVar5 = this.y;
        int i6 = ryVar5.f;
        int i7 = ryVar5.e;
        if (wh.i(i, i2)) {
            ry ryVar6 = this.y;
            if (!wh.i(ryVar6.f, ryVar6.e)) {
                i6 = bbVar2.f;
                i7 = bbVar2.e;
            }
        }
        int i8 = i7;
        ry ryVar7 = this.y;
        hz hzVar2 = rzVar2;
        rw rwVarU2 = ryVar7.u(obj, uyVar, hzVar2, ryVar7.u, ryVar7.c, i6, i8, ryVar7);
        hzVar2.c = tsVar;
        hzVar2.d = rwVarU2;
        return hzVar2;
    }

    @Override // a.bb
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final ry clone() {
        ry ryVar = (ry) super.clone();
        ryVar.u = ryVar.u.clone();
        if (ryVar.w != null) {
            ryVar.w = new ArrayList(ryVar.w);
        }
        ry ryVar2 = ryVar.x;
        if (ryVar2 != null) {
            ryVar.x = ryVar2.clone();
        }
        ry ryVar3 = ryVar.y;
        if (ryVar3 != null) {
            ryVar.y = ryVar3.clone();
        }
        return ryVar;
    }

    public final void w(uy uyVar, bb bbVar) {
        mk.e(uyVar);
        if (!this.aa) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        rw rwVarU = u(new Object(), uyVar, null, this.u, bbVar.c, bbVar.f, bbVar.e, bbVar);
        rw rwVarG = uyVar.g();
        if (rwVarU.c(rwVarG) && (bbVar.d || !rwVarG.i())) {
            mk.f(rwVarG, "Argument must not be null");
            if (rwVarG.isRunning()) {
                return;
            }
            rwVarG.f();
            return;
        }
        this.r.k(uyVar);
        uyVar.b(rwVarU);
        sb sbVar = this.r;
        synchronized (sbVar) {
            sbVar.f.f321a.add(uyVar);
            tw twVar = sbVar.d;
            ((Set) twVar.c).add(rwVarU);
            if (twVar.b) {
                rwVarU.clear();
                Log.isLoggable("RequestTracker", 2);
                ((HashSet) twVar.d).add(rwVarU);
            } else {
                rwVarU.f();
            }
        }
    }

    public final ry x(Object obj) {
        if (this.n) {
            return clone().x(obj);
        }
        this.v = obj;
        this.aa = true;
        k();
        return this;
    }
}
