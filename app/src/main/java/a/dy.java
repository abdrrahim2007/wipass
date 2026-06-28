package a;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class dy implements tf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f64a;

    public dy(iy iyVar) {
        this.f64a = new AtomicReference(iyVar);
    }

    @Override // a.tf
    public final Iterator iterator() {
        tf tfVar = (tf) this.f64a.getAndSet(null);
        if (tfVar != null) {
            return tfVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
