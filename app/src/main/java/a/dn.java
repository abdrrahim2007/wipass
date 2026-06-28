package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class dn {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(dn.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f58a;

    public dn(boolean z, Throwable th) {
        this.f58a = th;
        this._handled = z ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f58a + ']';
    }
}
