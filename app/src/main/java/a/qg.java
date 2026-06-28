package a;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class qg implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f252a;
    public final Pools.Pool b;

    public qg(ArrayList arrayList, im imVar) {
        this.f252a = arrayList;
        this.b = imVar;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        ArrayList arrayList = this.f252a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            if (((qa) obj2).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        pz pzVarB;
        ArrayList arrayList = this.f252a;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        nl nlVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            qa qaVar = (qa) arrayList.get(i3);
            if (qaVar.a(obj) && (pzVarB = qaVar.b(obj, i, i2, quVar)) != null) {
                nlVar = pzVarB.f247a;
                arrayList2.add(pzVarB.c);
            }
        }
        if (arrayList2.isEmpty() || nlVar == null) {
            return null;
        }
        return new pz(nlVar, new qf(arrayList2, this.b));
    }

    public final String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f252a.toArray()) + '}';
    }
}
