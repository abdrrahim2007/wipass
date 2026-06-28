package a;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class iu extends av {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ iu(AssetManager assetManager, String str, int i) {
        super(0, str, assetManager);
        this.e = i;
    }

    @Override // a.ew
    public final Class a() {
        switch (this.e) {
            case 0:
                return AssetFileDescriptor.class;
            default:
                return InputStream.class;
        }
    }

    @Override // a.av
    public final void g(Object obj) throws IOException {
        switch (this.e) {
            case 0:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((InputStream) obj).close();
                break;
        }
    }

    @Override // a.av
    public final Object h(AssetManager assetManager, String str) {
        switch (this.e) {
            case 0:
                return assetManager.openFd(str);
            default:
                return assetManager.open(str);
        }
    }
}
