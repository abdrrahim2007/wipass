package a;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class vl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f331a;
    public final /* synthetic */ Toolbar b;

    public /* synthetic */ vl(Toolbar toolbar, int i) {
        this.f331a = i;
        this.b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f331a) {
            case 0:
                this.b.collapseActionView();
                break;
            default:
                this.b.invalidateMenu();
                break;
        }
    }
}
