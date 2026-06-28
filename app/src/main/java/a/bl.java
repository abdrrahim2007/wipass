package a;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract class bl implements vo {
    @Override // a.vo
    public final sf a(Context context, sf sfVar, int i, int i2) {
        if (!wh.i(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        bj bjVar = com.bumptech.glide.a.a(context).f395a;
        Bitmap bitmap = (Bitmap) sfVar.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapC = c(bjVar, bitmap, i, i2);
        return bitmap.equals(bitmapC) ? sfVar : bk.c(bjVar, bitmapC);
    }

    public abstract Bitmap c(bj bjVar, Bitmap bitmap, int i, int i2);
}
