package a;

/* JADX INFO: loaded from: classes.dex */
public final class uh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f314a;

    public final void a() {
        if (this.f314a) {
            throw new IllegalStateException("Already released");
        }
    }
}
