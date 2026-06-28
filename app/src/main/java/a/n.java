package a;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends AbstractSet implements Set, ng {
    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
