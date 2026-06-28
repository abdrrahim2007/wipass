package a;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
public final class bi extends ws {
    public Animatable d;
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bi(ImageView imageView, int i) {
        super(imageView);
        this.e = i;
    }

    @Override // a.uy
    public final void c(Drawable drawable) {
        k(null);
        this.d = null;
        this.f354a.setImageDrawable(drawable);
    }

    @Override // a.nt
    public final void d() {
        Animatable animatable = this.d;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // a.uy
    public final void f(Drawable drawable) {
        k(null);
        this.d = null;
        this.f354a.setImageDrawable(drawable);
    }

    @Override // a.uy
    public final void h(Drawable drawable) {
        wr wrVar = this.b;
        ViewTreeObserver viewTreeObserver = wrVar.f353a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(wrVar.c);
        }
        wrVar.c = null;
        wrVar.b.clear();
        Animatable animatable = this.d;
        if (animatable != null) {
            animatable.stop();
        }
        k(null);
        this.d = null;
        this.f354a.setImageDrawable(drawable);
    }

    @Override // a.uy
    public final void i(Object obj) {
        k(obj);
        if (!(obj instanceof Animatable)) {
            this.d = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.d = animatable;
        animatable.start();
    }

    public final void k(Object obj) {
        switch (this.e) {
            case 0:
                this.f354a.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f354a.setImageDrawable((Drawable) obj);
                break;
        }
    }

    @Override // a.nt
    public final void onStart() {
        Animatable animatable = this.d;
        if (animatable != null) {
            animatable.start();
        }
    }
}
