package a;

/* JADX INFO: loaded from: classes.dex */
public final class vc extends va {
    public final Runnable c;

    public vc(Runnable runnable, long j, vb vbVar) {
        super(j, vbVar);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.run();
        } finally {
            this.b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(pd.d(runnable));
        sb.append(", ");
        sb.append(this.f323a);
        sb.append(", ");
        sb.append(this.b);
        sb.append(']');
        return sb.toString();
    }
}
