package a;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class oq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f216a = new LinkedHashMap(100, 0.75f, true);
    public final long b;
    public long c;

    public oq(long j) {
        this.b = j;
    }

    public final synchronized Object a(Object obj) {
        op opVar;
        opVar = (op) this.f216a.get(obj);
        return opVar != null ? opVar.f215a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public final synchronized Object d(Object obj, Object obj2) {
        int iB = b(obj2);
        long j = iB;
        if (j >= this.b) {
            c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.c += j;
        }
        op opVar = (op) this.f216a.put(obj, obj2 == null ? null : new op(iB, obj2));
        if (opVar != null) {
            this.c -= (long) opVar.b;
            if (!opVar.f215a.equals(obj2)) {
                c(obj, opVar.f215a);
            }
        }
        e(this.b);
        return opVar != null ? opVar.f215a : null;
    }

    public final synchronized void e(long j) {
        while (this.c > j) {
            Iterator it = this.f216a.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            op opVar = (op) entry.getValue();
            this.c -= (long) opVar.b;
            Object key = entry.getKey();
            it.remove();
            c(key, opVar.f215a);
        }
    }

    public void c(Object obj, Object obj2) {
    }
}
