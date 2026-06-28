package a;

/* JADX INFO: loaded from: classes.dex */
public final class vw implements eg, eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vw f337a = new vw();

    @Override // a.ei
    public final Object fold(Object obj, jw jwVar) {
        return jwVar.invoke(obj, this);
    }

    @Override // a.ei
    public final eg get(eh ehVar) {
        mk.h(ehVar, "key");
        if (mk.a(this, ehVar)) {
            return this;
        }
        return null;
    }

    @Override // a.ei
    public final ei minusKey(eh ehVar) {
        return bs.e(this, ehVar);
    }

    @Override // a.ei
    public final ei plus(ei eiVar) {
        mk.h(eiVar, "context");
        return vs.c(this, eiVar);
    }

    @Override // a.eg
    public final eh getKey() {
        return this;
    }
}
