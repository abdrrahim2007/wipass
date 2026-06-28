package a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class nx implements ListIterator, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ny f200a;
    public int b;
    public int c = -1;

    public nx(ny nyVar, int i) {
        this.f200a = nyVar;
        this.b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        int i = this.b;
        this.b = i + 1;
        this.f200a.add(i, obj);
        this.c = -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f200a.c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        int i = this.b;
        ny nyVar = this.f200a;
        if (i >= nyVar.c) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        this.c = i;
        return nyVar.f201a[nyVar.b + i];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        int i = this.b;
        if (i <= 0) {
            throw new NoSuchElementException();
        }
        int i2 = i - 1;
        this.b = i2;
        this.c = i2;
        ny nyVar = this.f200a;
        return nyVar.f201a[nyVar.b + i2];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
        this.f200a.b(i);
        this.b = this.c;
        this.c = -1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
        this.f200a.set(i, obj);
    }
}
