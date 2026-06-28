package a;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class i implements Iterator, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f129a;
    public int b;
    public final Object c;

    public /* synthetic */ i(int i, Object obj) {
        this.f129a = i;
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f129a) {
            case 0:
                if (this.b < ((l) this.c).size()) {
                }
                break;
            default:
                if (this.b < ((Object[]) this.c).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f129a) {
            case 0:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                l lVar = (l) this.c;
                int i = this.b;
                this.b = i + 1;
                return lVar.get(i);
            default:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i2 = this.b;
                    this.b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.b--;
                    throw new NoSuchElementException(e.getMessage());
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f129a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
