package a;

/* JADX INFO: loaded from: classes.dex */
public final class ha implements ly {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f108a;

    public ha(boolean z) {
        this.f108a = z;
    }

    @Override // a.ly
    public final boolean a() {
        return this.f108a;
    }

    @Override // a.ly
    public final ql c() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f108a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
