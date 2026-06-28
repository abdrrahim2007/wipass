package a;

import android.util.Log;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class kw {
    public ByteBuffer b;
    public kv c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f157a = new byte[256];
    public int d = 0;

    public final boolean a() {
        return this.c.b != 0;
    }

    public final kv b() {
        byte[] bArr;
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (a()) {
            return this.c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) c());
        }
        if (sb.toString().startsWith("GIF")) {
            this.c.f = this.b.getShort();
            this.c.g = this.b.getShort();
            int iC = c();
            kv kvVar = this.c;
            kvVar.h = (iC & 128) != 0;
            kvVar.i = (int) Math.pow(2.0d, (iC & 7) + 1);
            this.c.j = c();
            kv kvVar2 = this.c;
            c();
            kvVar2.getClass();
            if (this.c.h && !a()) {
                kv kvVar3 = this.c;
                kvVar3.f156a = e(kvVar3.i);
                kv kvVar4 = this.c;
                kvVar4.k = kvVar4.f156a[kvVar4.j];
            }
        } else {
            this.c.b = 1;
        }
        if (!a()) {
            boolean z = false;
            while (!z && !a() && this.c.c <= Integer.MAX_VALUE) {
                int iC2 = c();
                if (iC2 == 33) {
                    int iC3 = c();
                    if (iC3 == 1) {
                        f();
                    } else if (iC3 == 249) {
                        this.c.d = new kq();
                        c();
                        int iC4 = c();
                        kq kqVar = this.c.d;
                        int i2 = (iC4 & 28) >> 2;
                        kqVar.g = i2;
                        if (i2 == 0) {
                            kqVar.g = 1;
                        }
                        kqVar.f = (iC4 & 1) != 0;
                        short s = this.b.getShort();
                        if (s < 2) {
                            s = 10;
                        }
                        kq kqVar2 = this.c.d;
                        kqVar2.i = s * 10;
                        kqVar2.h = c();
                        c();
                    } else if (iC3 == 254) {
                        f();
                    } else if (iC3 != 255) {
                        f();
                    } else {
                        d();
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        while (true) {
                            bArr = this.f157a;
                            if (i3 >= 11) {
                                break;
                            }
                            sb2.append((char) bArr[i3]);
                            i3++;
                        }
                        if (sb2.toString().equals("NETSCAPE2.0")) {
                            do {
                                d();
                                if (bArr[0] == 1) {
                                    byte b = bArr[1];
                                    byte b2 = bArr[2];
                                    this.c.getClass();
                                }
                                if (this.d > 0) {
                                }
                            } while (!a());
                        } else {
                            f();
                        }
                    }
                } else if (iC2 == 44) {
                    kv kvVar5 = this.c;
                    if (kvVar5.d == null) {
                        kvVar5.d = new kq();
                    }
                    kvVar5.d.f152a = this.b.getShort();
                    this.c.d.b = this.b.getShort();
                    this.c.d.c = this.b.getShort();
                    this.c.d.d = this.b.getShort();
                    int iC5 = c();
                    boolean z2 = (iC5 & 128) != 0;
                    int iPow = (int) Math.pow(2.0d, (iC5 & 7) + 1);
                    kq kqVar3 = this.c.d;
                    kqVar3.e = (iC5 & 64) != 0;
                    if (z2) {
                        kqVar3.k = e(iPow);
                    } else {
                        kqVar3.k = null;
                    }
                    this.c.d.j = this.b.position();
                    c();
                    f();
                    if (!a()) {
                        kv kvVar6 = this.c;
                        kvVar6.c++;
                        kvVar6.e.add(kvVar6.d);
                    }
                } else if (iC2 != 59) {
                    this.c.b = 1;
                } else {
                    z = true;
                }
            }
            kv kvVar7 = this.c;
            if (kvVar7.c < 0) {
                kvVar7.b = 1;
            }
        }
        return this.c;
    }

    public final int c() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void d() {
        int iC = c();
        this.d = iC;
        if (iC <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            try {
                int i2 = this.d;
                if (i >= i2) {
                    return;
                }
                int i3 = i2 - i;
                this.b.get(this.f157a, i, i3);
                i += i3;
            } catch (Exception unused) {
                Log.isLoggable("GifHeaderParser", 3);
                this.c.b = 1;
                return;
            }
        }
    }

    public final int[] e(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = bArr[i3] & 255;
                int i5 = i3 + 2;
                int i6 = bArr[i3 + 1] & 255;
                i3 += 3;
                int i7 = i2 + 1;
                iArr[i2] = (i6 << 8) | (i4 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i5] & 255);
                i2 = i7;
            }
            return iArr;
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.c.b = 1;
            return iArr;
        }
    }

    public final void f() {
        int iC;
        do {
            iC = c();
            this.b.position(Math.min(this.b.position() + iC, this.b.limit()));
        } while (iC > 0);
    }
}
