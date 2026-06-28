package a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class km extends Drawable implements ks, Animatable, Animatable2Compat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kl f149a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int f;
    public boolean h;
    public Paint i;
    public Rect j;
    public ArrayList k;
    public boolean e = true;
    public final int g = -1;

    public km(kl klVar) {
        this.f149a = klVar;
    }

    public final void a() {
        mk.b(!this.d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        ku kuVar = this.f149a.f148a;
        if (kuVar.f155a.l.c == 1) {
            invalidateSelf();
            return;
        }
        if (this.b) {
            return;
        }
        this.b = true;
        ArrayList arrayList = kuVar.c;
        if (kuVar.j) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (arrayList.contains(this)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (zIsEmpty && !kuVar.f) {
            kuVar.f = true;
            kuVar.j = false;
            kuVar.a();
        }
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void clearAnimationCallbacks() {
        ArrayList arrayList = this.k;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.d) {
            return;
        }
        if (this.h) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.j == null) {
                this.j = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.j);
            this.h = false;
        }
        ku kuVar = this.f149a.f148a;
        kr krVar = kuVar.i;
        Bitmap bitmap = krVar != null ? krVar.g : kuVar.l;
        if (this.j == null) {
            this.j = new Rect();
        }
        Rect rect = this.j;
        if (this.i == null) {
            this.i = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.i);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f149a;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f149a.f148a.p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f149a.f148a.o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.k == null) {
            this.k = new ArrayList();
        }
        this.k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        this.i.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.i == null) {
            this.i = new Paint(2);
        }
        this.i.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        mk.b(!this.d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.e = z;
        if (!z) {
            this.b = false;
            ku kuVar = this.f149a.f148a;
            ArrayList arrayList = kuVar.c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                kuVar.f = false;
            }
        } else if (this.c) {
            a();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.c = true;
        this.f = 0;
        if (this.e) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.c = false;
        this.b = false;
        ku kuVar = this.f149a.f148a;
        ArrayList arrayList = kuVar.c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            kuVar.f = false;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public final boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        ArrayList arrayList = this.k;
        if (arrayList == null || animationCallback == null) {
            return false;
        }
        return arrayList.remove(animationCallback);
    }
}
