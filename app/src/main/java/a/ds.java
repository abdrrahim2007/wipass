package a;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ds implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f60a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ds(int i, Object obj) {
        this.f60a = i;
        this.b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f60a) {
            case 0:
                return ((ComponentActivity) this.b).lambda$new$1();
            case 1:
                return ((FragmentActivity) this.b).lambda$init$0();
            case 2:
                return ((FragmentManager) this.b).lambda$attachController$4();
            default:
                return SavedStateHandle.savedStateProvider$lambda$0((SavedStateHandle) this.b);
        }
    }
}
