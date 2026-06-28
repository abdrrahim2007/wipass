package a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class gt {
    public static final qt f = qt.a(fg.c, "com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat");
    public static final qt g = new qt("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", null, qt.e);
    public static final qt h;
    public static final qt i;
    public static final ee j;
    public static final ArrayDeque k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bj f104a;
    public final DisplayMetrics b;
    public final on c;
    public final ArrayList d;
    public final lm e = lm.a();

    static {
        gr grVar = gr.b;
        Boolean bool = Boolean.FALSE;
        h = qt.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize");
        i = qt.a(bool, "com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");
        Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        j = new ee(21);
        Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser$ImageType.JPEG, ImageHeaderParser$ImageType.PNG_A, ImageHeaderParser$ImageType.PNG));
        char[] cArr = wh.f346a;
        k = new ArrayDeque(0);
    }

    public gt(ArrayList arrayList, DisplayMetrics displayMetrics, bj bjVar, on onVar) {
        this.d = arrayList;
        mk.f(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        mk.f(bjVar, "Argument must not be null");
        this.f104a = bjVar;
        mk.f(onVar, "Argument must not be null");
        this.c = onVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap c(a.z r4, android.graphics.BitmapFactory.Options r5, a.gs r6, a.bj r7) {
        /*
            boolean r0 = r5.inJustDecodeBounds
            if (r0 != 0) goto L20
            r6.u()
            int r0 = r4.f367a
            switch(r0) {
                case 5: goto L20;
                case 6: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L20
        Ld:
            java.lang.Object r0 = r4.b
            a.fb r0 = (a.fb) r0
            java.lang.Object r0 = r0.b
            a.ro r0 = (a.ro) r0
            monitor-enter(r0)
            byte[] r1 = r0.f271a     // Catch: java.lang.Throwable -> L1d
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1d
            r0.c = r1     // Catch: java.lang.Throwable -> L1d
            monitor-exit(r0)
            goto L20
        L1d:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1d
            throw r4
        L20:
            int r0 = r5.outWidth
            int r1 = r5.outHeight
            java.lang.String r2 = r5.outMimeType
            java.util.concurrent.locks.Lock r3 = a.vq.b
            r3.lock()
            android.graphics.Bitmap r4 = r4.d(r5)     // Catch: java.lang.IllegalArgumentException -> L33 java.lang.Throwable -> L54
            r3.unlock()
            return r4
        L33:
            r3 = move-exception
            java.io.IOException r0 = e(r3, r0, r1, r2, r5)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = "Downsampler"
            r2 = 3
            android.util.Log.isLoggable(r1, r2)     // Catch: java.lang.Throwable -> L54
            android.graphics.Bitmap r1 = r5.inBitmap     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L53
            r7.k(r1)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L54
            r1 = 0
            r5.inBitmap = r1     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L54
            android.graphics.Bitmap r4 = c(r4, r5, r6, r7)     // Catch: java.io.IOException -> L52 java.lang.Throwable -> L54
            java.util.concurrent.locks.Lock r5 = a.vq.b
            r5.unlock()
            return r4
        L52:
            throw r0     // Catch: java.lang.Throwable -> L54
        L53:
            throw r0     // Catch: java.lang.Throwable -> L54
        L54:
            r4 = move-exception
            java.util.concurrent.locks.Lock r5 = a.vq.b
            r5.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.gt.c(a.z, android.graphics.BitmapFactory$Options, a.gs, a.bj):android.graphics.Bitmap");
    }

    public static String d(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static IOException e(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + d(options.inBitmap), illegalArgumentException);
    }

    public static void f(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public final bk a(z zVar, int i2, int i3, qu quVar, gs gsVar) {
        ArrayDeque arrayDeque;
        BitmapFactory.Options options;
        byte[] bArr = (byte[]) this.c.c(byte[].class, 65536);
        synchronized (gt.class) {
            arrayDeque = k;
            synchronized (arrayDeque) {
                options = (BitmapFactory.Options) arrayDeque.poll();
            }
            if (options == null) {
                options = new BitmapFactory.Options();
                f(options);
            }
        }
        options.inTempStorage = bArr;
        fg fgVar = (fg) quVar.c(f);
        re reVar = (re) quVar.c(g);
        gr grVar = (gr) quVar.c(gr.g);
        boolean zBooleanValue = ((Boolean) quVar.c(h)).booleanValue();
        qt qtVar = i;
        try {
            bk bkVarC = bk.c(this.f104a, b(zVar, options, grVar, fgVar, reVar, quVar.c(qtVar) != null && ((Boolean) quVar.c(qtVar)).booleanValue(), i2, i3, zBooleanValue, gsVar));
            f(options);
            synchronized (arrayDeque) {
                arrayDeque.offer(options);
            }
            this.c.g(bArr);
            return bkVarC;
        } catch (Throwable th) {
            f(options);
            ArrayDeque arrayDeque2 = k;
            synchronized (arrayDeque2) {
                arrayDeque2.offer(options);
                this.c.g(bArr);
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d3  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap b(a.z r30, android.graphics.BitmapFactory.Options r31, a.gr r32, a.fg r33, a.re r34, boolean r35, int r36, int r37, boolean r38, a.gs r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.gt.b(a.z, android.graphics.BitmapFactory$Options, a.gr, a.fg, a.re, boolean, int, int, boolean, a.gs):android.graphics.Bitmap");
    }
}
