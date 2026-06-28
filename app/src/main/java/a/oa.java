package a;

import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class oa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pools.Pool f202a;
    public final List b;
    public final String c;

    public oa(Class cls, Class cls2, Class cls3, List list, Pools.Pool pool) {
        this.f202a = pool;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.b = list;
        this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final sf a(int i, int i2, bd bdVar, fa faVar, qu quVar) {
        Pools.Pool pool = this.f202a;
        Object objAcquire = pool.acquire();
        mk.f(objAcquire, "Argument must not be null");
        List list = (List) objAcquire;
        try {
            List list2 = this.b;
            int size = list2.size();
            sf sfVarA = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    sfVarA = ((fk) list2.get(i3)).a(i, i2, bdVar, faVar, quVar);
                } catch (lc e) {
                    list.add(e);
                }
                if (sfVarA != null) {
                    break;
                }
            }
            if (sfVarA != null) {
                return sfVarA;
            }
            throw new lc(this.c, new ArrayList(list));
        } finally {
            pool.release(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }
}
