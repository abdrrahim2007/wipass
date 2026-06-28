package a;

/* JADX INFO: loaded from: classes.dex */
public final class tu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f304a;
    public final /* synthetic */ tv b;

    public tu(tv tvVar, boolean z) {
        this.b = tvVar;
        this.f304a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        wh.a();
        gh ghVar = this.b.f305a;
        boolean z = ghVar.f97a;
        boolean z2 = this.f304a;
        ghVar.f97a = z2;
        if (z != z2) {
            ((tt) ghVar.b).a(z2);
        }
    }
}
