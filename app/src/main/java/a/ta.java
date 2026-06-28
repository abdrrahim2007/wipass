package a;

import android.view.View;
import com.google.android.material.search.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ta implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f291a;
    public final /* synthetic */ SearchView b;

    public /* synthetic */ ta(SearchView searchView, int i) {
        this.f291a = i;
        this.b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f291a) {
            case 0:
                this.b.lambda$setUpBackButton$1(view);
                break;
            case 1:
                this.b.lambda$setUpClearButton$2(view);
                break;
            default:
                this.b.lambda$setupWithSearchBar$7(view);
                break;
        }
    }
}
