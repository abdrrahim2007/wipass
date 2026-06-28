package a;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class aq implements Collection, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f13a;
    public final boolean b;

    public aq(Object[] objArr, boolean z) {
        this.f13a = objArr;
        this.b = z;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        Object[] objArr = this.f13a;
        mk.h(objArr, "<this>");
        return at.r(objArr, obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        mk.h(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f13a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new i(1, this.f13a);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f13a.length;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        mk.h(objArr, "array");
        return pd.j(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] objArr = this.f13a;
        if (this.b && objArr.getClass().equals(Object[].class)) {
            return objArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        mk.g(objArrCopyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return objArrCopyOf;
    }
}
