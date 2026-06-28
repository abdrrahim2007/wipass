package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class tg extends th implements Iterator, ec, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f295a;
    public Object b;
    public Iterator c;
    public ec d;

    @Override // a.th
    public final void a(Object obj, ss ssVar) {
        this.b = obj;
        this.f295a = 3;
        this.d = ssVar;
    }

    public final RuntimeException b() {
        int i = this.f295a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f295a);
    }

    @Override // a.ec
    public final ei getContext() {
        return hb.f109a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f295a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.c;
                mk.c(it);
                if (it.hasNext()) {
                    this.f295a = 2;
                    return true;
                }
                this.c = null;
            }
            this.f295a = 5;
            ec ecVar = this.d;
            mk.c(ecVar);
            this.d = null;
            ecVar.resumeWith(vx.f338a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f295a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f295a = 1;
            Iterator it = this.c;
            mk.c(it);
            return it.next();
        }
        if (i != 3) {
            throw b();
        }
        this.f295a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // a.ec
    public final void resumeWith(Object obj) throws Throwable {
        pd.h(obj);
        this.f295a = 4;
    }
}
