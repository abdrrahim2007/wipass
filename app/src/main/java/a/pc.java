package a;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class pc extends AbstractCollection implements Collection, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pa f227a;

    public pc(pa paVar) {
        this.f227a = paVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        mk.h(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f227a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f227a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f227a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        pa paVar = this.f227a;
        paVar.getClass();
        return new oy(paVar, 2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        pa paVar = this.f227a;
        paVar.b();
        int iG = paVar.g(obj);
        if (iG < 0) {
            return false;
        }
        paVar.j(iG);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        mk.h(collection, "elements");
        this.f227a.b();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        mk.h(collection, "elements");
        this.f227a.b();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f227a.h;
    }
}
