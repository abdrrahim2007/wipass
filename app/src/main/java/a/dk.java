package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class dk implements ei, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei f55a;
    public final eg b;

    public dk(ei eiVar, eg egVar) {
        mk.h(eiVar, "left");
        mk.h(egVar, "element");
        this.f55a = eiVar;
        this.b = egVar;
    }

    private final Object writeReplace() {
        int iB = b();
        ei[] eiVarArr = new ei[iB];
        rq rqVar = new rq();
        fold(vx.f338a, new dj(eiVarArr, rqVar));
        if (rqVar.f273a == iB) {
            return new dh(eiVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int b() {
        int i = 2;
        dk dkVar = this;
        while (true) {
            ei eiVar = dkVar.f55a;
            dkVar = eiVar instanceof dk ? (dk) eiVar : null;
            if (dkVar == null) {
                return i;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof dk) {
            dk dkVar = (dk) obj;
            if (dkVar.b() == b()) {
                dk dkVar2 = this;
                while (true) {
                    eg egVar = dkVar2.b;
                    if (!mk.a(dkVar.get(egVar.getKey()), egVar)) {
                        zA = false;
                        break;
                    }
                    ei eiVar = dkVar2.f55a;
                    if (!(eiVar instanceof dk)) {
                        mk.d(eiVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        eg egVar2 = (eg) eiVar;
                        zA = mk.a(dkVar.get(egVar2.getKey()), egVar2);
                        break;
                    }
                    dkVar2 = (dk) eiVar;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // a.ei
    public final Object fold(Object obj, jw jwVar) {
        return jwVar.invoke(this.f55a.fold(obj, jwVar), this.b);
    }

    @Override // a.ei
    public final eg get(eh ehVar) {
        mk.h(ehVar, "key");
        dk dkVar = this;
        while (true) {
            eg egVar = dkVar.b.get(ehVar);
            if (egVar != null) {
                return egVar;
            }
            ei eiVar = dkVar.f55a;
            if (!(eiVar instanceof dk)) {
                return eiVar.get(ehVar);
            }
            dkVar = (dk) eiVar;
        }
    }

    public final int hashCode() {
        return this.b.hashCode() + this.f55a.hashCode();
    }

    @Override // a.ei
    public final ei minusKey(eh ehVar) {
        mk.h(ehVar, "key");
        eg egVar = this.b;
        eg egVar2 = egVar.get(ehVar);
        ei eiVar = this.f55a;
        if (egVar2 != null) {
            return eiVar;
        }
        ei eiVarMinusKey = eiVar.minusKey(ehVar);
        return eiVarMinusKey == eiVar ? this : eiVarMinusKey == hb.f109a ? egVar : new dk(eiVarMinusKey, egVar);
    }

    @Override // a.ei
    public final ei plus(ei eiVar) {
        return vs.c(this, eiVar);
    }

    public final String toString() {
        return "[" + ((String) fold("", di.b)) + ']';
    }
}
