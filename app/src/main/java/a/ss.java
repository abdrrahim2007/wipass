package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ss extends sr implements kg {
    private final int arity;

    public ss(ec ecVar) {
        super(ecVar);
        this.arity = 2;
    }

    @Override // a.kg
    public int getArity() {
        return this.arity;
    }

    @Override // a.az
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        rr.f274a.getClass();
        String strA = rs.a(this);
        mk.g(strA, "renderLambdaToString(this)");
        return strA;
    }
}
