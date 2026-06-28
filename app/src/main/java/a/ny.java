package a;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public final class ny extends m implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f201a;
    public final int b;
    public int c;
    public boolean d;
    public final ny e;
    public final ny f;

    public ny(Object[] objArr, int i, int i2, boolean z, ny nyVar, ny nyVar2) {
        this.f201a = objArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = nyVar;
        this.f = nyVar2;
    }

    private final Object writeReplace() throws NotSerializableException {
        ny nyVar;
        if (this.d || ((nyVar = this.f) != null && nyVar.d)) {
            return new tl(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // a.m
    public final int a() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        e();
        d(this.b + this.c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        mk.h(collection, "elements");
        e();
        int size = collection.size();
        c(this.b + this.c, collection, size);
        return size > 0;
    }

    @Override // a.m
    public final Object b(int i) {
        e();
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.a(i, i2);
        return g(this.b + i);
    }

    public final void c(int i, Collection collection, int i2) {
        ny nyVar = this.e;
        if (nyVar != null) {
            nyVar.c(i, collection, i2);
            this.f201a = nyVar.f201a;
            this.c += i2;
        } else {
            f(i, i2);
            Iterator it = collection.iterator();
            for (int i3 = 0; i3 < i2; i3++) {
                this.f201a[i + i3] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        e();
        h(this.b, this.c);
    }

    public final void d(int i, Object obj) {
        ny nyVar = this.e;
        if (nyVar == null) {
            f(i, 1);
            this.f201a[i] = obj;
        } else {
            nyVar.d(i, obj);
            this.f201a = nyVar.f201a;
            this.c++;
        }
    }

    public final void e() {
        ny nyVar;
        if (this.d || ((nyVar = this.f) != null && nyVar.d)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f201a;
            int i = this.c;
            if (i == list.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (mk.a(objArr[this.b + i2], list.get(i2))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f(int i, int i2) {
        int i3 = this.c + i2;
        if (this.e != null) {
            throw new IllegalStateException();
        }
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f201a;
        if (i3 > objArr.length) {
            int length = objArr.length;
            int i4 = length + (length >> 1);
            if (i4 - i3 < 0) {
                i4 = i3;
            }
            if (i4 - 2147483639 > 0) {
                i4 = i3 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
            mk.g(objArrCopyOf, "copyOf(this, newSize)");
            this.f201a = objArrCopyOf;
        }
        Object[] objArr2 = this.f201a;
        at.l(objArr2, objArr2, i + i2, i, this.b + this.c);
        this.c += i2;
    }

    public final Object g(int i) {
        ny nyVar = this.e;
        if (nyVar != null) {
            this.c--;
            return nyVar.g(i);
        }
        Object[] objArr = this.f201a;
        Object obj = objArr[i];
        int i2 = this.c;
        int i3 = this.b;
        at.l(objArr, objArr, i, i + 1, i2 + i3);
        Object[] objArr2 = this.f201a;
        int i4 = (i3 + this.c) - 1;
        mk.h(objArr2, "<this>");
        objArr2[i4] = null;
        this.c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.a(i, i2);
        return this.f201a[this.b + i];
    }

    public final void h(int i, int i2) {
        ny nyVar = this.e;
        if (nyVar != null) {
            nyVar.h(i, i2);
        } else {
            Object[] objArr = this.f201a;
            at.l(objArr, objArr, i, i + i2, this.c);
            Object[] objArr2 = this.f201a;
            int i3 = this.c;
            vs.d(objArr2, i3 - i2, i3);
        }
        this.c -= i2;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f201a;
        int i = this.c;
        int iHashCode = 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[this.b + i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final int i(int i, int i2, Collection collection, boolean z) {
        ny nyVar = this.e;
        if (nyVar != null) {
            int i3 = nyVar.i(i, i2, collection, z);
            this.c -= i3;
            return i3;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = i + i4;
            if (collection.contains(this.f201a[i6]) == z) {
                Object[] objArr = this.f201a;
                i4++;
                objArr[i5 + i] = objArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i2 - i5;
        Object[] objArr2 = this.f201a;
        at.l(objArr2, objArr2, i + i5, i2 + i, this.c);
        Object[] objArr3 = this.f201a;
        int i8 = this.c;
        vs.d(objArr3, i8 - i7, i8);
        this.c -= i7;
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i = 0; i < this.c; i++) {
            if (mk.a(this.f201a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new nx(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i = this.c - 1; i >= 0; i--) {
            if (mk.a(this.f201a[this.b + i], obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new nx(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        e();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        mk.h(collection, "elements");
        e();
        return i(this.b, this.c, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        mk.h(collection, "elements");
        e();
        return i(this.b, this.c, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        e();
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.a(i, i2);
        Object[] objArr = this.f201a;
        int i3 = this.b + i;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        h hVar = l.Companion;
        int i3 = this.c;
        hVar.getClass();
        h.c(i, i2, i3);
        Object[] objArr = this.f201a;
        int i4 = this.b + i;
        int i5 = i2 - i;
        boolean z = this.d;
        ny nyVar = this.f;
        return new ny(objArr, i4, i5, z, this, nyVar == null ? this : nyVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        mk.h(objArr, "destination");
        int length = objArr.length;
        int i = this.c;
        int i2 = this.b;
        if (length < i) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f201a, i2, i + i2, objArr.getClass());
            mk.g(objArrCopyOfRange, "copyOfRange(array, offse…h, destination.javaClass)");
            return objArrCopyOfRange;
        }
        at.l(this.f201a, objArr, 0, i2, i + i2);
        int length2 = objArr.length;
        int i3 = this.c;
        if (length2 > i3) {
            objArr[i3] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        Object[] objArr = this.f201a;
        int i = this.c;
        StringBuilder sb = new StringBuilder((i * 3) + 2);
        sb.append("[");
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(objArr[this.b + i2]);
        }
        sb.append("]");
        String string = sb.toString();
        mk.g(string, "sb.toString()");
        return string;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.b(i, i2);
        return new nx(this, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        e();
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.b(i, i2);
        d(this.b + i, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        mk.h(collection, "elements");
        e();
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.b(i, i2);
        int size = collection.size();
        c(this.b + i, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        Object[] objArr = this.f201a;
        int i = this.c;
        int i2 = this.b;
        return at.o(objArr, i2, i + i2);
    }

    public ny() {
        this(10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ny(int i) {
        this(new Object[i], 0, 0, false, null, null);
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }
}
