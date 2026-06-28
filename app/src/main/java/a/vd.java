package a;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class vd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f325a = vs.e(100000, 1, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.resolution.ns");
    public static final int b;
    public static final int c;
    public static final long d;
    public static final ee e;
    public static final vb f;
    public static final vb g;

    static {
        int i = ux.f320a;
        if (i < 2) {
            i = 2;
        }
        b = vs.f("kotlinx.coroutines.scheduler.core.pool.size", i, 8);
        c = vs.f("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 4);
        d = TimeUnit.SECONDS.toNanos(vs.e(60L, 1L, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        e = ee.f;
        f = new vb(0);
        g = new vb(1);
    }
}
