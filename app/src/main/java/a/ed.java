package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ed extends az {
    private final ei _context;
    private transient ec intercepted;

    public ed(ec ecVar, ei eiVar) {
        super(ecVar);
        this._context = eiVar;
    }

    @Override // a.ec
    public ei getContext() {
        ei eiVar = this._context;
        mk.c(eiVar);
        return eiVar;
    }

    public final ec intercepted() {
        ec ecVarInterceptContinuation = this.intercepted;
        if (ecVarInterceptContinuation == null) {
            ef efVar = (ef) getContext().get(ee.b);
            if (efVar == null || (ecVarInterceptContinuation = efVar.interceptContinuation(this)) == null) {
                ecVarInterceptContinuation = this;
            }
            this.intercepted = ecVarInterceptContinuation;
        }
        return ecVarInterceptContinuation;
    }

    @Override // a.az
    public void releaseIntercepted() {
        ec ecVar = this.intercepted;
        if (ecVar != null && ecVar != this) {
            eg egVar = getContext().get(ee.b);
            mk.c(egVar);
            ((ef) egVar).releaseInterceptedContinuation(ecVar);
        }
        this.intercepted = dm.f57a;
    }

    public ed(ec ecVar) {
        this(ecVar, ecVar != null ? ecVar.getContext() : null);
    }
}
