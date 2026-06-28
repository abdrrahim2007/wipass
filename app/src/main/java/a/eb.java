package a;

import androidx.core.widget.ContentLoadingProgressBar;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f67a;
    public final /* synthetic */ ContentLoadingProgressBar b;

    public /* synthetic */ eb(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.f67a = i;
        this.b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f67a) {
            case 0:
                this.b.lambda$new$0();
                break;
            case 1:
                this.b.lambda$new$1();
                break;
            case 2:
                this.b.showOnUiThread();
                break;
            default:
                this.b.hideOnUiThread();
                break;
        }
    }
}
