package a;

import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class av implements ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16a;
    public Object b;
    public final Comparable c;
    public final Object d;

    public /* synthetic */ av(int i, Comparable comparable, Object obj) {
        this.f16a = i;
        this.d = obj;
        this.c = comparable;
    }

    @Override // a.ew
    public final void b() {
        switch (this.f16a) {
            case 0:
                Object obj = this.b;
                if (obj != null) {
                    try {
                        g(obj);
                    } catch (IOException unused) {
                        return;
                    }
                    break;
                }
                break;
            default:
                Object obj2 = this.b;
                if (obj2 != null) {
                    try {
                        g(obj2);
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // a.ew
    public final void cancel() {
        int i = this.f16a;
    }

    @Override // a.ew
    public final int e() {
        switch (this.f16a) {
        }
        return 1;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) {
        switch (this.f16a) {
            case 0:
                try {
                    Object objH = h((AssetManager) this.d, (String) this.c);
                    this.b = objH;
                    evVar.d(objH);
                } catch (IOException e) {
                    Log.isLoggable("AssetPathFetcher", 3);
                    evVar.c(e);
                }
                break;
            default:
                try {
                    Object objI = i((Uri) this.c, (ContentResolver) this.d);
                    this.b = objI;
                    evVar.d(objI);
                } catch (FileNotFoundException e2) {
                    Log.isLoggable("LocalUriFetcher", 3);
                    evVar.c(e2);
                    return;
                }
                break;
        }
    }

    public abstract void g(Object obj);

    public abstract Object h(AssetManager assetManager, String str);

    public abstract Object i(Uri uri, ContentResolver contentResolver);

    private final void c() {
    }

    private final void d() {
    }
}
