package a;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class fb implements fa, qb, fq, hi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f76a;
    public final Object b;

    public /* synthetic */ fb(int i, Object obj) {
        this.f76a = i;
        this.b = obj;
    }

    @Override // a.fa
    public void b() {
        switch (this.f76a) {
            case 0:
                break;
            default:
                ((ro) this.b).b();
                break;
        }
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        switch (this.f76a) {
            case 1:
                return new bv(1, (ee) this.b);
            default:
                return new lq((fb) this.b);
        }
    }

    @Override // a.fq
    public int d(byte[] bArr, int i) throws fp {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && (i3 = ((InputStream) this.b).read(bArr, i2, i - i2)) != -1) {
            i2 += i3;
        }
        if (i2 == 0 && i3 == -1) {
            throw new fp();
        }
        return i2;
    }

    @Override // a.fq
    public short e() throws IOException {
        int i = ((InputStream) this.b).read();
        if (i != -1) {
            return (short) i;
        }
        throw new fp();
    }

    @Override // a.fq
    public int f() {
        return (e() << 8) | e();
    }

    @Override // a.fa
    public Object g() {
        switch (this.f76a) {
            case 0:
                return this.b;
            default:
                ro roVar = (ro) this.b;
                roVar.reset();
                return roVar;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(2:29|3)|(5:38|4|(1:6)(1:40)|28|19)|10|36|11|12|28|19) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // a.hi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean i(java.lang.Object r5, java.io.File r6, a.qu r7) throws java.lang.Throwable {
        /*
            r4 = this;
            java.io.InputStream r5 = (java.io.InputStream) r5
            java.lang.Object r7 = r4.b
            a.on r7 = (a.on) r7
            r0 = 65536(0x10000, float:9.1835E-41)
            java.lang.Class<byte[]> r1 = byte[].class
            java.lang.Object r0 = r7.c(r1, r0)
            byte[] r0 = (byte[]) r0
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
        L17:
            int r6 = r5.read(r0)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            r2 = -1
            if (r6 == r2) goto L27
            r3.write(r0, r1, r6)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            goto L17
        L22:
            r5 = move-exception
            r2 = r3
            goto L43
        L25:
            r2 = r3
            goto L34
        L27:
            r3.close()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L25
            r3.close()     // Catch: java.io.IOException -> L2d
        L2d:
            r7.g(r0)
            r1 = 1
            goto L42
        L32:
            r5 = move-exception
            goto L43
        L34:
            java.lang.String r5 = "StreamEncoder"
            r6 = 3
            android.util.Log.isLoggable(r5, r6)     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L3f
            r2.close()     // Catch: java.io.IOException -> L3f
        L3f:
            r7.g(r0)
        L42:
            return r1
        L43:
            if (r2 == 0) goto L48
            r2.close()     // Catch: java.io.IOException -> L48
        L48:
            r7.g(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fb.i(java.lang.Object, java.io.File, a.qu):boolean");
    }

    @Override // a.fq
    public long skip(long j) throws IOException {
        InputStream inputStream = (InputStream) this.b;
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j - j2;
    }

    public String toString() {
        switch (this.f76a) {
            case 11:
                return "<" + ((String) this.b) + '>';
            default:
                return super.toString();
        }
    }

    public fb(InputStream inputStream, on onVar) {
        this.f76a = 6;
        ro roVar = new ro(inputStream, onVar);
        this.b = roVar;
        roVar.mark(5242880);
    }

    public fb(fc fcVar) {
        this.f76a = 4;
        this.b = Collections.unmodifiableMap(new HashMap(fcVar.f77a));
    }

    public fb(Context context) {
        this.f76a = 7;
        this.b = new ga(context, 3);
    }

    public fb(int i) {
        this.f76a = i;
        switch (i) {
            case 5:
                this.b = new fb(9);
                break;
            case 9:
                this.b = new px(500L);
                break;
            default:
                this.b = new ee(17);
                break;
        }
    }

    private final void a() {
    }
}
