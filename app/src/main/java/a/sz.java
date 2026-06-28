package a;

/* JADX INFO: loaded from: classes.dex */
public class sz extends f implements er {
    public final ec c;

    public sz(ec ecVar, ei eiVar) {
        super(eiVar, true);
        this.c = ecVar;
    }

    @Override // a.na
    public void c(Object obj) {
        ky.f(mk.l(obj), pd.e(this.c));
    }

    @Override // a.na
    public void d(Object obj) {
        this.c.resumeWith(mk.l(obj));
    }

    @Override // a.er
    public final er getCallerFrame() {
        ec ecVar = this.c;
        if (ecVar instanceof er) {
            return (er) ecVar;
        }
        return null;
    }

    @Override // a.na
    public final boolean t() {
        return true;
    }
}
