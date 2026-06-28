package a;

import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f285a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ sq(Object obj, int i, int i2) {
        this.f285a = i2;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f285a) {
            case 0:
                ((ResourcesCompat.FontCallback) this.c).lambda$callbackFailAsync$1(this.b);
                break;
            default:
                ((SideSheetBehavior) this.c).lambda$setState$0(this.b);
                break;
        }
    }
}
