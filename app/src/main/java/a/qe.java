package a;

/* JADX INFO: loaded from: classes.dex */
public final class qe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class f250a;
    public Class b;
    public Class c;

    public qe(Class cls, Class cls2, Class cls3) {
        this.f250a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qe.class != obj.getClass()) {
            return false;
        }
        qe qeVar = (qe) obj;
        return this.f250a.equals(qeVar.f250a) && this.b.equals(qeVar.b) && wh.b(this.c, qeVar.c);
    }

    public final int hashCode() {
        int iHashCode = (this.b.hashCode() + (this.f250a.hashCode() * 31)) * 31;
        Class cls = this.c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f250a + ", second=" + this.b + '}';
    }
}
