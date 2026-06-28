package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class cb implements si {
    public static final ee f = new ee(16);
    public static final ca g = new ca(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f40a;
    public final ArrayList b;
    public final ah e;
    public final ee d = f;
    public final ca c = g;

    public cb(Context context, ArrayList arrayList, bj bjVar, on onVar) {
        this.f40a = context.getApplicationContext();
        this.b = arrayList;
        this.e = new ah(3, bjVar, onVar);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:25:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // a.si
    public final a.sf a(java.lang.Object r8, int r9, int r10, a.qu r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            a.ca r8 = r7.c
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.f39a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            a.kw r0 = (a.kw) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            a.kw r0 = new a.kw     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.f157a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            a.kv r0 = new a.kv     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.c = r0     // Catch: java.lang.Throwable -> L54
            r5.d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            a.ko r8 = r1.c(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            a.ca r9 = r1.c
            r9.a(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            a.ca r9 = r1.c
            r9.a(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: a.cb.a(java.lang.Object, int, int, a.qu):a.sf");
    }

    @Override // a.si
    public final boolean b(Object obj, qu quVar) {
        return !((Boolean) quVar.c(kx.b)).booleanValue() && bs.d(this.b, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    public final ko c(ByteBuffer byteBuffer, int i, int i2, kw kwVar, qu quVar) {
        int i3 = oj.f211a;
        SystemClock.elapsedRealtimeNanos();
        try {
            kv kvVarB = kwVar.b();
            if (kvVarB.c > 0 && kvVarB.b == 0) {
                Bitmap.Config config = quVar.c(kx.f158a) == fg.b ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iMin = Math.min(kvVarB.g / i2, kvVarB.f / i);
                int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
                Log.isLoggable("BufferGifDecoder", 2);
                ee eeVar = this.d;
                ah ahVar = this.e;
                eeVar.getClass();
                ue ueVar = new ue(ahVar, kvVarB, byteBuffer, iMax);
                ueVar.c(config);
                ueVar.k = (ueVar.k + 1) % ueVar.l.c;
                Bitmap bitmapB = ueVar.b();
                if (bitmapB != null) {
                    ko koVar = new ko(new km(new kl(new ku(com.bumptech.glide.a.a(this.f40a), ueVar, i, i2, bitmapB))), 0);
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        SystemClock.elapsedRealtimeNanos();
                    }
                    return koVar;
                }
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    SystemClock.elapsedRealtimeNanos();
                    return null;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
        }
    }
}
