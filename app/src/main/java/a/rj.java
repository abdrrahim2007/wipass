package a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class rj implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f268a;
    public final qa b;
    public final qa c;
    public final Class d;

    public rj(Context context, qa qaVar, qa qaVar2, Class cls) {
        this.f268a = context.getApplicationContext();
        this.b = qaVar;
        this.c = qaVar2;
        this.d = cls;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && ky.d((Uri) obj);
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        Uri uri = (Uri) obj;
        return new pz(new qq(uri), new ri(this.f268a, this.b, this.c, uri, i, i2, quVar, this.d));
    }
}
