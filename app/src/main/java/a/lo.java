package a;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lo implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f170a;
    public final /* synthetic */ View b;
    public final /* synthetic */ CoordinatorLayout.Behavior c;

    public /* synthetic */ lo(CoordinatorLayout.Behavior behavior, View view, int i) {
        this.f170a = i;
        this.c = behavior;
        this.b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        switch (this.f170a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.c).lambda$disableIfTouchExplorationEnabled$0(this.b, z);
                break;
            default:
                ((HideViewOnScrollBehavior) this.c).lambda$disableIfTouchExplorationEnabled$0(this.b, z);
                break;
        }
    }
}
