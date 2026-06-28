package a;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dt implements OnContextAvailableListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f61a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ dt(ComponentActivity componentActivity, int i) {
        this.f61a = i;
        this.b = componentActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable(Context context) {
        switch (this.f61a) {
            case 0:
                this.b.lambda$new$2(context);
                break;
            default:
                ((FragmentActivity) this.b).lambda$init$3(context);
                break;
        }
    }
}
