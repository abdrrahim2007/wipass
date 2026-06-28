package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class nm implements kg, Serializable {
    private final int arity;

    public nm(int i) {
        this.arity = i;
    }

    @Override // a.kg
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        rr.f274a.getClass();
        String strA = rs.a(this);
        mk.g(strA, "renderLambdaToString(this)");
        return strA;
    }
}
