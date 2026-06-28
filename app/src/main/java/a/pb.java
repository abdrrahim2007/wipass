package a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class pb extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f226a;
    public final pa b;

    public /* synthetic */ pb(pa paVar, int i) {
        this.f226a = i;
        this.b = paVar;
    }

    @Override // a.n
    public final int a() {
        switch (this.f226a) {
        }
        return this.b.h;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f226a) {
            case 0:
                mk.h((Map.Entry) obj, "element");
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        switch (this.f226a) {
            case 0:
                mk.h(collection, "elements");
                throw new UnsupportedOperationException();
            default:
                mk.h(collection, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f226a) {
            case 0:
                this.b.clear();
                break;
            default:
                this.b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f226a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.b.d((Map.Entry) obj);
            default:
                return this.b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f226a) {
            case 0:
                mk.h(collection, "elements");
                return this.b.c(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f226a) {
        }
        return this.b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f226a) {
            case 0:
                pa paVar = this.b;
                paVar.getClass();
                return new oy(paVar, 0);
            default:
                pa paVar2 = this.b;
                paVar2.getClass();
                return new oy(paVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f226a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                pa paVar = this.b;
                paVar.getClass();
                paVar.b();
                int iF = paVar.f(entry.getKey());
                if (iF < 0) {
                    return false;
                }
                Object[] objArr = paVar.b;
                mk.c(objArr);
                if (!mk.a(objArr[iF], entry.getValue())) {
                    return false;
                }
                paVar.j(iF);
                return true;
            default:
                pa paVar2 = this.b;
                paVar2.b();
                int iF2 = paVar2.f(obj);
                if (iF2 < 0) {
                    iF2 = -1;
                } else {
                    paVar2.j(iF2);
                }
                return iF2 >= 0;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        switch (this.f226a) {
            case 0:
                mk.h(collection, "elements");
                this.b.b();
                break;
            default:
                mk.h(collection, "elements");
                this.b.b();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        switch (this.f226a) {
            case 0:
                mk.h(collection, "elements");
                this.b.b();
                break;
            default:
                mk.h(collection, "elements");
                this.b.b();
                break;
        }
        return super.retainAll(collection);
    }
}
