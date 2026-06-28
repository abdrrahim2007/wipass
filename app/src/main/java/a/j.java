package a;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class j extends i implements ListIterator {
    public final /* synthetic */ l d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(l lVar, int i) {
        super(0, lVar);
        this.d = lVar;
        h hVar = l.Companion;
        int size = lVar.size();
        hVar.getClass();
        h.b(i, size);
        this.b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        return this.d.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
