package a;

/* JADX INFO: loaded from: classes.dex */
public final class gr {
    public static final gr b = new gr(2);
    public static final gr c = new gr(0);
    public static final gr d;
    public static final gr e;
    public static final gr f;
    public static final qt g;
    public static final boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f103a;

    static {
        gr grVar = new gr(1);
        d = grVar;
        e = new gr(3);
        f = grVar;
        g = qt.a(grVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        h = true;
    }

    public /* synthetic */ gr(int i) {
        this.f103a = i;
    }

    public final int a(int i, int i2, int i3, int i4) {
        switch (this.f103a) {
            case 0:
                if (b(i, i2, i3, i4) != 1.0f) {
                    break;
                }
                break;
            case 2:
                if (h) {
                }
                break;
        }
        return 2;
    }

    public final float b(int i, int i2, int i3, int i4) {
        switch (this.f103a) {
            case 0:
                return Math.min(1.0f, b.b(i, i2, i3, i4));
            case 1:
                return Math.max(i3 / i, i4 / i2);
            case 2:
                if (h) {
                    return Math.min(i3 / i, i4 / i2);
                }
                if (Math.max(i2 / i4, i / i3) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
