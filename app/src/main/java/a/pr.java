package a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class pr implements ew {
    public static final String[] d = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f241a;
    public final Object b;
    public final Object c;

    public /* synthetic */ pr(int i, Object obj, Object obj2) {
        this.f241a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // a.ew
    public final Class a() {
        switch (this.f241a) {
            case 0:
                return File.class;
            default:
                return ((bu) this.c).a();
        }
    }

    @Override // a.ew
    public final void b() {
        int i = this.f241a;
    }

    @Override // a.ew
    public final void cancel() {
        int i = this.f241a;
    }

    @Override // a.ew
    public final int e() {
        switch (this.f241a) {
        }
        return 1;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) {
        switch (this.f241a) {
            case 0:
                Cursor cursorQuery = ((Context) this.b).getContentResolver().query((Uri) this.c, d, null, null, null);
                if (cursorQuery != null) {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                        cursorQuery.close();
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                    break;
                }
                if (!TextUtils.isEmpty(string)) {
                    evVar.d(new File(string));
                    return;
                }
                evVar.c(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.c)));
                return;
            default:
                evVar.d(((bu) this.c).n((byte[]) this.b));
                return;
        }
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
