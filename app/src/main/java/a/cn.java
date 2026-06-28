package a;

import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.navigation.NavigationBarItemView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cn implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47a;
    public final /* synthetic */ Object b;

    public /* synthetic */ cn(int i, Object obj) {
        this.f47a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        switch (this.f47a) {
            case 0:
                ((CarouselLayoutManager) this.b).lambda$new$0(view, i, i2, i3, i4, i5, i6, i7, i8);
                break;
            default:
                ((NavigationBarItemView) this.b).lambda$new$0(view, i, i2, i3, i4, i5, i6, i7, i8);
                break;
        }
    }
}
