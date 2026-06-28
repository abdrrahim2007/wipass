package a;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ih implements lw {
    @Override // a.lw
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // a.lw
    public final int b(ByteBuffer byteBuffer, on onVar) {
        AtomicReference atomicReference = cf.f44a;
        return d(new ce(byteBuffer), onVar);
    }

    @Override // a.lw
    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // a.lw
    public final int d(InputStream inputStream, on onVar) {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }
}
