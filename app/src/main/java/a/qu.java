package a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class qu implements nl {
    public final cg b = new cg();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); i++) {
            qt qtVar = (qt) this.b.keyAt(i);
            Object objValueAt = this.b.valueAt(i);
            qs qsVar = qtVar.b;
            if (qtVar.d == null) {
                qtVar.d = qtVar.c.getBytes(nl.f194a);
            }
            qsVar.a(qtVar.d, objValueAt, messageDigest);
        }
    }

    public final Object c(qt qtVar) {
        cg cgVar = this.b;
        return cgVar.containsKey(qtVar) ? cgVar.get(qtVar) : qtVar.f257a;
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof qu) {
            return this.b.equals(((qu) obj).b);
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.b + '}';
    }
}
