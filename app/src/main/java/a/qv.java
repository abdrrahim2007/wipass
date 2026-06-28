package a;

/* JADX INFO: loaded from: classes.dex */
public final class qv implements cv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f258a;

    public qv(Class cls) {
        mk.h(cls, "jClass");
        this.f258a = cls;
    }

    @Override // a.cv
    public final Class a() {
        return this.f258a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof qv) {
            return mk.a(this.f258a, ((qv) obj).f258a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f258a.hashCode();
    }

    public final String toString() {
        return this.f258a.toString() + " (Kotlin reflection is not available)";
    }
}
