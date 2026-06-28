package a;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class tn extends n implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pa f299a;

    public tn(int i) {
        this.f299a = new pa(i);
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.f299a.l) {
            return new tl(this, 1);
        }
        throw new NotSerializableException("The set cannot be serialized while it is being built.");
    }

    @Override // a.n
    public final int a() {
        return this.f299a.h;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        return this.f299a.a(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        mk.h(collection, "elements");
        this.f299a.b();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f299a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f299a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return this.f299a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        pa paVar = this.f299a;
        paVar.getClass();
        return new oy(paVar, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        pa paVar = this.f299a;
        paVar.b();
        int iF = paVar.f(obj);
        if (iF < 0) {
            iF = -1;
        } else {
            paVar.j(iF);
        }
        return iF >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        mk.h(collection, "elements");
        this.f299a.b();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        mk.h(collection, "elements");
        this.f299a.b();
        return super.retainAll(collection);
    }
}
