package a;

/* JADX INFO: loaded from: classes.dex */
public final class cj extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public cj(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
