package a;

import android.util.Log;
import androidx.core.util.Pools;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class fk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f84a;
    public final List b;
    public final sp c;
    public final Pools.Pool d;
    public final String e;

    public fk(Class cls, Class cls2, Class cls3, List list, sp spVar, Pools.Pool pool) {
        this.f84a = cls;
        this.b = list;
        this.c = spVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final a.sf a(int r17, int r18, a.bd r19, a.fa r20, a.qu r21) {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fk.a(int, int, a.bd, a.fa, a.qu):a.sf");
    }

    public final sf b(fa faVar, int i, int i2, qu quVar, List list) throws lc {
        List list2 = this.b;
        int size = list2.size();
        sf sfVarA = null;
        for (int i3 = 0; i3 < size; i3++) {
            si siVar = (si) list2.get(i3);
            try {
                if (siVar.b(faVar.g(), quVar)) {
                    sfVarA = siVar.a(faVar.g(), i, i2, quVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Objects.toString(siVar);
                }
                list.add(e);
            }
            if (sfVarA != null) {
                break;
            }
        }
        if (sfVarA != null) {
            return sfVarA;
        }
        throw new lc(this.e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f84a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }
}
