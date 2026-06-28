package a;

/* JADX INFO: loaded from: classes.dex */
public final class or extends oq {
    public hq d;

    @Override // a.oq
    public final int b(Object obj) {
        sf sfVar = (sf) obj;
        if (sfVar == null) {
            return 1;
        }
        return sfVar.a();
    }

    @Override // a.oq
    public final void c(Object obj, Object obj2) {
        sf sfVar = (sf) obj2;
        hq hqVar = this.d;
        if (hqVar == null || sfVar == null) {
            return;
        }
        hqVar.e.a(sfVar, true);
    }
}
