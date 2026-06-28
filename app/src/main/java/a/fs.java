package a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class fs extends ie implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fs f88a = new fs();
    public static final el b;

    static {
        wa waVar = wa.f341a;
        int i = ux.f320a;
        if (64 >= i) {
            i = 64;
        }
        b = waVar.limitedParallelism(vs.f("kotlinx.coroutines.io.parallelism", i, 12));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // a.el
    public final void dispatch(ei eiVar, Runnable runnable) {
        b.dispatch(eiVar, runnable);
    }

    @Override // a.el
    public final void dispatchYield(ei eiVar, Runnable runnable) {
        b.dispatchYield(eiVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(hb.f109a, runnable);
    }

    @Override // a.el
    public final el limitedParallelism(int i) {
        return wa.f341a.limitedParallelism(i);
    }

    @Override // a.el
    public final String toString() {
        return "Dispatchers.IO";
    }
}
