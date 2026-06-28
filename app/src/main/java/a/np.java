package a;

/* JADX INFO: loaded from: classes.dex */
public final class np {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f196a;

    public np(String str) {
        this.f196a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof np) {
            return this.f196a.equals(((np) obj).f196a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f196a.hashCode();
    }

    public final String toString() {
        return pt.j(new StringBuilder("StringHeaderFactory{value='"), this.f196a, "'}");
    }
}
