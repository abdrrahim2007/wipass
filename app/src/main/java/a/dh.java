package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class dh implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei[] f52a;

    public dh(ei[] eiVarArr) {
        this.f52a = eiVarArr;
    }

    private final Object readResolve() {
        ei[] eiVarArr = this.f52a;
        ei eiVarPlus = hb.f109a;
        for (ei eiVar : eiVarArr) {
            eiVarPlus = eiVarPlus.plus(eiVar);
        }
        return eiVarPlus;
    }
}
