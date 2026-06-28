package a;

import android.graphics.ImageDecoder;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ag implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4a;
    public final ah b;

    public /* synthetic */ ag(ah ahVar, int i) {
        this.f4a = i;
        this.b = ahVar;
    }

    @Override // a.si
    public final sf a(Object obj, int i, int i2, qu quVar) {
        switch (this.f4a) {
            case 0:
                return ah.a(ImageDecoder.createSource((ByteBuffer) obj), i, i2, quVar);
            default:
                return ah.a(ImageDecoder.createSource(cf.b((InputStream) obj)), i, i2, quVar);
        }
    }

    @Override // a.si
    public final boolean b(Object obj, qu quVar) throws IOException {
        switch (this.f4a) {
            case 0:
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeD = bs.d((ArrayList) this.b.b, (ByteBuffer) obj);
                if (imageHeaderParser$ImageTypeD == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeD == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
            default:
                ah ahVar = this.b;
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeC = bs.c((ArrayList) ahVar.b, (InputStream) obj, (on) ahVar.c);
                if (imageHeaderParser$ImageTypeC == ImageHeaderParser$ImageType.ANIMATED_WEBP || (Build.VERSION.SDK_INT >= 31 && imageHeaderParser$ImageTypeC == ImageHeaderParser$ImageType.ANIMATED_AVIF)) {
                }
                break;
        }
        return true;
    }
}
