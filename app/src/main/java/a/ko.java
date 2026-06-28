package a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class ko implements sf, ma {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f151a;
    public final /* synthetic */ int b;

    public ko(Drawable drawable, int i) {
        this.b = i;
        mk.f(drawable, "Argument must not be null");
        this.f151a = drawable;
    }

    @Override // a.sf
    public final int a() {
        switch (this.b) {
            case 0:
                ku kuVar = ((km) this.f151a).f149a.f148a;
                ue ueVar = kuVar.f155a;
                return (ueVar.j.length * 4) + ueVar.d.limit() + ueVar.i.length + kuVar.n;
            default:
                Drawable drawable = this.f151a;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
        }
    }

    @Override // a.sf
    public final Class b() {
        switch (this.b) {
            case 0:
                return km.class;
            default:
                return this.f151a.getClass();
        }
    }

    @Override // a.sf
    public final Object get() {
        Drawable drawable = this.f151a;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override // a.ma
    public void initialize() {
        switch (this.b) {
            case 0:
                ((km) this.f151a).f149a.f148a.l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f151a;
                if (drawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                } else if (drawable instanceof km) {
                    ((km) drawable).f149a.f148a.l.prepareToDraw();
                }
                break;
        }
    }

    @Override // a.sf
    public final void recycle() {
        on onVar;
        on onVar2;
        on onVar3;
        switch (this.b) {
            case 0:
                km kmVar = (km) this.f151a;
                kmVar.stop();
                kmVar.d = true;
                ku kuVar = kmVar.f149a.f148a;
                sb sbVar = kuVar.d;
                kuVar.c.clear();
                Bitmap bitmap = kuVar.l;
                if (bitmap != null) {
                    kuVar.e.k(bitmap);
                    kuVar.l = null;
                }
                kuVar.f = false;
                kr krVar = kuVar.i;
                if (krVar != null) {
                    sbVar.k(krVar);
                    kuVar.i = null;
                }
                kr krVar2 = kuVar.k;
                if (krVar2 != null) {
                    sbVar.k(krVar2);
                    kuVar.k = null;
                }
                kr krVar3 = kuVar.m;
                if (krVar3 != null) {
                    sbVar.k(krVar3);
                    kuVar.m = null;
                }
                ue ueVar = kuVar.f155a;
                ah ahVar = ueVar.c;
                ueVar.l = null;
                byte[] bArr = ueVar.i;
                if (bArr != null && (onVar3 = (on) ahVar.c) != null) {
                    onVar3.g(bArr);
                }
                int[] iArr = ueVar.j;
                if (iArr != null && (onVar2 = (on) ahVar.c) != null) {
                    onVar2.g(iArr);
                }
                Bitmap bitmap2 = ueVar.m;
                if (bitmap2 != null) {
                    ((bj) ahVar.b).k(bitmap2);
                }
                ueVar.m = null;
                ueVar.d = null;
                ueVar.s = null;
                byte[] bArr2 = ueVar.e;
                if (bArr2 != null && (onVar = (on) ahVar.c) != null) {
                    onVar.g(bArr2);
                }
                kuVar.j = true;
                break;
        }
    }

    private final void c() {
    }
}
