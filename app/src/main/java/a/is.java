package a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class is implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f136a;

    public /* synthetic */ is(int i) {
        this.f136a = i;
    }

    @Override // a.si
    public final sf a(Object obj, int i, int i2, qu quVar) {
        switch (this.f136a) {
            case 0:
                return new af((File) obj);
            case 1:
                return new af(3, (Bitmap) obj);
            default:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new ko(drawable, 1);
                }
                return null;
        }
    }

    @Override // a.si
    public final /* bridge */ /* synthetic */ boolean b(Object obj, qu quVar) {
        switch (this.f136a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }
}
