package a;

import android.animation.Animator;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.internal.StaticLayoutBuilderConfigurer;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.textfield.TextInputLayout;
import com.root4arab.wipass.MainActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bq implements AccessibilityViewCommand, InputConnectionCompat.OnCommitContentListener, SwipeRefreshLayout.OnRefreshListener, CanvasCompat.CanvasOperation, MaterialShapeDrawable.OnCornerSizeChangeListener, AnimatableView.Listener, StaticLayoutBuilderConfigurer, Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f30a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bq(int i, Object obj) {
        this.f30a = i;
        this.b = obj;
    }

    @Override // com.google.android.material.internal.StaticLayoutBuilderConfigurer
    public void configure(StaticLayout.Builder builder) {
        ((TextInputLayout) this.b).lambda$updateEditTextHeight$2(builder);
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0((String) this.b, f);
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.b).start();
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.b, inputContentInfoCompat, i, bundle);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable.OnCornerSizeChangeListener
    public void onCornerSizeChange(float f) {
        ((MaterialButton) this.b).lambda$setOpticalCenterEnabled$0(f);
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        MainActivity mainActivity = (MainActivity) this.b;
        int i = MainActivity.u;
        mainActivity.l(true);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.b).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        switch (this.f30a) {
            case 3:
                ((MaskableFrameLayout) this.b).lambda$dispatchDraw$1(canvas);
                break;
            default:
                ((NavigationView) this.b).lambda$dispatchDraw$0(canvas);
                break;
        }
    }
}
