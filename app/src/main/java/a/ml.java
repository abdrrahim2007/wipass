package a;

/* JADX INFO: loaded from: classes.dex */
public final class ml extends sr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f185a;
    public final /* synthetic */ jw b;
    public final /* synthetic */ ec c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ml(ec ecVar, ec ecVar2, jw jwVar) {
        super(ecVar);
        this.b = jwVar;
        this.c = ecVar2;
    }

    @Override // a.az
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.f185a;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f185a = 2;
            pd.h(obj);
            return obj;
        }
        this.f185a = 1;
        pd.h(obj);
        jw jwVar = this.b;
        mk.d(jwVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
        vs.b(jwVar);
        return jwVar.invoke(this.c, this);
    }
}
