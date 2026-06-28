package a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class uz implements nt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f321a = Collections.newSetFromMap(new WeakHashMap());

    @Override // a.nt
    public final void d() {
        ArrayList arrayListE = wh.e(this.f321a);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((uy) obj).d();
        }
    }

    @Override // a.nt
    public final void j() {
        ArrayList arrayListE = wh.e(this.f321a);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((uy) obj).j();
        }
    }

    @Override // a.nt
    public final void onStart() {
        ArrayList arrayListE = wh.e(this.f321a);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            ((uy) obj).onStart();
        }
    }
}
