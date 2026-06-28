package a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ts f124a;
    public final Executor b;

    public hs(ts tsVar, Executor executor) {
        this.f124a = tsVar;
        this.b = executor;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof hs) {
            return this.f124a.equals(((hs) obj).f124a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f124a.hashCode();
    }
}
