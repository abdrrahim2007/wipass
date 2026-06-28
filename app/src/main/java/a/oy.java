package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class oy implements Iterator, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pa f223a;
    public int b;
    public int c;
    public final /* synthetic */ int d;

    public oy(pa paVar, int i) {
        this.d = i;
        mk.h(paVar, "map");
        this.f223a = paVar;
        this.c = -1;
        a();
    }

    public final void a() {
        while (true) {
            int i = this.b;
            pa paVar = this.f223a;
            if (i >= paVar.f || paVar.c[i] >= 0) {
                return;
            } else {
                this.b = i + 1;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f223a.f;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.d) {
            case 0:
                int i = this.b;
                pa paVar = this.f223a;
                if (i >= paVar.f) {
                    throw new NoSuchElementException();
                }
                this.b = i + 1;
                this.c = i;
                oz ozVar = new oz(paVar, i);
                a();
                return ozVar;
            case 1:
                int i2 = this.b;
                pa paVar2 = this.f223a;
                if (i2 >= paVar2.f) {
                    throw new NoSuchElementException();
                }
                this.b = i2 + 1;
                this.c = i2;
                Object obj = paVar2.f225a[i2];
                a();
                return obj;
            default:
                int i3 = this.b;
                pa paVar3 = this.f223a;
                if (i3 >= paVar3.f) {
                    throw new NoSuchElementException();
                }
                this.b = i3 + 1;
                this.c = i3;
                Object[] objArr = paVar3.b;
                mk.c(objArr);
                Object obj2 = objArr[this.c];
                a();
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (this.c == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        pa paVar = this.f223a;
        paVar.b();
        paVar.j(this.c);
        this.c = -1;
    }
}
