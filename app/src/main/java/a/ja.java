package a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes.dex */
public final class ja implements ViewTreeObserver.OnDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f140a;
    public final /* synthetic */ jb b;

    public ja(jb jbVar, View view) {
        this.b = jbVar;
        this.f140a = view;
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        wh.f().post(new iz(0, this, this));
    }
}
