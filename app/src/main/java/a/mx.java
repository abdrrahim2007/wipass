package a;

/* JADX INFO: loaded from: classes.dex */
public final class mx extends mw {
    public final na e;
    public final my f;
    public final ct g;
    public final Object h;

    public mx(na naVar, my myVar, ct ctVar, Object obj) {
        this.e = naVar;
        this.f = myVar;
        this.g = ctVar;
        this.h = obj;
    }

    @Override // a.js
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m((Throwable) obj);
        return vx.f338a;
    }

    @Override // a.mw
    public final void m(Throwable th) {
        ct ctVarV = na.v(this.g);
        na naVar = this.e;
        my myVar = this.f;
        Object obj = this.h;
        if (ctVarV != null) {
            while (ky.c(ctVarV.e, new mx(naVar, myVar, ctVarV, obj), 1) == qm.f256a) {
                ctVarV = na.v(ctVarV);
                if (ctVarV == null) {
                }
            }
            return;
        }
        naVar.c(naVar.k(myVar, obj));
    }
}
