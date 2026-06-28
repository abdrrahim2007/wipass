package a;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class af implements sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3a;
    public final Object b;

    public /* synthetic */ af(int i, Object obj) {
        this.f3a = i;
        this.b = obj;
    }

    @Override // a.sf
    public final int a() {
        switch (this.f3a) {
            case 0:
                return wh.d(Bitmap.Config.ARGB_8888) * ((AnimatedImageDrawable) this.b).getIntrinsicHeight() * ((AnimatedImageDrawable) this.b).getIntrinsicWidth() * 2;
            case 1:
                return ((byte[]) this.b).length;
            case 2:
                return 1;
            default:
                return wh.c((Bitmap) this.b);
        }
    }

    @Override // a.sf
    public final Class b() {
        switch (this.f3a) {
            case 0:
                return Drawable.class;
            case 1:
                return byte[].class;
            case 2:
                return ((File) this.b).getClass();
            default:
                return Bitmap.class;
        }
    }

    @Override // a.sf
    public final Object get() {
        switch (this.f3a) {
            case 0:
                return (AnimatedImageDrawable) this.b;
            case 1:
                return (byte[]) this.b;
            case 2:
                return (File) this.b;
            default:
                return (Bitmap) this.b;
        }
    }

    @Override // a.sf
    public final void recycle() {
        switch (this.f3a) {
            case 0:
                ((AnimatedImageDrawable) this.b).stop();
                ((AnimatedImageDrawable) this.b).clearAnimationCallbacks();
                break;
        }
    }

    public af(byte[] bArr) {
        this.f3a = 1;
        mk.f(bArr, "Argument must not be null");
        this.b = bArr;
    }

    public af(File file) {
        this.f3a = 2;
        mk.f(file, "Argument must not be null");
        this.b = file;
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void e() {
    }
}
