package a;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class ky {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fb f159a;
    public static final fb b;
    public static final z c;
    public static z d;

    static {
        int i = 11;
        f159a = new fb(i, "UNDEFINED");
        b = new fb(i, "REUSABLE_CLAIMED");
        Object obj = null;
        c = new z(obj, obj, obj, 8);
    }

    public static void a(mt mtVar) {
        na naVar = (na) mtVar;
        naVar.getClass();
        naVar.e(new mu(naVar.g(), null, naVar));
    }

    public static final void b(ei eiVar, Throwable th) {
        try {
            ac acVar = (ac) eiVar.get(ee.c);
            if (acVar != null) {
                acVar.b(th);
            } else {
                em.a(eiVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                vs.a(runtimeException, th);
                th = runtimeException;
            }
            em.a(eiVar, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a.gq c(a.mt r9, a.mw r10, int r11) {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ky.c(a.mt, a.mw, int):a.gq");
    }

    public static boolean d(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static tg e(jw jwVar) {
        tg tgVar = new tg();
        tgVar.d = pd.a(tgVar, tgVar, jwVar);
        return tgVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0090 A[Catch: all -> 0x006f, DONT_GENERATE, TryCatch #2 {all -> 0x006f, blocks: (B:16:0x004a, B:18:0x0058, B:20:0x005e, B:33:0x0093, B:23:0x0071, B:25:0x007f, B:30:0x008a, B:32:0x0090, B:38:0x00a0, B:41:0x00a9, B:40:0x00a6, B:28:0x0085), top: B:54:0x004a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(java.lang.Object r9, a.ec r10) {
        /*
            boolean r0 = r10 instanceof a.gm
            if (r0 == 0) goto Lb4
            a.gm r10 = (a.gm) r10
            a.el r0 = r10.d
            a.ec r1 = r10.e
            java.lang.Throwable r2 = a.su.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            a.dn r3 = new a.dn
            r4 = 0
            r3.<init>(r4, r2)
        L18:
            a.ei r2 = r1.getContext()
            boolean r2 = r0.isDispatchNeeded(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f = r3
            r10.c = r4
            a.ei r9 = r1.getContext()
            r0.dispatch(r9, r10)
            return
        L2f:
            a.ic r0 = a.vf.a()
            long r5 = r0.f130a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r10.f = r3
            r10.c = r4
            r0.c(r10)
            goto Lae
        L46:
            r0.e(r4)
            r2 = 0
            a.ei r4 = r1.getContext()     // Catch: java.lang.Throwable -> L6f
            a.ee r5 = a.ee.e     // Catch: java.lang.Throwable -> L6f
            a.eg r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L6f
            a.mt r4 = (a.mt) r4     // Catch: java.lang.Throwable -> L6f
            if (r4 == 0) goto L71
            boolean r5 = r4.a()     // Catch: java.lang.Throwable -> L6f
            if (r5 != 0) goto L71
            a.na r4 = (a.na) r4     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.CancellationException r9 = r4.l()     // Catch: java.lang.Throwable -> L6f
            r10.a(r3, r9)     // Catch: java.lang.Throwable -> L6f
            a.st r9 = a.pd.b(r9)     // Catch: java.lang.Throwable -> L6f
            r10.resumeWith(r9)     // Catch: java.lang.Throwable -> L6f
            goto L93
        L6f:
            r9 = move-exception
            goto Laa
        L71:
            java.lang.Object r3 = r10.g     // Catch: java.lang.Throwable -> L6f
            a.ei r4 = r1.getContext()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r3 = a.mk.p(r4, r3)     // Catch: java.lang.Throwable -> L6f
            a.fb r5 = a.mk.b     // Catch: java.lang.Throwable -> L6f
            if (r3 == r5) goto L84
            a.vv r5 = a.pd.n(r1, r4, r3)     // Catch: java.lang.Throwable -> L6f
            goto L85
        L84:
            r5 = r2
        L85:
            r1.resumeWith(r9)     // Catch: java.lang.Throwable -> L9d
            if (r5 == 0) goto L90
            boolean r9 = r5.ab()     // Catch: java.lang.Throwable -> L6f
            if (r9 == 0) goto L93
        L90:
            a.mk.n(r4, r3)     // Catch: java.lang.Throwable -> L6f
        L93:
            boolean r9 = r0.f()     // Catch: java.lang.Throwable -> L6f
            if (r9 != 0) goto L93
        L99:
            r0.b()
            goto Lae
        L9d:
            r9 = move-exception
            if (r5 == 0) goto La6
            boolean r1 = r5.ab()     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto La9
        La6:
            a.mk.n(r4, r3)     // Catch: java.lang.Throwable -> L6f
        La9:
            throw r9     // Catch: java.lang.Throwable -> L6f
        Laa:
            r10.e(r9, r2)     // Catch: java.lang.Throwable -> Laf
            goto L99
        Lae:
            return
        Laf:
            r9 = move-exception
            r0.b()
            throw r9
        Lb4:
            r10.resumeWith(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ky.f(java.lang.Object, a.ec):void");
    }

    public static void h(jw jwVar, f fVar, f fVar2) {
        try {
            f(vx.f338a, pd.e(pd.a(fVar, fVar2, jwVar)));
        } catch (Throwable th) {
            fVar2.resumeWith(pd.b(th));
            throw th;
        }
    }
}
