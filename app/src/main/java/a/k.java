package a;

import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class k extends l implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f145a;
    public final int b;
    public final int c;

    public k(l lVar, int i, int i2) {
        this.f145a = lVar;
        this.b = i;
        h hVar = l.Companion;
        int size = lVar.size();
        hVar.getClass();
        h.c(i, i2, size);
        this.c = i2 - i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        l.Companion.getClass();
        h.a(i, this.c);
        return this.f145a.get(this.b + i);
    }

    @Override // a.e
    public final int getSize() {
        return this.c;
    }
}
