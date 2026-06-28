package a;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class wq implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f352a;

    public wq(wr wrVar) {
        this.f352a = new WeakReference(wrVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws Throwable {
        Log.isLoggable("ViewTarget", 2);
        wr wrVar = (wr) this.f352a.get();
        if (wrVar != null) {
            ArrayList arrayList = wrVar.b;
            ImageView imageView = wrVar.f353a;
            if (!arrayList.isEmpty()) {
                int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i = 0;
                int iA = wrVar.a(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                int iA2 = wrVar.a(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                if ((iA <= 0 && iA != Integer.MIN_VALUE) || (iA2 <= 0 && iA2 != Integer.MIN_VALUE)) {
                    return true;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                int size = arrayList2.size();
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    ((ts) ((ua) obj)).l(iA, iA2);
                }
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(wrVar.c);
                }
                wrVar.c = null;
                arrayList.clear();
            }
        }
        return true;
    }
}
