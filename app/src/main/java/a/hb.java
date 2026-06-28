package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class hb implements ei, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hb f109a = new hb();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return f109a;
    }

    @Override // a.ei
    public final eg get(eh ehVar) {
        mk.h(ehVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // a.ei
    public final ei minusKey(eh ehVar) {
        mk.h(ehVar, "key");
        return this;
    }

    @Override // a.ei
    public final ei plus(ei eiVar) {
        mk.h(eiVar, "context");
        return eiVar;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // a.ei
    public final Object fold(Object obj, jw jwVar) {
        return obj;
    }
}
