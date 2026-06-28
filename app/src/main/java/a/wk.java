package a;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class wk extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f348a;

    public wk(ByteBuffer byteBuffer) {
        this.f348a = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f348a.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = this.f348a;
        if (j >= byteBuffer.limit()) {
            return -1;
        }
        byteBuffer.position((int) j);
        int iMin = Math.min(i2, byteBuffer.remaining());
        byteBuffer.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
