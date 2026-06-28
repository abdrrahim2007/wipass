package a;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f29a;
    public final /* synthetic */ View b;

    public /* synthetic */ bo(View view, int i) {
        this.f29a = i;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f29a) {
            case 0:
                this.b.requestLayout();
                break;
            default:
                ViewUtils.requestFocusAndShowKeyboard(this.b, false);
                break;
        }
    }
}
