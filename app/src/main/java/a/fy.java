package a;

import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.google.android.material.progressindicator.DeterminateDrawable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fy implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f90a;
    public final /* synthetic */ Object b;

    public /* synthetic */ fy(int i, Object obj) {
        this.f90a = i;
        this.b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f90a) {
            case 0:
                ((DeterminateDrawable) this.b).lambda$maybeInitializeAmplitudeAnimator$1(valueAnimator);
                break;
            case 1:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) this.b, valueAnimator);
                break;
            default:
                MaterialMainContainerBackHelper.lambda$createCornerAnimator$1((ClippableRoundedCornerLayout) this.b, valueAnimator);
                break;
        }
    }
}
