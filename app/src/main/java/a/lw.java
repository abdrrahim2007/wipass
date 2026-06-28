package a;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface lw {
    ImageHeaderParser$ImageType a(ByteBuffer byteBuffer);

    int b(ByteBuffer byteBuffer, on onVar);

    ImageHeaderParser$ImageType c(InputStream inputStream);

    int d(InputStream inputStream, on onVar);
}
