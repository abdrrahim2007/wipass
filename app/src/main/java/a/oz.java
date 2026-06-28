package a;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class oz implements Map.Entry, nh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pa f224a;
    public final int b;

    public oz(pa paVar, int i) {
        mk.h(paVar, "map");
        this.f224a = paVar;
        this.b = i;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return mk.a(entry.getKey(), getKey()) && mk.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f224a.f225a[this.b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        Object[] objArr = this.f224a.b;
        mk.c(objArr);
        return objArr[this.b];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        pa paVar = this.f224a;
        paVar.b();
        Object[] objArr = paVar.b;
        if (objArr == null) {
            int length = paVar.f225a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            paVar.b = objArr;
        }
        int i = this.b;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
