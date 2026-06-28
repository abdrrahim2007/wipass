package a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class le implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f164a;
    public final String b;
    public final ee c;
    public final boolean d;
    public final AtomicInteger e;

    public le(x xVar, String str, boolean z) {
        ee eeVar = ee.d;
        this.e = new AtomicInteger();
        this.f164a = xVar;
        this.b = str;
        this.c = eeVar;
        this.d = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        iz izVar = new iz(1, this, runnable);
        this.f164a.getClass();
        ld ldVar = new ld(izVar);
        ldVar.setName("glide-" + this.b + "-thread-" + this.e.getAndIncrement());
        return ldVar;
    }
}
