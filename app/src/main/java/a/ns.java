package a;

import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ns implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f197a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ns(int i, Object obj, Object obj2) {
        this.f197a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.f197a) {
            case 0:
                LifecycleController.observer$lambda$0((LifecycleController) this.b, (mt) this.c, lifecycleOwner, event);
                break;
            default:
                ((MenuHostHelper) this.b).lambda$addMenuProvider$0((MenuProvider) this.c, lifecycleOwner, event);
                break;
        }
    }
}
