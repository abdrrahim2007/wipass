package a;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class fd implements ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f78a;
    public final Comparable b;
    public final Object c;
    public Object d;

    public /* synthetic */ fd(int i, Comparable comparable, Object obj) {
        this.f78a = i;
        this.b = comparable;
        this.c = obj;
    }

    public static fd c(Context context, Uri uri, vi viVar) {
        return new fd(2, uri, new vk(com.bumptech.glide.a.a(context).c.a().e(), viVar, com.bumptech.glide.a.a(context).d, context.getContentResolver()));
    }

    @Override // a.ew
    public final Class a() {
        switch (this.f78a) {
            case 0:
                ((ee) this.c).getClass();
                return InputStream.class;
            case 1:
                return ((iw) this.c).a();
            default:
                return InputStream.class;
        }
    }

    @Override // a.ew
    public final void b() {
        switch (this.f78a) {
            case 0:
                try {
                    ((ByteArrayInputStream) this.d).close();
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                Object obj = this.d;
                if (obj != null) {
                    try {
                        ((iw) this.c).t(obj);
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
            default:
                InputStream inputStream = (InputStream) this.d;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // a.ew
    public final void cancel() {
        int i = this.f78a;
    }

    @Override // a.ew
    public final int e() {
        switch (this.f78a) {
        }
        return 1;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) throws Throwable {
        switch (this.f78a) {
            case 0:
                try {
                    ByteArrayInputStream byteArrayInputStreamV = ee.v((String) this.b);
                    this.d = byteArrayInputStreamV;
                    evVar.d(byteArrayInputStreamV);
                } catch (IllegalArgumentException e) {
                    evVar.c(e);
                }
                break;
            case 1:
                try {
                    Object objP = ((iw) this.c).p((File) this.b);
                    this.d = objP;
                    evVar.d(objP);
                } catch (FileNotFoundException e2) {
                    Log.isLoggable("FileLoader", 3);
                    evVar.c(e2);
                    return;
                }
                break;
            default:
                try {
                    InputStream inputStreamI = i();
                    this.d = inputStreamI;
                    evVar.d(inputStreamI);
                } catch (FileNotFoundException e3) {
                    Log.isLoggable("MediaStoreThumbFetcher", 3);
                    evVar.c(e3);
                    return;
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.InputStream i() throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            java.lang.Object r1 = r11.c
            a.vk r1 = (a.vk) r1
            android.content.ContentResolver r2 = r1.c
            java.lang.Comparable r3 = r11.b
            android.net.Uri r3 = (android.net.Uri) r3
            r4 = 3
            r5 = 0
            a.vi r6 = r1.f330a     // Catch: java.lang.Throwable -> L30 java.lang.SecurityException -> L33
            android.database.Cursor r6 = r6.b(r3)     // Catch: java.lang.Throwable -> L30 java.lang.SecurityException -> L33
            if (r6 == 0) goto L29
            boolean r7 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L25 java.lang.SecurityException -> L34
            if (r7 == 0) goto L29
            r7 = 0
            java.lang.String r7 = r6.getString(r7)     // Catch: java.lang.Throwable -> L25 java.lang.SecurityException -> L34
            r6.close()
            goto L40
        L25:
            r0 = move-exception
            r5 = r6
            goto Lbf
        L29:
            if (r6 == 0) goto L2e
        L2b:
            r6.close()
        L2e:
            r7 = r5
            goto L40
        L30:
            r0 = move-exception
            goto Lbf
        L33:
            r6 = r5
        L34:
            boolean r7 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L25
            if (r7 == 0) goto L3d
            java.util.Objects.toString(r3)     // Catch: java.lang.Throwable -> L25
        L3d:
            if (r6 == 0) goto L2e
            goto L2b
        L40:
            boolean r6 = android.text.TextUtils.isEmpty(r7)
            if (r6 == 0) goto L48
        L46:
            r6 = r5
            goto L89
        L48:
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            boolean r7 = r6.exists()
            if (r7 == 0) goto L46
            r7 = 0
            long r9 = r6.length()
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 >= 0) goto L46
            android.net.Uri r6 = android.net.Uri.fromFile(r6)
            java.io.InputStream r6 = r2.openInputStream(r6)     // Catch: java.lang.NullPointerException -> L66
            goto L89
        L66:
            r0 = move-exception
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "NPE opening uri: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r3 = " -> "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            java.lang.Throwable r0 = r1.initCause(r0)
            java.io.FileNotFoundException r0 = (java.io.FileNotFoundException) r0
            throw r0
        L89:
            r7 = -1
            if (r6 == 0) goto Lb5
            java.io.InputStream r5 = r2.openInputStream(r3)     // Catch: java.lang.Throwable -> L9e java.lang.Throwable -> La0
            java.util.ArrayList r2 = r1.d     // Catch: java.lang.Throwable -> L9e java.lang.Throwable -> La0
            a.on r1 = r1.b     // Catch: java.lang.Throwable -> L9e java.lang.Throwable -> La0
            int r0 = a.bs.b(r2, r5, r1)     // Catch: java.lang.Throwable -> L9e java.lang.Throwable -> La0
            if (r5 == 0) goto Lb6
            r5.close()     // Catch: java.io.IOException -> Lb6
            goto Lb6
        L9e:
            r0 = move-exception
            goto Laf
        La0:
            boolean r0 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L9e
            if (r0 == 0) goto La9
            java.util.Objects.toString(r3)     // Catch: java.lang.Throwable -> L9e
        La9:
            if (r5 == 0) goto Lb5
            r5.close()     // Catch: java.io.IOException -> Lb5
            goto Lb5
        Laf:
            if (r5 == 0) goto Lb4
            r5.close()     // Catch: java.io.IOException -> Lb4
        Lb4:
            throw r0
        Lb5:
            r0 = r7
        Lb6:
            if (r0 == r7) goto Lbe
            a.ii r1 = new a.ii
            r1.<init>(r6, r0)
            r6 = r1
        Lbe:
            return r6
        Lbf:
            if (r5 == 0) goto Lc4
            r5.close()
        Lc4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fd.i():java.io.InputStream");
    }

    private final void d() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
