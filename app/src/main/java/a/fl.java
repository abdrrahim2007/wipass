package a;

import android.content.Context;
import android.net.ConnectivityManager;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class fl implements dx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f85a;
    public final sa b;

    public fl(Context context, sa saVar) {
        this.f85a = context.getApplicationContext();
        this.b = saVar;
    }

    @Override // a.nt
    public final void d() {
        tw twVarB = tw.b(this.f85a);
        sa saVar = this.b;
        synchronized (twVarB) {
            ((HashSet) twVarB.d).remove(saVar);
            if (twVarB.b && ((HashSet) twVarB.d).isEmpty()) {
                gh ghVar = (gh) twVarB.c;
                ((ConnectivityManager) ((hp) ghVar.c).get()).unregisterNetworkCallback((tv) ghVar.d);
                twVarB.b = false;
            }
        }
    }

    @Override // a.nt
    public final void onStart() {
        tw twVarB = tw.b(this.f85a);
        sa saVar = this.b;
        synchronized (twVarB) {
            ((HashSet) twVarB.d).add(saVar);
            twVarB.c();
        }
    }

    @Override // a.nt
    public final void j() {
    }
}
