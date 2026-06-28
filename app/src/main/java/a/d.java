package a;

/* JADX INFO: loaded from: classes.dex */
public final class d extends nm implements js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f51a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
        super(1);
        this.f51a = eVar;
    }

    @Override // a.js
    public final Object invoke(Object obj) {
        return obj == this.f51a ? "(this Collection)" : String.valueOf(obj);
    }
}
