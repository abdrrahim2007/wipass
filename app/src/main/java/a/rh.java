package a;

import android.content.Context;
import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class rh implements qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f266a;
    public final Class b;

    public rh(Context context, Class cls) {
        this.f266a = context;
        this.b = cls;
    }

    @Override // a.qb
    public final qa c(qj qjVar) {
        Class cls = this.b;
        return new rj(this.f266a, qjVar.a(File.class, cls), qjVar.a(Uri.class, cls), cls);
    }
}
