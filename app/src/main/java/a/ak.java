package a;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ak implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ak(int i, Object obj, Object obj2) {
        this.f8a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f8a) {
            case 0:
                ((AppBarLayout) this.b).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) this.c, valueAnimator);
                break;
            case 1:
                ((DeterminateDrawable) this.b).lambda$new$0((BaseProgressIndicatorSpec) this.c, valueAnimator);
                break;
            case 2:
                ((ExpandCollapseAnimationHelper) this.b).lambda$getExpandCollapseAnimator$0((Rect) this.c, valueAnimator);
                break;
            default:
                ((ViewPropertyAnimatorUpdateListener) this.b).onAnimationUpdate((View) this.c);
                break;
        }
    }
}
