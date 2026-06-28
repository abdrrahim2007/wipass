package a;

/* JADX INFO: loaded from: classes.dex */
public final class uu extends na {
    public final boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uu() {
        super(true);
        boolean z = true;
        s(null);
        cs csVarO = o();
        ct ctVar = csVarO instanceof ct ? (ct) csVarO : null;
        if (ctVar == null) {
            z = false;
            break;
        }
        na naVarL = ctVar.l();
        while (!naVarL.m()) {
            cs csVarO2 = naVarL.o();
            ct ctVar2 = csVarO2 instanceof ct ? (ct) csVarO2 : null;
            if (ctVar2 == null) {
                z = false;
                break;
            }
            naVarL = ctVar2.l();
        }
        this.b = z;
    }

    @Override // a.na
    public final boolean h(Throwable th) {
        return false;
    }

    @Override // a.na
    public final boolean m() {
        return this.b;
    }
}
