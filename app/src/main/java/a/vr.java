package a;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class vr implements Iterator, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f334a;
    public final /* synthetic */ kj b;

    public vr(kj kjVar) {
        this.b = kjVar;
        this.f334a = ((tf) kjVar.c).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f334a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.b.b.invoke(this.f334a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
