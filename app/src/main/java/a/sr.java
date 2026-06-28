package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class sr extends az {
    public sr(ec ecVar) {
        super(ecVar);
        if (ecVar != null && ecVar.getContext() != hb.f109a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // a.ec
    public ei getContext() {
        return hb.f109a;
    }
}
