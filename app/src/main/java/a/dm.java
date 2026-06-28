package a;

/* JADX INFO: loaded from: classes.dex */
public final class dm implements ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dm f57a = new dm();

    @Override // a.ec
    public final ei getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // a.ec
    public final void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public final String toString() {
        return "This continuation is already complete";
    }
}
