package a;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class nu implements nt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f198a;
    public final /* synthetic */ ah b;

    public nu(ah ahVar, Lifecycle lifecycle) {
        this.b = ahVar;
        this.f198a = lifecycle;
    }

    @Override // a.nt
    public final void j() {
        ((HashMap) this.b.b).remove(this.f198a);
    }

    @Override // a.nt
    public final void d() {
    }

    @Override // a.nt
    public final void onStart() {
    }
}
