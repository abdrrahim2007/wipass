package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class st implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f286a;

    public st(Throwable th) {
        mk.h(th, "exception");
        this.f286a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof st) {
            return mk.a(this.f286a, ((st) obj).f286a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f286a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f286a + ')';
    }
}
