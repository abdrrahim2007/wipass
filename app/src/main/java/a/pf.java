package a;

import android.text.Editable;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pf implements ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter, Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f230a;

    public /* synthetic */ pf(int i) {
        this.f230a = i;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        switch (this.f230a) {
            case 2:
                return Transition.lambda$getInterpolator$1(f);
            case 3:
                return Transition.lambda$getInterpolator$2(f);
            case 4:
                return Transition.lambda$getInterpolator$3(f);
            case 5:
                return Transition.lambda$getInterpolator$4(f);
            case 6:
                return Transition.lambda$getInterpolator$5(f);
            case 7:
                return Transition.lambda$getInterpolator$6(f);
            default:
                return Transition.lambda$getInterpolator$7(f);
        }
    }
}
