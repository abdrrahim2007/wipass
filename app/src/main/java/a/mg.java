package a;

/* JADX INFO: loaded from: classes.dex */
public final class mg extends me implements cx {
    public static final mg d = new mg(1, 0, 1);

    public final boolean equals(Object obj) {
        if (!(obj instanceof mg)) {
            return false;
        }
        if (isEmpty() && ((mg) obj).isEmpty()) {
            return true;
        }
        mg mgVar = (mg) obj;
        return this.f179a == mgVar.f179a && this.b == mgVar.b;
    }

    @Override // a.cx
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.b);
    }

    @Override // a.cx
    public final Comparable getStart() {
        return Integer.valueOf(this.f179a);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f179a * 31) + this.b;
    }

    public final boolean isEmpty() {
        return this.f179a > this.b;
    }

    public final String toString() {
        return this.f179a + ".." + this.b;
    }
}
