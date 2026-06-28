package a;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wp implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f351a;
    public final /* synthetic */ ViewConfiguration b;

    public /* synthetic */ wp(ViewConfiguration viewConfiguration, int i) {
        this.f351a = i;
        this.b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        switch (this.f351a) {
            case 0:
                scaledMaximumFlingVelocity = this.b.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = this.b.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
