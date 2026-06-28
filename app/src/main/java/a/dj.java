package a;

/* JADX INFO: loaded from: classes.dex */
public final class dj extends nm implements jw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ei[] f54a;
    public final /* synthetic */ rq b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(ei[] eiVarArr, rq rqVar) {
        super(2);
        this.f54a = eiVarArr;
        this.b = rqVar;
    }

    @Override // a.jw
    public final Object invoke(Object obj, Object obj2) {
        eg egVar = (eg) obj2;
        mk.h((vx) obj, "<anonymous parameter 0>");
        mk.h(egVar, "element");
        rq rqVar = this.b;
        int i = rqVar.f273a;
        rqVar.f273a = i + 1;
        this.f54a[i] = egVar;
        return vx.f338a;
    }
}
