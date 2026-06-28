package a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.ConnectivityManager;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ga implements qb, lg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f92a;
    public final Context b;

    public /* synthetic */ ga(Context context, int i) {
        this.f92a = i;
        this.b = context;
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        switch (this.f92a) {
            case 0:
                return new ax(this.b, this);
            case 1:
                return new ax(this.b, this);
            case 2:
                return new ax(this.b, this);
            case 3:
            default:
                return new ax(this.b, qjVar.a(Integer.class, InputStream.class));
            case 4:
                return new ps(this.b, 0);
            case 5:
                return new ps(this.b, 1);
            case 6:
                return new ps(this.b, 2);
            case 7:
                return new ax(this.b, qjVar.a(Integer.class, AssetFileDescriptor.class));
        }
    }

    @Override // a.lg
    public Object get() {
        return (ConnectivityManager) this.b.getSystemService("connectivity");
    }
}
