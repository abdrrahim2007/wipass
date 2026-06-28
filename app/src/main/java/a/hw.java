package a;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class hw implements nl {
    public final Object b;
    public final int c;
    public final int d;
    public final Class e;
    public final Class f;
    public final nl g;
    public final Map h;
    public final qu i;
    public int j;

    public hw(Object obj, nl nlVar, int i, int i2, Map map, Class cls, Class cls2, qu quVar) {
        mk.f(obj, "Argument must not be null");
        this.b = obj;
        this.g = nlVar;
        this.c = i;
        this.d = i2;
        mk.f(map, "Argument must not be null");
        this.h = map;
        mk.f(cls, "Resource class must not be null");
        this.e = cls;
        mk.f(cls2, "Transcode class must not be null");
        this.f = cls2;
        mk.f(quVar, "Argument must not be null");
        this.i = quVar;
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof hw) {
            hw hwVar = (hw) obj;
            if (this.b.equals(hwVar.b) && this.g.equals(hwVar.g) && this.d == hwVar.d && this.c == hwVar.c && this.h.equals(hwVar.h) && this.e.equals(hwVar.e) && this.f.equals(hwVar.f) && this.i.equals(hwVar.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = ((((this.g.hashCode() + (iHashCode * 31)) * 31) + this.c) * 31) + this.d;
            this.j = iHashCode2;
            int iHashCode3 = this.h.hashCode() + (iHashCode2 * 31);
            this.j = iHashCode3;
            int iHashCode4 = this.e.hashCode() + (iHashCode3 * 31);
            this.j = iHashCode4;
            int iHashCode5 = this.f.hashCode() + (iHashCode4 * 31);
            this.j = iHashCode5;
            this.j = this.i.b.hashCode() + (iHashCode5 * 31);
        }
        return this.j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
