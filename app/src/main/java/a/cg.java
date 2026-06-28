package a;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class cg extends ArrayMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final void clear() {
        this.f45a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final int hashCode() {
        if (this.f45a == 0) {
            this.f45a = super.hashCode();
        }
        return this.f45a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        this.f45a = 0;
        return super.put(obj, obj2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final void putAll(SimpleArrayMap simpleArrayMap) {
        this.f45a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object removeAt(int i) {
        this.f45a = 0;
        return super.removeAt(i);
    }

    @Override // androidx.collection.SimpleArrayMap
    public final Object setValueAt(int i, Object obj) {
        this.f45a = 0;
        return super.setValueAt(i, obj);
    }
}
