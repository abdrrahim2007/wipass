package a;

/* JADX INFO: loaded from: classes.dex */
public final class ek implements eh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nm f70a;
    public final eh b;

    /* JADX WARN: Multi-variable type inference failed */
    public ek(eh ehVar, js jsVar) {
        mk.h(ehVar, "baseKey");
        this.f70a = (nm) jsVar;
        this.b = ehVar instanceof ek ? ((ek) ehVar).b : ehVar;
    }
}
