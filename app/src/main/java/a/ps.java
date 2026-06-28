package a;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class ps implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f242a;
    public final Context b;

    public ps(Context context, int i) {
        this.f242a = i;
        switch (i) {
            case 1:
                this.b = context.getApplicationContext();
                break;
            case 2:
                this.b = context.getApplicationContext();
                break;
            default:
                this.b = context;
                break;
        }
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        switch (this.f242a) {
            case 0:
                return ky.d((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return ky.d(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return ky.d(uri2) && uri2.getPathSegments().contains("video");
        }
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        Long l;
        switch (this.f242a) {
            case 0:
                Uri uri = (Uri) obj;
                return new pz(new qq(uri), new pr(0, this.b, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384) {
                    return null;
                }
                qq qqVar = new qq(uri2);
                Context context = this.b;
                return new pz(qqVar, fd.c(context, uri2, new vh(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i == Integer.MIN_VALUE || i2 == Integer.MIN_VALUE || i > 512 || i2 > 384 || (l = (Long) quVar.c(wm.d)) == null || l.longValue() != -1) {
                    return null;
                }
                qq qqVar2 = new qq(uri3);
                Context context2 = this.b;
                return new pz(qqVar2, fd.c(context2, uri3, new vh(context2.getContentResolver(), 1)));
        }
    }
}
