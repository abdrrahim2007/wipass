package a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class ri implements ew {
    public static final String[] k = {"_data"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f267a;
    public final qa b;
    public final qa c;
    public final Uri d;
    public final int e;
    public final int f;
    public final qu g;
    public final Class h;
    public volatile boolean i;
    public volatile ew j;

    public ri(Context context, qa qaVar, qa qaVar2, Uri uri, int i, int i2, qu quVar, Class cls) {
        this.f267a = context.getApplicationContext();
        this.b = qaVar;
        this.c = qaVar2;
        this.d = uri;
        this.e = i;
        this.f = i2;
        this.g = quVar;
        this.h = cls;
    }

    @Override // a.ew
    public final Class a() {
        return this.h;
    }

    @Override // a.ew
    public final void b() {
        ew ewVar = this.j;
        if (ewVar != null) {
            ewVar.b();
        }
    }

    public final ew c() throws Throwable {
        pz pzVarB;
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.f267a;
        qu quVar = this.g;
        int i = this.f;
        int i2 = this.e;
        if (zIsExternalStorageLegacy) {
            Uri uri = this.d;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, k, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            cursorQuery.close();
                            pzVarB = this.b.b(file, i2, i, quVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri requireOriginal = this.d;
            boolean zD = ky.d(requireOriginal);
            qa qaVar = this.c;
            if (zD && requireOriginal.getPathSegments().contains("picker")) {
                pzVarB = qaVar.b(requireOriginal, i2, i, quVar);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                pzVarB = qaVar.b(requireOriginal, i2, i, quVar);
            }
        }
        if (pzVarB != null) {
            return pzVarB.c;
        }
        return null;
    }

    @Override // a.ew
    public final void cancel() {
        this.i = true;
        ew ewVar = this.j;
        if (ewVar != null) {
            ewVar.cancel();
        }
    }

    @Override // a.ew
    public final int e() {
        return 1;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) throws Throwable {
        try {
            ew ewVarC = c();
            if (ewVarC == null) {
                evVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.d));
            } else {
                this.j = ewVarC;
                if (this.i) {
                    cancel();
                } else {
                    ewVarC.f(rfVar, evVar);
                }
            }
        } catch (FileNotFoundException e) {
            evVar.c(e);
        }
    }
}
