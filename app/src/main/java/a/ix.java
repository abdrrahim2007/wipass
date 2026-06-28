package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class ix implements Iterator, ng {
    public Object b;
    public final Object d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f137a = 0;
    public int c = -1;

    public ix(iy iyVar) {
        this.d = new vr((kj) iyVar.b);
    }

    public void a() {
        boolean z;
        Object next;
        Iterator it = (Iterator) this.d;
        do {
            z = false;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            } else {
                next = it.next();
                if (next == null) {
                    z = true;
                }
            }
        } while (z);
        this.b = next;
        this.c = 1;
    }

    public void b() {
        Object objInvoke;
        kj kjVar = (kj) this.d;
        if (this.c == -2) {
            objInvoke = ((tk) kjVar.c).f296a;
        } else {
            js jsVar = kjVar.b;
            Object obj = this.b;
            mk.c(obj);
            objInvoke = jsVar.invoke(obj);
        }
        this.b = objInvoke;
        this.c = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f137a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 1) {
                }
                break;
            default:
                if (this.c < 0) {
                    b();
                }
                if (this.c == 1) {
                }
                break;
        }
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f137a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.b;
                this.b = null;
                this.c = -1;
                return obj;
            default:
                if (this.c < 0) {
                    b();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj2 = this.b;
                mk.d(obj2, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                this.c = -1;
                return obj2;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f137a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ix(kj kjVar) {
        this.d = kjVar;
    }
}
