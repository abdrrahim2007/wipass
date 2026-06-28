package a;

/* JADX INFO: loaded from: classes.dex */
public final class fz extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ei f91a;

    public fz(ei eiVar) {
        this.f91a = eiVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f91a.toString();
    }
}
