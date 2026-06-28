package a;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class lv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f174a;

    static {
        int[] iArr = new int[ImageHeaderParser$ImageType.values().length];
        f174a = iArr;
        try {
            iArr[ImageHeaderParser$ImageType.WEBP.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f174a[ImageHeaderParser$ImageType.WEBP_A.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f174a[ImageHeaderParser$ImageType.ANIMATED_WEBP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
