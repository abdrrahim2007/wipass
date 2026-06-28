package a;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class oo implements bj {
    public static final Bitmap.Config f = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tz f214a;
    public final Set b;
    public final kn c;
    public final long d;
    public long e;

    public oo(long j) {
        tz tzVar = new tz();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.d = j;
        this.f214a = tzVar;
        this.b = setUnmodifiableSet;
        this.c = new kn(6);
    }

    public final synchronized Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapB;
        try {
            if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapB = this.f214a.b(i, i2, config != null ? config : f);
            if (bitmapB != null) {
                long j = this.e;
                this.f214a.getClass();
                this.e = j - ((long) wh.c(bitmapB));
                this.c.getClass();
                bitmapB.setHasAlpha(true);
                bitmapB.setPremultiplied(true);
            } else if (Log.isLoggable("LruBitmapPool", 3)) {
                this.f214a.getClass();
                tz.c(wh.d(config) * i * i2, config);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.f214a.getClass();
                tz.c(wh.d(config) * i * i2, config);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.f214a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapB;
    }

    public final synchronized void b(long j) {
        while (this.e > j) {
            tz tzVar = this.f214a;
            Bitmap bitmap = (Bitmap) tzVar.b.j();
            if (bitmap != null) {
                tzVar.a(Integer.valueOf(wh.c(bitmap)), bitmap);
            }
            if (bitmap == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Objects.toString(this.f214a);
                }
                this.e = 0L;
                return;
            }
            this.c.getClass();
            long j2 = this.e;
            this.f214a.getClass();
            this.e = j2 - ((long) wh.c(bitmap));
            if (Log.isLoggable("LruBitmapPool", 3)) {
                this.f214a.getClass();
                tz.c(wh.c(bitmap), bitmap.getConfig());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Objects.toString(this.f214a);
            }
            bitmap.recycle();
        }
    }

    @Override // a.bj
    public final Bitmap h(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA = a(i, i2, config);
        if (bitmapA != null) {
            return bitmapA;
        }
        if (config == null) {
            config = f;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // a.bj
    public final Bitmap j(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapA = a(i, i2, config);
        if (bitmapA != null) {
            bitmapA.eraseColor(0);
            return bitmapA;
        }
        if (config == null) {
            config = f;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // a.bj
    public final synchronized void k(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f214a.getClass();
                if (wh.c(bitmap) <= this.d && this.b.contains(bitmap.getConfig())) {
                    this.f214a.getClass();
                    int iC = wh.c(bitmap);
                    this.f214a.e(bitmap);
                    this.c.getClass();
                    this.e += (long) iC;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.f214a.getClass();
                        tz.c(wh.c(bitmap), bitmap.getConfig());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Objects.toString(this.f214a);
                    }
                    b(this.d);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.f214a.getClass();
                tz.c(wh.c(bitmap), bitmap.getConfig());
                bitmap.isMutable();
                this.b.contains(bitmap.getConfig());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // a.bj
    public final void o(int i) {
        Log.isLoggable("LruBitmapPool", 3);
        if (i >= 40 || i >= 20) {
            s();
        } else if (i >= 20 || i == 15) {
            b(this.d / 2);
        }
    }

    @Override // a.bj
    public final void s() {
        Log.isLoggable("LruBitmapPool", 3);
        b(0L);
    }
}
