package a;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class td implements ViewUtils.OnApplyWindowInsetsListener, OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f294a;

    public /* synthetic */ td(SearchView searchView) {
        this.f294a = searchView;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f294a.lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return this.f294a.lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
    }
}
