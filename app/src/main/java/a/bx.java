package a;

import android.graphics.ImageDecoder;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class bx implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f36a;
    public final bh b;

    public bx(int i) {
        this.f36a = i;
        switch (i) {
            case 1:
                this.b = new bh();
                break;
            default:
                this.b = new bh();
                break;
        }
    }

    @Override // a.si
    public final sf a(Object obj, int i, int i2, qu quVar) {
        switch (this.f36a) {
            case 0:
                return this.b.c(ImageDecoder.createSource((ByteBuffer) obj), i, i2, quVar);
            default:
                return this.b.c(ImageDecoder.createSource(cf.b((InputStream) obj)), i, i2, quVar);
        }
    }

    @Override // a.si
    public final /* bridge */ /* synthetic */ boolean b(Object obj, qu quVar) {
        switch (this.f36a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
