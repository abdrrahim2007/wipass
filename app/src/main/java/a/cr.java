package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class cr extends mv {
    public final cl e;

    public cr(cl clVar) {
        this.e = clVar;
    }

    @Override // a.js
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m((Throwable) obj);
        return vx.f338a;
    }

    @Override // a.mw
    public final void m(Throwable th) {
        gq gqVar;
        CancellationException cancellationExceptionL = l().l();
        cl clVar = this.e;
        if (!clVar.o() ? false : ((gm) clVar.d).h(cancellationExceptionL)) {
            return;
        }
        clVar.i(cancellationExceptionL);
        if (clVar.o() || (gqVar = clVar.f) == null) {
            return;
        }
        gqVar.dispose();
        clVar.f = qm.f256a;
    }
}
