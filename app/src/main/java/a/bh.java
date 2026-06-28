package a;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class bh implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f27a;
    public final bj b;

    public bh() {
        this.f27a = 0;
        this.b = new ee(9);
    }

    @Override // a.si
    public final sf a(Object obj, int i, int i2, qu quVar) {
        switch (this.f27a) {
            case 0:
                return c(q.c(obj), i, i2, quVar);
            default:
                return bk.c(this.b, ((ue) obj).b());
        }
    }

    @Override // a.si
    public final /* bridge */ /* synthetic */ boolean b(Object obj, qu quVar) {
        switch (this.f27a) {
            case 0:
                q.r(obj);
                break;
            default:
                break;
        }
        return true;
    }

    public bk c(ImageDecoder.Source source, int i, int i2, qu quVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new fv(i, i2, quVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            bitmapDecodeBitmap.getWidth();
            bitmapDecodeBitmap.getHeight();
        }
        return new bk((ee) this.b, bitmapDecodeBitmap);
    }

    public bh(bj bjVar) {
        this.f27a = 1;
        this.b = bjVar;
    }
}
