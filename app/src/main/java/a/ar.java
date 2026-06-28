package a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class ar extends m {
    public static final Object[] d = new Object[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14a;
    public Object[] b = d;
    public int c;

    @Override // a.m
    public final int a() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        mk.h(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        d(collection.size() + a());
        c(f(a() + this.f14a), collection);
        return true;
    }

    public final void addLast(Object obj) {
        d(a() + 1);
        this.b[f(a() + this.f14a)] = obj;
        this.c = a() + 1;
    }

    @Override // a.m
    public final Object b(int i) {
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.a(i, i2);
        if (i == cz.g(this)) {
            if (isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            int iF = f(cz.g(this) + this.f14a);
            Object[] objArr = this.b;
            Object obj = objArr[iF];
            objArr[iF] = null;
            this.c--;
            return obj;
        }
        if (i == 0) {
            if (isEmpty()) {
                throw new NoSuchElementException("ArrayDeque is empty.");
            }
            Object[] objArr2 = this.b;
            int i3 = this.f14a;
            Object obj2 = objArr2[i3];
            objArr2[i3] = null;
            this.f14a = e(i3);
            this.c--;
            return obj2;
        }
        int iF2 = f(this.f14a + i);
        Object[] objArr3 = this.b;
        Object obj3 = objArr3[iF2];
        if (i < (this.c >> 1)) {
            int i4 = this.f14a;
            if (iF2 >= i4) {
                at.l(objArr3, objArr3, i4 + 1, i4, iF2);
            } else {
                at.l(objArr3, objArr3, 1, 0, iF2);
                Object[] objArr4 = this.b;
                objArr4[0] = objArr4[objArr4.length - 1];
                int i5 = this.f14a;
                at.l(objArr4, objArr4, i5 + 1, i5, objArr4.length - 1);
            }
            Object[] objArr5 = this.b;
            int i6 = this.f14a;
            objArr5[i6] = null;
            this.f14a = e(i6);
        } else {
            int iF3 = f(cz.g(this) + this.f14a);
            if (iF2 <= iF3) {
                Object[] objArr6 = this.b;
                at.l(objArr6, objArr6, iF2, iF2 + 1, iF3 + 1);
            } else {
                Object[] objArr7 = this.b;
                at.l(objArr7, objArr7, iF2, iF2 + 1, objArr7.length);
                Object[] objArr8 = this.b;
                objArr8[objArr8.length - 1] = objArr8[0];
                at.l(objArr8, objArr8, 0, 1, iF3 + 1);
            }
            this.b[iF3] = null;
        }
        this.c--;
        return obj3;
    }

    public final void c(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.f14a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = collection.size() + this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iF = f(this.c + this.f14a);
        int i = this.f14a;
        if (i < iF) {
            at.p(this.b, i, iF);
        } else if (!isEmpty()) {
            Object[] objArr = this.b;
            at.p(objArr, this.f14a, objArr.length);
            at.p(this.b, 0, iF);
        }
        this.f14a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == d) {
            if (i < 10) {
                i = 10;
            }
            this.b = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        at.l(objArr, objArr2, 0, this.f14a, objArr.length);
        Object[] objArr3 = this.b;
        int length2 = objArr3.length;
        int i3 = this.f14a;
        at.l(objArr3, objArr2, length2 - i3, 0, i3);
        this.f14a = 0;
        this.b = objArr2;
    }

    public final int e(int i) {
        mk.h(this.b, "<this>");
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final int f(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.a(i, i2);
        return this.b[f(this.f14a + i)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iF = f(a() + this.f14a);
        int length = this.f14a;
        if (length < iF) {
            while (length < iF) {
                if (mk.a(obj, this.b[length])) {
                    i = this.f14a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iF) {
            return -1;
        }
        int length2 = this.b.length;
        while (true) {
            if (length >= length2) {
                for (int i2 = 0; i2 < iF; i2++) {
                    if (mk.a(obj, this.b[i2])) {
                        length = i2 + this.b.length;
                        i = this.f14a;
                    }
                }
                return -1;
            }
            if (mk.a(obj, this.b[length])) {
                i = this.f14a;
                break;
            }
            length++;
        }
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iF = f(this.c + this.f14a);
        int i2 = this.f14a;
        if (i2 < iF) {
            length = iF - 1;
            if (i2 <= length) {
                while (!mk.a(obj, this.b[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.f14a;
                return length - i;
            }
            return -1;
        }
        if (i2 > iF) {
            int i3 = iF - 1;
            while (true) {
                if (-1 >= i3) {
                    Object[] objArr = this.b;
                    mk.h(objArr, "<this>");
                    length = objArr.length - 1;
                    int i4 = this.f14a;
                    if (i4 <= length) {
                        while (!mk.a(obj, this.b[length])) {
                            if (length != i4) {
                                length--;
                            }
                        }
                        i = this.f14a;
                    }
                } else {
                    if (mk.a(obj, this.b[i3])) {
                        length = i3 + this.b.length;
                        i = this.f14a;
                        break;
                    }
                    i3--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iF;
        mk.h(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iF2 = f(this.c + this.f14a);
            int i = this.f14a;
            if (i < iF2) {
                iF = i;
                while (i < iF2) {
                    Object obj = this.b[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.b[iF] = obj;
                        iF++;
                    }
                    i++;
                }
                at.p(this.b, iF, iF2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.b[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iF = f(i2);
                for (int i3 = 0; i3 < iF2; i3++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.b[iF] = obj3;
                        iF = e(iF);
                    }
                }
                z = z2;
            }
            if (z) {
                int length2 = iF - this.f14a;
                if (length2 < 0) {
                    length2 += this.b.length;
                }
                this.c = length2;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iF;
        mk.h(collection, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int iF2 = f(this.c + this.f14a);
            int i = this.f14a;
            if (i < iF2) {
                iF = i;
                while (i < iF2) {
                    Object obj = this.b[i];
                    if (collection.contains(obj)) {
                        this.b[iF] = obj;
                        iF++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                at.p(this.b, iF, iF2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iF = f(i2);
                for (int i3 = 0; i3 < iF2; i3++) {
                    Object[] objArr2 = this.b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (collection.contains(obj3)) {
                        this.b[iF] = obj3;
                        iF = e(iF);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                int length2 = iF - this.f14a;
                if (length2 < 0) {
                    length2 += this.b.length;
                }
                this.c = length2;
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.a(i, i2);
        int iF = f(this.f14a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[iF];
        objArr[iF] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.b(i, i2);
        int i3 = this.c;
        if (i == i3) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            d(i3 + 1);
            int length2 = this.f14a;
            if (length2 == 0) {
                Object[] objArr = this.b;
                mk.h(objArr, "<this>");
                length2 = objArr.length;
            }
            int i4 = length2 - 1;
            this.f14a = i4;
            this.b[i4] = obj;
            this.c++;
            return;
        }
        d(i3 + 1);
        int iF = f(this.f14a + i);
        int i5 = this.c;
        if (i < ((i5 + 1) >> 1)) {
            if (iF == 0) {
                Object[] objArr2 = this.b;
                mk.h(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = iF - 1;
            }
            int length3 = this.f14a;
            if (length3 == 0) {
                Object[] objArr3 = this.b;
                mk.h(objArr3, "<this>");
                length3 = objArr3.length;
            }
            int i6 = length3 - 1;
            int i7 = this.f14a;
            if (length >= i7) {
                Object[] objArr4 = this.b;
                objArr4[i6] = objArr4[i7];
                at.l(objArr4, objArr4, i7, i7 + 1, length + 1);
            } else {
                Object[] objArr5 = this.b;
                at.l(objArr5, objArr5, i7 - 1, i7, objArr5.length);
                Object[] objArr6 = this.b;
                objArr6[objArr6.length - 1] = objArr6[0];
                at.l(objArr6, objArr6, 0, 1, length + 1);
            }
            this.b[length] = obj;
            this.f14a = i6;
        } else {
            int iF2 = f(i5 + this.f14a);
            if (iF < iF2) {
                Object[] objArr7 = this.b;
                at.l(objArr7, objArr7, iF + 1, iF, iF2);
            } else {
                Object[] objArr8 = this.b;
                at.l(objArr8, objArr8, 1, 0, iF2);
                Object[] objArr9 = this.b;
                objArr9[0] = objArr9[objArr9.length - 1];
                at.l(objArr9, objArr9, iF + 1, iF, objArr9.length - 1);
            }
            this.b[iF] = obj;
        }
        this.c++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        mk.h(objArr, "array");
        int length = objArr.length;
        int i = this.c;
        if (length < i) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            mk.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            objArr = (Object[]) objNewInstance;
        }
        Object[] objArr2 = objArr;
        int iF = f(this.c + this.f14a);
        int i2 = this.f14a;
        if (i2 < iF) {
            at.n(this.b, objArr2, 0, i2, iF, 2);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.b;
            at.l(objArr3, objArr2, 0, this.f14a, objArr3.length);
            Object[] objArr4 = this.b;
            at.l(objArr4, objArr2, objArr4.length - this.f14a, 0, iF);
        }
        int length2 = objArr2.length;
        int i3 = this.c;
        if (length2 > i3) {
            objArr2[i3] = null;
        }
        return objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        mk.h(collection, "elements");
        h hVar = l.Companion;
        int i2 = this.c;
        hVar.getClass();
        h.b(i, i2);
        if (collection.isEmpty()) {
            return false;
        }
        int i3 = this.c;
        if (i == i3) {
            return addAll(collection);
        }
        d(collection.size() + i3);
        int iF = f(this.c + this.f14a);
        int iF2 = f(this.f14a + i);
        int size = collection.size();
        if (i < ((this.c + 1) >> 1)) {
            int i4 = this.f14a;
            int length = i4 - size;
            if (iF2 < i4) {
                Object[] objArr = this.b;
                at.l(objArr, objArr, length, i4, objArr.length);
                if (size >= iF2) {
                    Object[] objArr2 = this.b;
                    at.l(objArr2, objArr2, objArr2.length - size, 0, iF2);
                } else {
                    Object[] objArr3 = this.b;
                    at.l(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.b;
                    at.l(objArr4, objArr4, 0, size, iF2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.b;
                at.l(objArr5, objArr5, length, i4, iF2);
            } else {
                Object[] objArr6 = this.b;
                length += objArr6.length;
                int i5 = iF2 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    at.l(objArr6, objArr6, length, i4, iF2);
                } else {
                    at.l(objArr6, objArr6, length, i4, i4 + length2);
                    Object[] objArr7 = this.b;
                    at.l(objArr7, objArr7, 0, this.f14a + length2, iF2);
                }
            }
            this.f14a = length;
            int length3 = iF2 - size;
            if (length3 < 0) {
                length3 += this.b.length;
            }
            c(length3, collection);
            return true;
        }
        int i6 = iF2 + size;
        if (iF2 < iF) {
            int i7 = size + iF;
            Object[] objArr8 = this.b;
            if (i7 <= objArr8.length) {
                at.l(objArr8, objArr8, i6, iF2, iF);
            } else if (i6 >= objArr8.length) {
                at.l(objArr8, objArr8, i6 - objArr8.length, iF2, iF);
            } else {
                int length4 = iF - (i7 - objArr8.length);
                at.l(objArr8, objArr8, 0, length4, iF);
                Object[] objArr9 = this.b;
                at.l(objArr9, objArr9, i6, iF2, length4);
            }
        } else {
            Object[] objArr10 = this.b;
            at.l(objArr10, objArr10, size, 0, iF);
            Object[] objArr11 = this.b;
            if (i6 >= objArr11.length) {
                at.l(objArr11, objArr11, i6 - objArr11.length, iF2, objArr11.length);
            } else {
                at.l(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                Object[] objArr12 = this.b;
                at.l(objArr12, objArr12, i6, iF2, objArr12.length - size);
            }
        }
        c(iF2, collection);
        return true;
    }
}
