package a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class gx implements vo {
    public final vo b;
    public final boolean c;

    public gx(vo voVar, boolean z) {
        this.b = voVar;
        this.c = z;
    }

    @Override // a.vo
    public final sf a(Context context, sf sfVar, int i, int i2) {
        bj bjVar = com.bumptech.glide.a.a(context).f395a;
        Drawable drawable = (Drawable) sfVar.get();
        bk bkVarB = kz.b(bjVar, drawable, i, i2);
        if (bkVarB != null) {
            sf sfVarA = this.b.a(context, bkVarB, i, i2);
            if (!sfVarA.equals(bkVarB)) {
                return new bk(context.getResources(), sfVarA);
            }
            sfVarA.recycle();
            return sfVar;
        }
        if (!this.c) {
            return sfVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        this.b.b(messageDigest);
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof gx) {
            return this.b.equals(((gx) obj).b);
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        return this.b.hashCode();
    }
}
