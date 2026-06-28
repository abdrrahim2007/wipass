package a;

/* JADX INFO: loaded from: classes.dex */
public final class vv extends sz {
    public ThreadLocal d;

    public final boolean ab() {
        ThreadLocal threadLocal = this.d;
        if (threadLocal.get() == null) {
            return false;
        }
        threadLocal.set(null);
        return true;
    }

    @Override // a.sz, a.na
    public final void d(Object obj) {
        ThreadLocal threadLocal = this.d;
        qw qwVar = (qw) threadLocal.get();
        if (qwVar != null) {
            mk.n((ei) qwVar.f259a, qwVar.b);
            threadLocal.set(null);
        }
        Object objL = mk.l(obj);
        ec ecVar = this.c;
        ei context = ecVar.getContext();
        Object objP = mk.p(context, null);
        vv vvVarN = objP != mk.b ? pd.n(ecVar, context, objP) : null;
        try {
            ecVar.resumeWith(objL);
            if (vvVarN == null || vvVarN.ab()) {
                mk.n(context, objP);
            }
        } catch (Throwable th) {
            if (vvVarN == null || vvVarN.ab()) {
                mk.n(context, objP);
            }
            throw th;
        }
    }
}
