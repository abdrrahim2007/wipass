package a;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f312a;
    public final ah c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public final int[] j;
    public int k;
    public kv l;
    public Bitmap m;
    public final boolean n;
    public int o;
    public final int p;
    public final int q;
    public final int r;
    public Boolean s;
    public final int[] b = new int[256];
    public Bitmap.Config t = Bitmap.Config.ARGB_8888;

    public ue(ah ahVar, kv kvVar, ByteBuffer byteBuffer, int i) {
        this.c = ahVar;
        this.l = new kv();
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int iHighestOneBit = Integer.highestOneBit(i);
                int i2 = 0;
                this.o = 0;
                this.l = kvVar;
                this.k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.d.order(ByteOrder.LITTLE_ENDIAN);
                this.n = false;
                ArrayList arrayList = kvVar.e;
                int size = arrayList.size();
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj = arrayList.get(i2);
                    i2++;
                    if (((kq) obj).g == 3) {
                        this.n = true;
                        break;
                    }
                }
                this.p = iHighestOneBit;
                int i3 = kvVar.f;
                this.r = i3 / iHighestOneBit;
                int i4 = kvVar.g;
                this.q = i4 / iHighestOneBit;
                int i5 = i3 * i4;
                on onVar = (on) this.c.c;
                this.i = onVar == null ? new byte[i5] : (byte[]) onVar.c(byte[].class, i5);
                ah ahVar2 = this.c;
                int i6 = this.r * this.q;
                on onVar2 = (on) ahVar2.c;
                this.j = onVar2 == null ? new int[i6] : (int[]) onVar2.c(int[].class, i6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap a() {
        Boolean bool = this.s;
        Bitmap bitmapH = ((bj) this.c.b).h(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapH.setHasAlpha(true);
        return bitmapH;
    }

    public final synchronized Bitmap b() {
        try {
            if (this.l.c <= 0 || this.k < 0) {
                if (Log.isLoggable("ue", 3)) {
                    int i = this.l.c;
                }
                this.o = 1;
            }
            int i2 = this.o;
            if (i2 != 1 && i2 != 2) {
                this.o = 0;
                if (this.e == null) {
                    on onVar = (on) this.c.c;
                    this.e = onVar == null ? new byte[255] : (byte[]) onVar.c(byte[].class, 255);
                }
                kq kqVar = (kq) this.l.e.get(this.k);
                int i3 = this.k - 1;
                kq kqVar2 = i3 >= 0 ? (kq) this.l.e.get(i3) : null;
                int[] iArr = kqVar.k;
                if (iArr == null) {
                    iArr = this.l.f156a;
                }
                this.f312a = iArr;
                if (iArr == null) {
                    Log.isLoggable("ue", 3);
                    this.o = 1;
                    return null;
                }
                if (kqVar.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.f312a = iArr2;
                    iArr2[kqVar.h] = 0;
                    if (kqVar.g == 2 && this.k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return d(kqVar, kqVar2);
            }
            Log.isLoggable("ue", 3);
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void c(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01dc A[PHI: r5
  0x01dc: PHI (r5v44 int) = (r5v38 int), (r5v46 int), (r5v46 int) binds: [B:93:0x01c8, B:95:0x01d3, B:96:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v31, types: [short] */
    /* JADX WARN: Type inference failed for: r6v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.Bitmap d(a.kq r36, a.kq r37) {
        /*
            Method dump skipped, instruction units count: 1042
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ue.d(a.kq, a.kq):android.graphics.Bitmap");
    }
}
