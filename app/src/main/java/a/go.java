package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class go extends va {
    public int c;

    public go(int i) {
        super(0L, vd.f);
        this.c = i;
    }

    public abstract void a(Object obj, CancellationException cancellationException);

    public abstract ec b();

    public Throwable c(Object obj) {
        dn dnVar = obj instanceof dn ? (dn) obj : null;
        if (dnVar != null) {
            return dnVar.f58a;
        }
        return null;
    }

    public final void e(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            vs.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        mk.c(th);
        ky.b(b().getContext(), new es("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object f();

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r13 = this;
            a.vx r0 = a.vx.f338a
            a.vb r1 = r13.b
            a.ec r2 = r13.b()     // Catch: java.lang.Throwable -> L20
            a.gm r2 = (a.gm) r2     // Catch: java.lang.Throwable -> L20
            a.ec r3 = r2.e     // Catch: java.lang.Throwable -> L20
            java.lang.Object r2 = r2.g     // Catch: java.lang.Throwable -> L20
            a.ei r4 = r3.getContext()     // Catch: java.lang.Throwable -> L20
            java.lang.Object r2 = a.mk.p(r4, r2)     // Catch: java.lang.Throwable -> L20
            a.fb r5 = a.mk.b     // Catch: java.lang.Throwable -> L20
            r6 = 0
            if (r2 == r5) goto L23
            a.vv r5 = a.pd.n(r3, r4, r2)     // Catch: java.lang.Throwable -> L20
            goto L24
        L20:
            r2 = move-exception
            goto L9c
        L23:
            r5 = r6
        L24:
            a.ei r7 = r3.getContext()     // Catch: java.lang.Throwable -> L47
            java.lang.Object r8 = r13.f()     // Catch: java.lang.Throwable -> L47
            java.lang.Throwable r9 = r13.c(r8)     // Catch: java.lang.Throwable -> L47
            if (r9 != 0) goto L49
            int r10 = r13.c     // Catch: java.lang.Throwable -> L47
            r11 = 1
            if (r10 == r11) goto L3c
            r12 = 2
            if (r10 != r12) goto L3b
            goto L3c
        L3b:
            r11 = 0
        L3c:
            if (r11 == 0) goto L49
            a.ee r10 = a.ee.e     // Catch: java.lang.Throwable -> L47
            a.eg r7 = r7.get(r10)     // Catch: java.lang.Throwable -> L47
            a.mt r7 = (a.mt) r7     // Catch: java.lang.Throwable -> L47
            goto L4a
        L47:
            r3 = move-exception
            goto L90
        L49:
            r7 = r6
        L4a:
            if (r7 == 0) goto L63
            boolean r10 = r7.a()     // Catch: java.lang.Throwable -> L47
            if (r10 != 0) goto L63
            a.na r7 = (a.na) r7     // Catch: java.lang.Throwable -> L47
            java.util.concurrent.CancellationException r7 = r7.l()     // Catch: java.lang.Throwable -> L47
            r13.a(r8, r7)     // Catch: java.lang.Throwable -> L47
            a.st r7 = a.pd.b(r7)     // Catch: java.lang.Throwable -> L47
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L47
            goto L74
        L63:
            if (r9 == 0) goto L6d
            a.st r7 = a.pd.b(r9)     // Catch: java.lang.Throwable -> L47
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L47
            goto L74
        L6d:
            java.lang.Object r7 = r13.d(r8)     // Catch: java.lang.Throwable -> L47
            r3.resumeWith(r7)     // Catch: java.lang.Throwable -> L47
        L74:
            if (r5 == 0) goto L7c
            boolean r3 = r5.ab()     // Catch: java.lang.Throwable -> L20
            if (r3 == 0) goto L7f
        L7c:
            a.mk.n(r4, r2)     // Catch: java.lang.Throwable -> L20
        L7f:
            r1.getClass()     // Catch: java.lang.Throwable -> L83
            goto L88
        L83:
            r0 = move-exception
            a.st r0 = a.pd.b(r0)
        L88:
            java.lang.Throwable r0 = a.su.a(r0)
            r13.e(r6, r0)
            goto Lac
        L90:
            if (r5 == 0) goto L98
            boolean r5 = r5.ab()     // Catch: java.lang.Throwable -> L20
            if (r5 == 0) goto L9b
        L98:
            a.mk.n(r4, r2)     // Catch: java.lang.Throwable -> L20
        L9b:
            throw r3     // Catch: java.lang.Throwable -> L20
        L9c:
            r1.getClass()     // Catch: java.lang.Throwable -> La0
            goto La5
        La0:
            r0 = move-exception
            a.st r0 = a.pd.b(r0)
        La5:
            java.lang.Throwable r0 = a.su.a(r0)
            r13.e(r2, r0)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.go.run():void");
    }

    public Object d(Object obj) {
        return obj;
    }
}
