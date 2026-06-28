package a;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import com.google.android.material.motion.MaterialBackHandler;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class pg implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f231a;
    public final /* synthetic */ Object b;

    public /* synthetic */ pg(int i, Object obj) {
        this.f231a = i;
        this.b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f231a) {
            case 0:
                ((MaterialBackHandler) this.b).handleBackInvoked();
                break;
            case 1:
                OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0((jh) this.b);
                break;
            default:
                ((Runnable) this.b).run();
                break;
        }
    }
}
