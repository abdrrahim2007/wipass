package a;

import com.google.android.material.search.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class tb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292a;
    public final /* synthetic */ SearchView b;

    public /* synthetic */ tb(SearchView searchView, int i) {
        this.f292a = i;
        this.b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f292a) {
            case 0:
                this.b.lambda$clearFocusAndHideKeyboard$9();
                break;
            case 1:
                this.b.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 2:
                this.b.show();
                break;
            default:
                this.b.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}
