package a;

/* JADX INFO: loaded from: classes.dex */
public final class ol implements rc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om f212a;
    public int b;
    public Class c;

    public ol(om omVar) {
        this.f212a = omVar;
    }

    @Override // a.rc
    public final void a() {
        this.f212a.a(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ol) {
            ol olVar = (ol) obj;
            if (this.b == olVar.b && this.c == olVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b * 31;
        Class cls = this.c;
        return i + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.b + "array=" + this.c + '}';
    }
}
