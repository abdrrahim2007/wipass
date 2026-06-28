package a;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ru {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qd f275a;
    public final hk b;
    public final ah c;
    public final hk d;
    public final fc e;
    public final hk f;
    public final hk g;
    public final ah h = new ah(6);
    public final ob i = new ob();
    public final im j;

    public ru() {
        im imVar = new im(new Pools.SynchronizedPool(20), new ij(), new ik());
        this.j = imVar;
        this.f275a = new qd(imVar);
        this.b = new hk(0);
        this.c = new ah(7);
        this.d = new hk(2);
        this.e = new fc(0);
        this.f = new hk(3);
        this.g = new hk(1);
        List listAsList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(listAsList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        ah ahVar = this.c;
        synchronized (ahVar) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) ahVar.b);
                ((ArrayList) ahVar.b).clear();
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((ArrayList) ahVar.b).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i < size2) {
                    Object obj2 = arrayList2.get(i);
                    i++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) ahVar.b).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, hi hiVar) {
        hk hkVar = this.b;
        synchronized (hkVar) {
            hkVar.f116a.add(new hj(cls, hiVar));
        }
    }

    public final void b(Class cls, sl slVar) {
        hk hkVar = this.d;
        synchronized (hkVar) {
            hkVar.f116a.add(new sm(cls, slVar));
        }
    }

    public final void c(Class cls, Class cls2, qb qbVar) {
        qd qdVar = this.f275a;
        synchronized (qdVar) {
            qj qjVar = qdVar.f249a;
            synchronized (qjVar) {
                try {
                    qh qhVar = new qh(cls, cls2, qbVar);
                    ArrayList arrayList = qjVar.f254a;
                    arrayList.add(arrayList.size(), qhVar);
                } catch (Throwable th) {
                    throw th;
                }
            }
            qdVar.b.f77a.clear();
        }
    }

    public final void d(String str, Class cls, Class cls2, si siVar) {
        ah ahVar = this.c;
        synchronized (ahVar) {
            ahVar.e(str).add(new sj(cls, cls2, siVar));
        }
    }

    public final ArrayList e() {
        ArrayList arrayList;
        hk hkVar = this.g;
        synchronized (hkVar) {
            arrayList = hkVar.f116a;
        }
        if (arrayList.isEmpty()) {
            throw new rt("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List f(Object obj) {
        List listUnmodifiableList;
        qd qdVar = this.f275a;
        qdVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (qdVar) {
            qc qcVar = (qc) qdVar.b.f77a.get(cls);
            listUnmodifiableList = qcVar == null ? null : qcVar.f248a;
            if (listUnmodifiableList == null) {
                listUnmodifiableList = Collections.unmodifiableList(qdVar.f249a.b(cls));
                if (((qc) qdVar.b.f77a.put(cls, new qc(listUnmodifiableList))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (listUnmodifiableList.isEmpty()) {
            throw new rt("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = listUnmodifiableList.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z = true;
        for (int i = 0; i < size; i++) {
            qa qaVar = (qa) listUnmodifiableList.get(i);
            if (qaVar.a(obj)) {
                if (z) {
                    arrayList = new ArrayList(size - i);
                    z = false;
                }
                arrayList.add(qaVar);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        throw new rt("Found ModelLoaders for model class: " + listUnmodifiableList + ", but none that handle this specific model instance: " + obj);
    }

    public final fa g(Object obj) {
        fa faVarB;
        fc fcVar = this.e;
        synchronized (fcVar) {
            try {
                mk.e(obj);
                ez ezVar = (ez) fcVar.f77a.get(obj.getClass());
                if (ezVar == null) {
                    Iterator it = fcVar.f77a.values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ez ezVar2 = (ez) it.next();
                        if (ezVar2.a().isAssignableFrom(obj.getClass())) {
                            ezVar = ezVar2;
                            break;
                        }
                    }
                }
                if (ezVar == null) {
                    ezVar = fc.b;
                }
                faVarB = ezVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return faVarB;
    }

    public final void h(ez ezVar) {
        fc fcVar = this.e;
        synchronized (fcVar) {
            fcVar.f77a.put(ezVar.a(), ezVar);
        }
    }

    public final void i(Class cls, Class cls2, sp spVar) {
        hk hkVar = this.f;
        synchronized (hkVar) {
            hkVar.f116a.add(new vn(cls, cls2, spVar));
        }
    }
}
