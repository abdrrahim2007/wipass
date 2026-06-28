package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends na implements ec, ep {
    public final ei b;

    public f(ei eiVar, boolean z) {
        super(z);
        s((mt) eiVar.get(ee.e));
        this.b = eiVar.plus(this);
    }

    @Override // a.na
    public final String g() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // a.ec
    public final ei getContext() {
        return this.b;
    }

    @Override // a.ep
    public final ei getCoroutineContext() {
        return this.b;
    }

    @Override // a.na
    public final void r(dq dqVar) {
        ky.b(this.b, dqVar);
    }

    @Override // a.ec
    public final void resumeWith(Object obj) {
        Throwable thA = su.a(obj);
        if (thA != null) {
            obj = new dn(false, thA);
        }
        Object objU = u(obj);
        if (objU == bs.c) {
            return;
        }
        d(objU);
    }
}
