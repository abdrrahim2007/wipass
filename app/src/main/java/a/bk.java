package a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class bk implements sf, ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f28a = 0;
    public final Object b;
    public final Object c;

    public bk(bj bjVar, Bitmap bitmap) {
        mk.f(bitmap, "Bitmap must not be null");
        this.b = bitmap;
        mk.f(bjVar, "BitmapPool must not be null");
        this.c = bjVar;
    }

    public static bk c(bj bjVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new bk(bjVar, bitmap);
    }

    @Override // a.sf
    public final int a() {
        switch (this.f28a) {
            case 0:
                return wh.c((Bitmap) this.b);
            default:
                return ((sf) this.c).a();
        }
    }

    @Override // a.sf
    public final Class b() {
        switch (this.f28a) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // a.sf
    public final Object get() {
        switch (this.f28a) {
            case 0:
                return (Bitmap) this.b;
            default:
                return new BitmapDrawable((Resources) this.b, (Bitmap) ((sf) this.c).get());
        }
    }

    @Override // a.ma
    public final void initialize() {
        switch (this.f28a) {
            case 0:
                ((Bitmap) this.b).prepareToDraw();
                break;
            default:
                sf sfVar = (sf) this.c;
                if (sfVar instanceof ma) {
                    ((ma) sfVar).initialize();
                }
                break;
        }
    }

    @Override // a.sf
    public final void recycle() {
        switch (this.f28a) {
            case 0:
                ((bj) this.c).k((Bitmap) this.b);
                break;
            default:
                ((sf) this.c).recycle();
                break;
        }
    }

    public bk(Resources resources, sf sfVar) {
        mk.f(resources, "Argument must not be null");
        this.b = resources;
        mk.f(sfVar, "Argument must not be null");
        this.c = sfVar;
    }
}
