package a;

/* JADX INFO: loaded from: classes.dex */
public final class wa extends el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wa f341a = new wa();

    @Override // a.el
    public final void dispatch(ei eiVar, Runnable runnable) {
        fw fwVar = fw.b;
        fwVar.f290a.b(runnable, vd.g, false);
    }

    @Override // a.el
    public final void dispatchYield(ei eiVar, Runnable runnable) {
        fw fwVar = fw.b;
        fwVar.f290a.b(runnable, vd.g, true);
    }
}
