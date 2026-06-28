package a;

/* JADX INFO: loaded from: classes.dex */
public final class fw extends sy {
    public static final fw b;

    static {
        int i = vd.b;
        int i2 = vd.c;
        long j = vd.d;
        fw fwVar = new fw();
        fwVar.f290a = new eo(j, i, i2);
        b = fwVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // a.el
    public final String toString() {
        return "Dispatchers.Default";
    }
}
