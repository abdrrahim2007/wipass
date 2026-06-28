package a;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ui implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f315a;
    public final cb b;
    public final on c;

    public ui(ArrayList arrayList, cb cbVar, on onVar) {
        this.f315a = arrayList;
        this.b = cbVar;
        this.c = onVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // a.si
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final a.sf a(java.lang.Object r6, int r7, int r8, a.qu r9) {
        /*
            r5 = this;
            java.io.InputStream r6 = (java.io.InputStream) r6
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 16384(0x4000, float:2.2959E-41)
            r0.<init>(r1)
            r2 = 0
            byte[] r1 = new byte[r1]     // Catch: java.io.IOException -> L20
        Lc:
            int r3 = r6.read(r1)     // Catch: java.io.IOException -> L20
            r4 = -1
            if (r3 == r4) goto L18
            r4 = 0
            r0.write(r1, r4, r3)     // Catch: java.io.IOException -> L20
            goto Lc
        L18:
            r0.flush()     // Catch: java.io.IOException -> L20
            byte[] r6 = r0.toByteArray()
            goto L27
        L20:
            java.lang.String r6 = "StreamGifDecoder"
            r0 = 5
            android.util.Log.isLoggable(r6, r0)
            r6 = r2
        L27:
            if (r6 != 0) goto L2a
            goto L34
        L2a:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            a.cb r0 = r5.b
            a.sf r2 = r0.a(r6, r7, r8, r9)
        L34:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ui.a(java.lang.Object, int, int, a.qu):a.sf");
    }

    @Override // a.si
    public final boolean b(Object obj, qu quVar) {
        return !((Boolean) quVar.c(kx.b)).booleanValue() && bs.c(this.f315a, (InputStream) obj, this.c) == ImageHeaderParser$ImageType.GIF;
    }
}
