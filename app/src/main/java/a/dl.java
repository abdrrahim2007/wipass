package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f56a;
    public final mn b;
    public final js c;
    public final Object d;
    public final Throwable e;

    public dl(Object obj, mn mnVar, js jsVar, Object obj2, Throwable th) {
        this.f56a = obj;
        this.b = mnVar;
        this.c = jsVar;
        this.d = obj2;
        this.e = th;
    }

    public static dl a(dl dlVar, mn mnVar, CancellationException cancellationException, int i) {
        Object obj = dlVar.f56a;
        if ((i & 2) != 0) {
            mnVar = dlVar.b;
        }
        mn mnVar2 = mnVar;
        js jsVar = dlVar.c;
        Object obj2 = dlVar.d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = dlVar.e;
        }
        dlVar.getClass();
        return new dl(obj, mnVar2, jsVar, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dl)) {
            return false;
        }
        dl dlVar = (dl) obj;
        return mk.a(this.f56a, dlVar.f56a) && mk.a(this.b, dlVar.b) && mk.a(this.c, dlVar.c) && mk.a(this.d, dlVar.d) && mk.a(this.e, dlVar.e);
    }

    public final int hashCode() {
        Object obj = this.f56a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        mn mnVar = this.b;
        int iHashCode2 = (iHashCode + (mnVar == null ? 0 : mnVar.hashCode())) * 31;
        js jsVar = this.c;
        int iHashCode3 = (iHashCode2 + (jsVar == null ? 0 : jsVar.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f56a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    public /* synthetic */ dl(Object obj, mn mnVar, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : mnVar, null, null, (i & 16) != 0 ? null : cancellationException);
    }
}
