package a;

import android.animation.TypeEvaluator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pp implements TypeEvaluator {
    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        return MaterialMainContainerBackHelper.lambda$createCornerAnimator$0(f, obj, obj2);
    }
}
