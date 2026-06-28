package a;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class qf implements ew, ev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f251a;
    public final Pools.Pool b;
    public int c;
    public rf d;
    public ev e;
    public List f;
    public boolean g;

    public qf(ArrayList arrayList, Pools.Pool pool) {
        this.b = pool;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f251a = arrayList;
        this.c = 0;
    }

    @Override // a.ew
    public final Class a() {
        return ((ew) this.f251a.get(0)).a();
    }

    @Override // a.ew
    public final void b() {
        List list = this.f;
        if (list != null) {
            this.b.release(list);
        }
        this.f = null;
        ArrayList arrayList = this.f251a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ew) obj).b();
        }
    }

    @Override // a.ev
    public final void c(Exception exc) {
        List list = this.f;
        mk.f(list, "Argument must not be null");
        list.add(exc);
        g();
    }

    @Override // a.ew
    public final void cancel() {
        this.g = true;
        ArrayList arrayList = this.f251a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((ew) obj).cancel();
        }
    }

    @Override // a.ev
    public final void d(Object obj) {
        if (obj != null) {
            this.e.d(obj);
        } else {
            g();
        }
    }

    @Override // a.ew
    public final int e() {
        return ((ew) this.f251a.get(0)).e();
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) {
        this.d = rfVar;
        this.e = evVar;
        this.f = (List) this.b.acquire();
        ((ew) this.f251a.get(this.c)).f(rfVar, this);
        if (this.g) {
            cancel();
        }
    }

    public final void g() {
        if (this.g) {
            return;
        }
        if (this.c < this.f251a.size() - 1) {
            this.c++;
            f(this.d, this.e);
        } else {
            mk.e(this.f);
            this.e.c(new lc("Fetch failed", new ArrayList(this.f)));
        }
    }
}
