package a;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class um implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f318a;
    public final qa b;

    public /* synthetic */ um(qa qaVar, int i) {
        this.f318a = i;
        this.b = qaVar;
    }

    @Override // a.qa
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        switch (this.f318a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        Uri uriFromFile;
        switch (this.f318a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    uriFromFile = null;
                } else if (str.charAt(0) == '/') {
                    uriFromFile = Uri.fromFile(new File(str));
                } else {
                    Uri uri = Uri.parse(str);
                    uriFromFile = uri.getScheme() == null ? Uri.fromFile(new File(str)) : uri;
                }
                if (uriFromFile == null) {
                    return null;
                }
                qa qaVar = this.b;
                if (qaVar.a(uriFromFile)) {
                    return qaVar.b(uriFromFile, i, i2, quVar);
                }
                return null;
            default:
                return this.b.b(new lh((URL) obj), i, i2, quVar);
        }
    }
}
