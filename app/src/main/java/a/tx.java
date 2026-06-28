package a;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class tx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f307a;

    static {
        int[] iArr = new int[Bitmap.Config.values().length];
        f307a = iArr;
        try {
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f307a[Bitmap.Config.RGB_565.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f307a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f307a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
