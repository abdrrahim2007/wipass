package a;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;
import com.google.android.material.search.SearchView;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gv implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f106a;
    public final /* synthetic */ Object b;

    public /* synthetic */ gv(int i, Object obj) {
        this.f106a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.f106a) {
            case 0:
                return ((DragStartHelper) this.b).onTouch(view, motionEvent);
            default:
                return ((SearchView) this.b).lambda$setUpContentOnTouchListener$3(view, motionEvent);
        }
    }
}
