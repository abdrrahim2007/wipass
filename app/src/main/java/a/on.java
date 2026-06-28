package a;

import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class on {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ah f213a = new ah(4);
    public final om b = new om(0);
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final int e;
    public int f;

    public on(int i) {
        this.e = i;
    }

    public final void a(Class cls, int i) {
        NavigableMap navigableMapF = f(cls);
        Integer num = (Integer) navigableMapF.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapF.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapF.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    public final void b(int i) {
        while (this.f > i) {
            Object objJ = this.f213a.j();
            mk.e(objJ);
            bt btVarD = d(objJ.getClass());
            this.f -= btVarD.b() * btVarD.a(objJ);
            a(objJ.getClass(), btVarD.a(objJ));
            if (Log.isLoggable(btVarD.c(), 2)) {
                btVarD.a(objJ);
            }
        }
    }

    public final synchronized Object c(Class cls, int i) {
        ol olVar;
        int i2;
        try {
            Integer num = (Integer) f(cls).ceilingKey(Integer.valueOf(i));
            if (num == null || ((i2 = this.f) != 0 && this.e / i2 < 2 && num.intValue() > i * 8)) {
                om omVar = this.b;
                rc rcVarB = (rc) ((ArrayDeque) omVar.f21a).poll();
                if (rcVarB == null) {
                    rcVarB = omVar.b();
                }
                olVar = (ol) rcVarB;
                olVar.b = i;
                olVar.c = cls;
            } else {
                om omVar2 = this.b;
                int iIntValue = num.intValue();
                rc rcVarB2 = (rc) ((ArrayDeque) omVar2.f21a).poll();
                if (rcVarB2 == null) {
                    rcVarB2 = omVar2.b();
                }
                olVar = (ol) rcVarB2;
                olVar.b = iIntValue;
                olVar.c = cls;
            }
        } catch (Throwable th) {
            throw th;
        }
        return e(olVar, cls);
    }

    public final bt d(Class cls) {
        bt btVar;
        HashMap map = this.d;
        bt btVar2 = (bt) map.get(cls);
        if (btVar2 != null) {
            return btVar2;
        }
        if (cls.equals(int[].class)) {
            btVar = new bt(1);
        } else {
            if (!cls.equals(byte[].class)) {
                throw new IllegalArgumentException("No array pool found for: ".concat(cls.getSimpleName()));
            }
            btVar = new bt(0);
        }
        map.put(cls, btVar);
        return btVar;
    }

    public final Object e(ol olVar, Class cls) {
        bt btVarD = d(cls);
        Object objB = this.f213a.b(olVar);
        if (objB != null) {
            this.f -= btVarD.b() * btVarD.a(objB);
            a(cls, btVarD.a(objB));
        }
        if (objB != null) {
            return objB;
        }
        Log.isLoggable(btVarD.c(), 2);
        int i = olVar.b;
        switch (btVarD.f33a) {
            case 0:
                return new byte[i];
            default:
                return new int[i];
        }
    }

    public final NavigableMap f(Class cls) {
        HashMap map = this.c;
        NavigableMap navigableMap = (NavigableMap) map.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(cls, treeMap);
        return treeMap;
    }

    public final synchronized void g(Object obj) {
        Class<?> cls = obj.getClass();
        bt btVarD = d(cls);
        int iA = btVarD.a(obj);
        int iB = btVarD.b() * iA;
        if (iB <= this.e / 2) {
            om omVar = this.b;
            rc rcVarB = (rc) ((ArrayDeque) omVar.f21a).poll();
            if (rcVarB == null) {
                rcVarB = omVar.b();
            }
            ol olVar = (ol) rcVarB;
            olVar.b = iA;
            olVar.c = cls;
            this.f213a.g(olVar, obj);
            NavigableMap navigableMapF = f(cls);
            Integer num = (Integer) navigableMapF.get(Integer.valueOf(olVar.b));
            Integer numValueOf = Integer.valueOf(olVar.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapF.put(numValueOf, Integer.valueOf(iIntValue));
            this.f += iB;
            b(this.e);
        }
    }
}
