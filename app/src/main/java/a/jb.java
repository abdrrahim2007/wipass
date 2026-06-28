package a;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class jb implements jg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f141a = Collections.newSetFromMap(new WeakHashMap());
    public volatile boolean b;

    @Override // a.jg
    public final void q(FragmentActivity fragmentActivity) {
        if (!this.b && this.f141a.add(fragmentActivity)) {
            View decorView = fragmentActivity.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new ja(this, decorView));
        }
    }
}
