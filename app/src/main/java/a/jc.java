package a;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class jc extends bl {
    public static final byte[] b = "a.jc".getBytes(nl.f194a);

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // a.bl
    public final Bitmap c(bj bjVar, Bitmap bitmap, int i, int i2) {
        return vq.b(bjVar, bitmap, i, i2);
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        return obj instanceof jc;
    }

    @Override // a.nl
    public final int hashCode() {
        return 1572326941;
    }
}
