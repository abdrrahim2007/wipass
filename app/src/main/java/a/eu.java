package a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class eu implements nl {
    public final nl b;
    public final nl c;

    public eu(nl nlVar, nl nlVar2) {
        this.b = nlVar;
        this.c = nlVar2;
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
        this.c.b(messageDigest);
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof eu) {
            eu euVar = (eu) obj;
            if (this.b.equals(euVar.b) && this.c.equals(euVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }
}
