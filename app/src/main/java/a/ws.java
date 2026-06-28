package a;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.bumptech.glide.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ws extends bc {
    public static final int c = R.id.glide_custom_view_target_tag;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f354a;
    public final wr b;

    public ws(ImageView imageView) {
        this.f354a = imageView;
        this.b = new wr(imageView);
    }

    @Override // a.uy
    public final void a(ts tsVar) throws Throwable {
        wr wrVar = this.b;
        ArrayList arrayList = wrVar.b;
        ImageView imageView = wrVar.f353a;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iA = wrVar.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        int iA2 = wrVar.a(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iA > 0 || iA == Integer.MIN_VALUE) && (iA2 > 0 || iA2 == Integer.MIN_VALUE)) {
            tsVar.l(iA, iA2);
            return;
        }
        if (!arrayList.contains(tsVar)) {
            arrayList.add(tsVar);
        }
        if (wrVar.c == null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            wq wqVar = new wq(wrVar);
            wrVar.c = wqVar;
            viewTreeObserver.addOnPreDrawListener(wqVar);
        }
    }

    @Override // a.uy
    public final void b(rw rwVar) {
        this.f354a.setTag(c, rwVar);
    }

    @Override // a.uy
    public final void e(ts tsVar) {
        this.b.b.remove(tsVar);
    }

    @Override // a.uy
    public final rw g() {
        Object tag = this.f354a.getTag(c);
        if (tag == null) {
            return null;
        }
        if (tag instanceof rw) {
            return (rw) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public final String toString() {
        return "Target for: " + this.f354a;
    }
}
