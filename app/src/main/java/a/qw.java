package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class qw implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f259a;
    public final Object b;

    public qw(Object obj, Object obj2) {
        this.f259a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        return mk.a(this.f259a, qwVar.f259a) && mk.a(this.b, qwVar.b);
    }

    public final int hashCode() {
        Object obj = this.f259a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f259a + ", " + this.b + ')';
    }
}
