package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class g implements eg {
    private final eh key;

    public g(eh ehVar) {
        this.key = ehVar;
    }

    @Override // a.ei
    public <R> R fold(R r, jw jwVar) {
        mk.h(jwVar, "operation");
        return (R) jwVar.invoke(r, this);
    }

    @Override // a.ei
    public eg get(eh ehVar) {
        mk.h(ehVar, "key");
        if (mk.a(getKey(), ehVar)) {
            return this;
        }
        return null;
    }

    @Override // a.eg
    public eh getKey() {
        return this.key;
    }

    @Override // a.ei
    public ei minusKey(eh ehVar) {
        return bs.e(this, ehVar);
    }

    @Override // a.ei
    public ei plus(ei eiVar) {
        mk.h(eiVar, "context");
        return vs.c(this, eiVar);
    }
}
