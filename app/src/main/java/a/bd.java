package a;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class bd implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23a;
    public final Comparable b;

    public bd() {
        this.b = Bitmap.CompressFormat.JPEG;
        this.f23a = 100;
    }

    @Override // a.sp
    public sf b(sf sfVar, qu quVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) sfVar.get()).compress((Bitmap.CompressFormat) this.b, this.f23a, byteArrayOutputStream);
        sfVar.recycle();
        return new af(byteArrayOutputStream.toByteArray());
    }

    public bd(fj fjVar, int i) {
        this.b = fjVar;
        this.f23a = i;
    }
}
