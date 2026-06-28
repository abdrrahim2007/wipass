package a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class co extends bl {
    public static final byte[] b = "a.co".getBytes(nl.f194a);

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(b);
    }

    @Override // a.bl
    public final Bitmap c(bj bjVar, Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        Paint paint = vq.f333a;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapJ = bjVar.j(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapJ.setHasAlpha(bitmap.hasAlpha());
        vq.a(bitmap, bitmapJ, matrix);
        return bitmapJ;
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        return obj instanceof co;
    }

    @Override // a.nl
    public final int hashCode() {
        return -599754482;
    }
}
