package a;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class y extends WeakReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nl f366a;
    public final boolean b;
    public sf c;

    public y(nl nlVar, hy hyVar, ReferenceQueue referenceQueue) {
        super(hyVar, referenceQueue);
        mk.f(nlVar, "Argument must not be null");
        this.f366a = nlVar;
        boolean z = hyVar.f127a;
        this.c = null;
        this.b = z;
    }
}
