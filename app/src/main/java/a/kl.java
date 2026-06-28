package a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class kl extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ku f148a;

    public kl(ku kuVar) {
        this.f148a = kuVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new km(this);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new km(this);
    }
}
