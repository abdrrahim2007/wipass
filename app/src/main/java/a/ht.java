package a;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class ht implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f125a;

    public ht(ArrayList arrayList) {
        this.f125a = arrayList;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f125a.iterator();
    }
}
