package a;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class kp implements vo {
    public final vo b;

    public kp(vo voVar) {
        mk.f(voVar, "Argument must not be null");
        this.b = voVar;
    }

    @Override // a.vo
    public final sf a(Context context, sf sfVar, int i, int i2) {
        km kmVar = (km) sfVar.get();
        sf bkVar = new bk(com.bumptech.glide.a.a(context).f395a, kmVar.f149a.f148a.l);
        vo voVar = this.b;
        sf sfVarA = voVar.a(context, bkVar, i, i2);
        if (!bkVar.equals(sfVarA)) {
            bkVar.recycle();
        }
        kmVar.f149a.f148a.c(voVar, (Bitmap) sfVarA.get());
        return sfVar;
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof kp) {
            return this.b.equals(((kp) obj).b);
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        return this.b.hashCode();
    }
}
