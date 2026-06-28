package a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class sa implements dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tw f278a;
    public final /* synthetic */ sb b;

    public sa(sb sbVar, tw twVar) {
        this.b = sbVar;
        this.f278a = twVar;
    }

    @Override // a.dw
    public final void a(boolean z) {
        if (z) {
            synchronized (this.b) {
                tw twVar = this.f278a;
                ArrayList arrayListE = wh.e((Set) twVar.c);
                int size = arrayListE.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListE.get(i);
                    i++;
                    rw rwVar = (rw) obj;
                    if (!rwVar.i() && !rwVar.b()) {
                        rwVar.clear();
                        if (twVar.b) {
                            ((HashSet) twVar.d).add(rwVar);
                        } else {
                            rwVar.f();
                        }
                    }
                }
            }
        }
    }
}
