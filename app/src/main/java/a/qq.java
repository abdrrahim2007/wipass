package a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class qq implements nl {
    public final Object b;

    public qq(Object obj) {
        mk.f(obj, "Argument must not be null");
        this.b = obj;
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(nl.f194a));
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof qq) {
            return this.b.equals(((qq) obj).b);
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }
}
