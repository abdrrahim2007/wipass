package a;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class cp extends bl {
    public static final byte[] b = "a.cp".getBytes(nl.f194a);

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // a.bl
    public final Bitmap c(bj bjVar, Bitmap bitmap, int i, int i2) {
        Paint paint = vq.f333a;
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            Log.isLoggable("TransformationUtils", 2);
            return vq.b(bjVar, bitmap, i, i2);
        }
        Log.isLoggable("TransformationUtils", 2);
        return bitmap;
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        return obj instanceof cp;
    }

    @Override // a.nl
    public final int hashCode() {
        return -670243078;
    }
}
