package a;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class bf implements sp, qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f25a;
    public final Resources b;

    public /* synthetic */ bf(Resources resources, int i) {
        this.f25a = i;
        this.b = resources;
    }

    @Override // a.sp
    public sf b(sf sfVar, qu quVar) {
        if (sfVar == null) {
            return null;
        }
        return new bk(this.b, sfVar);
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        switch (this.f25a) {
            case 1:
                return new ax(this.b, qjVar.a(Uri.class, AssetFileDescriptor.class));
            case 2:
                return new ax(this.b, qjVar.a(Uri.class, InputStream.class));
            default:
                return new ax(this.b, vy.b);
        }
    }
}
