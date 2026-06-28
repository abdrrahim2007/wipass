package a;

import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class cc implements ez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f41a;

    public /* synthetic */ cc(int i) {
        this.f41a = i;
    }

    @Override // a.ez
    public final Class a() {
        switch (this.f41a) {
            case 0:
                return ByteBuffer.class;
            case 1:
                throw new UnsupportedOperationException("Not implemented");
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // a.ez
    public final fa b(Object obj) {
        switch (this.f41a) {
            case 0:
                return new cd((ByteBuffer) obj, 0);
            case 1:
                return new fb(0, obj);
            default:
                return new com.bumptech.glide.load.data.a((ParcelFileDescriptor) obj);
        }
    }
}
