package a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class ty implements rc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om f308a;
    public int b;
    public Bitmap.Config c;

    public ty(om omVar) {
        this.f308a = omVar;
    }

    @Override // a.rc
    public final void a() {
        this.f308a.a(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ty) {
            ty tyVar = (ty) obj;
            if (this.b == tyVar.b && wh.b(this.c, tyVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b * 31;
        Bitmap.Config config = this.c;
        return i + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return tz.c(this.b, this.c);
    }
}
