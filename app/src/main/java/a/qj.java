package a;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class qj {
    public static final qi e = new qi();
    public static final vy f = new vy(2);
    public final im d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f254a = new ArrayList();
    public final HashSet c = new HashSet();
    public final qi b = e;

    public qj(im imVar) {
        this.d = imVar;
    }

    public final synchronized qa a(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.f254a;
            int size = arrayList2.size();
            boolean z = false;
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                qh qhVar = (qh) obj;
                if (this.c.contains(qhVar)) {
                    z = true;
                } else if (qhVar.f253a.isAssignableFrom(cls) && qhVar.b.isAssignableFrom(cls2)) {
                    this.c.add(qhVar);
                    arrayList.add(qhVar.c.c(this));
                    this.c.remove(qhVar);
                }
            }
            if (arrayList.size() > 1) {
                qi qiVar = this.b;
                im imVar = this.d;
                qiVar.getClass();
                return new qg(arrayList, imVar);
            }
            if (arrayList.size() == 1) {
                return (qa) arrayList.get(0);
            }
            if (z) {
                return f;
            }
            throw new rt("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    public final synchronized ArrayList b(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            ArrayList arrayList2 = this.f254a;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                qh qhVar = (qh) obj;
                if (!this.c.contains(qhVar) && qhVar.f253a.isAssignableFrom(cls)) {
                    this.c.add(qhVar);
                    arrayList.add(qhVar.c.c(this));
                    this.c.remove(qhVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public final synchronized ArrayList c(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = this.f254a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            qh qhVar = (qh) obj;
            if (!arrayList.contains(qhVar.b) && qhVar.f253a.isAssignableFrom(cls)) {
                arrayList.add(qhVar.b);
            }
        }
        return arrayList;
    }
}
