package a;

import androidx.collection.ArrayMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class sg implements ey, ev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fj f280a;
    public final fh b;
    public int c;
    public int d = -1;
    public nl e;
    public List f;
    public int g;
    public volatile pz h;
    public File i;
    public sh j;

    public sg(fh fhVar, fj fjVar) {
        this.b = fhVar;
        this.f280a = fjVar;
    }

    @Override // a.ev
    public final void c(Exception exc) {
        this.f280a.b(this.j, exc, this.h.c, 4);
    }

    @Override // a.ey
    public final void cancel() {
        pz pzVar = this.h;
        if (pzVar != null) {
            pzVar.c.cancel();
        }
    }

    @Override // a.ev
    public final void d(Object obj) {
        this.f280a.a(this.e, obj, this.h.c, 4, this.j);
    }

    @Override // a.ey
    public final boolean e() {
        List list;
        boolean z;
        List list2;
        boolean z2;
        ArrayList arrayListC;
        ArrayList arrayListA = this.b.a();
        if (arrayListA.isEmpty()) {
            return false;
        }
        fh fhVar = this.b;
        ru ruVarA = fhVar.c.a();
        Class<?> cls = fhVar.d.getClass();
        Class cls2 = fhVar.g;
        Class cls3 = fhVar.k;
        ah ahVar = ruVarA.h;
        qe qeVar = (qe) ((AtomicReference) ahVar.b).getAndSet(null);
        if (qeVar == null) {
            qeVar = new qe(cls, cls2, cls3);
        } else {
            qeVar.f250a = cls;
            qeVar.b = cls2;
            qeVar.c = cls3;
        }
        synchronized (((ArrayMap) ahVar.c)) {
            list = (List) ((ArrayMap) ahVar.c).get(qeVar);
        }
        ((AtomicReference) ahVar.b).set(qeVar);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            qd qdVar = ruVarA.f275a;
            synchronized (qdVar) {
                arrayListC = qdVar.f249a.c(cls);
            }
            int size = arrayListC.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListC.get(i);
                i++;
                ArrayList arrayListF = ruVarA.c.f((Class) obj, cls2);
                int size2 = arrayListF.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayListF.get(i2);
                    i2++;
                    Class cls4 = (Class) obj2;
                    if (!ruVarA.f.b(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z = false;
            ah ahVar2 = ruVarA.h;
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (((ArrayMap) ahVar2.c)) {
                ((ArrayMap) ahVar2.c).put(new qe(cls, cls2, cls3), listUnmodifiableList);
            }
            list2 = arrayList;
        } else {
            z = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.b.k)) {
                return z;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.b.d.getClass() + " to " + this.b.k);
        }
        while (true) {
            List list3 = this.f;
            if (list3 != null && this.g < list3.size()) {
                this.h = null;
                boolean z3 = z;
                while (!z3 && this.g < this.f.size()) {
                    List list4 = this.f;
                    int i3 = this.g;
                    this.g = i3 + 1;
                    qa qaVar = (qa) list4.get(i3);
                    File file = this.i;
                    fh fhVar2 = this.b;
                    this.h = qaVar.b(file, fhVar2.e, fhVar2.f, fhVar2.i);
                    if (this.h != null && this.b.c(this.h.c.a()) != null) {
                        this.h.c.f(this.b.o, this);
                        z3 = true;
                    }
                }
                return z3;
            }
            int i4 = this.d + 1;
            this.d = i4;
            if (i4 >= list2.size()) {
                int i5 = this.c + 1;
                this.c = i5;
                if (i5 >= arrayListA.size()) {
                    return z;
                }
                this.d = z ? 1 : 0;
            }
            nl nlVar = (nl) arrayListA.get(this.c);
            Class cls5 = (Class) list2.get(this.d);
            vo voVarE = this.b.e(cls5);
            fh fhVar3 = this.b;
            this.j = new sh(fhVar3.c.f161a, nlVar, fhVar3.n, fhVar3.e, fhVar3.f, voVarE, cls5, fhVar3.i);
            File fileE = fhVar3.h.a().e(this.j);
            this.i = fileE;
            if (fileE != null) {
                this.e = nlVar;
                this.f = this.b.c.a().f(fileE);
                z2 = false;
                this.g = 0;
            } else {
                z2 = false;
            }
            z = z2;
        }
    }
}
