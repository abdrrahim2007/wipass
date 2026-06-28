package a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class ee implements eh, qb, sp, nr, bj, bu, hi, gc, jg, gs, sc, io, iw {
    public static final /* synthetic */ ee b = new ee(0);
    public static final /* synthetic */ ee c = new ee(1);
    public static final ee d = new ee(2);
    public static final /* synthetic */ ee e = new ee(3);
    public static final ee f = new ee(4);
    public static final ee g = new ee(5);
    public static final ee h = new ee(6);
    public static final ee i = new ee(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f68a;

    public /* synthetic */ ee(int i2) {
        this.f68a = i2;
    }

    public static ByteArrayInputStream v(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, iIndexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    @Override // a.bu, a.iw
    public Class a() {
        switch (this.f68a) {
            case 10:
                return ByteBuffer.class;
            case 12:
                return InputStream.class;
            case 26:
                return ParcelFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // a.sp
    public sf b(sf sfVar, qu quVar) {
        as asVar;
        byte[] bArrArray;
        switch (this.f68a) {
            case 7:
                return sfVar;
            default:
                ByteBuffer byteBufferAsReadOnlyBuffer = ((km) sfVar.get()).f149a.f148a.f155a.d.asReadOnlyBuffer();
                AtomicReference atomicReference = cf.f44a;
                if (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) {
                    asVar = null;
                } else {
                    byte[] bArrArray2 = byteBufferAsReadOnlyBuffer.array();
                    int iArrayOffset = byteBufferAsReadOnlyBuffer.arrayOffset();
                    int iLimit = byteBufferAsReadOnlyBuffer.limit();
                    asVar = new as();
                    asVar.c = bArrArray2;
                    asVar.f15a = iArrayOffset;
                    asVar.b = iLimit;
                }
                if (asVar != null && asVar.f15a == 0 && asVar.b == ((byte[]) asVar.c).length) {
                    bArrArray = byteBufferAsReadOnlyBuffer.array();
                } else {
                    ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
                    byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
                    byteBufferAsReadOnlyBuffer2.get(bArr);
                    bArrArray = bArr;
                }
                return new af(bArrArray);
        }
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        switch (this.f68a) {
            case 6:
                return vy.b;
            case 11:
                return new bv(0, new ee(10));
            case 13:
                return new bv(0, new ee(12));
            default:
                return new vy(1);
        }
    }

    @Override // a.gc
    public File e(nl nlVar) {
        return null;
    }

    @Override // a.bj
    public Bitmap h(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // a.hi
    public boolean i(Object obj, File file, qu quVar) {
        try {
            cf.d((ByteBuffer) obj, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }

    @Override // a.bj
    public Bitmap j(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // a.bj
    public void k(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // a.bu
    public Object n(byte[] bArr) {
        switch (this.f68a) {
            case 10:
                return ByteBuffer.wrap(bArr);
            default:
                return new ByteArrayInputStream(bArr);
        }
    }

    @Override // a.iw
    public Object p(File file) {
        switch (this.f68a) {
            case 26:
                return ParcelFileDescriptor.open(file, 268435456);
            default:
                return new FileInputStream(file);
        }
    }

    @Override // a.nr
    public void r(nt ntVar) {
        ntVar.onStart();
    }

    @Override // a.iw
    public void t(Object obj) throws IOException {
        switch (this.f68a) {
            case 26:
                ((ParcelFileDescriptor) obj).close();
                break;
            default:
                ((InputStream) obj).close();
                break;
        }
    }

    @Override // a.bj
    public void s() {
    }

    @Override // a.gs
    public void u() {
    }

    @Override // a.nr
    public void d(nt ntVar) {
    }

    @Override // a.io
    public void f(Object obj) {
    }

    @Override // a.bj
    public void o(int i2) {
    }

    @Override // a.jg
    public void q(FragmentActivity fragmentActivity) {
    }

    @Override // a.gc
    public void g(nl nlVar, z zVar) {
    }

    @Override // a.gs
    public void l(bj bjVar, Bitmap bitmap) {
    }
}
