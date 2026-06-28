package a;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class q {
    public static /* bridge */ /* synthetic */ ImageDecoder.Source c(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* bridge */ /* synthetic */ AnimatedImageDrawable e(Drawable drawable) {
        return (AnimatedImageDrawable) drawable;
    }

    public static /* bridge */ /* synthetic */ void r(Object obj) {
    }

    public static /* bridge */ /* synthetic */ boolean s(Drawable drawable) {
        return drawable instanceof AnimatedImageDrawable;
    }
}
