package a;

import android.os.SystemClock;
import android.util.Log;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class uc implements ey, ex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fh f311a;
    public final fj b;
    public volatile int c;
    public volatile et d;
    public volatile Object e;
    public volatile pz f;
    public volatile eu g;

    public uc(fh fhVar, fj fjVar) {
        this.f311a = fhVar;
        this.b = fjVar;
    }

    @Override // a.ex
    public final void a(nl nlVar, Object obj, ew ewVar, int i, nl nlVar2) {
        this.b.a(nlVar, obj, ewVar, this.f.c.e(), nlVar);
    }

    @Override // a.ex
    public final void b(nl nlVar, Exception exc, ew ewVar, int i) {
        this.b.b(nlVar, exc, ewVar, this.f.c.e());
    }

    public final boolean c(Object obj) throws Throwable {
        Throwable th;
        int i = oj.f211a;
        SystemClock.elapsedRealtimeNanos();
        boolean z = false;
        try {
            fa faVarG = this.f311a.c.a().g(obj);
            Object objG = faVarG.g();
            hi hiVarD = this.f311a.d(objG);
            z zVar = new z(hiVarD, objG, this.f311a.i, 1);
            nl nlVar = this.f.f247a;
            fh fhVar = this.f311a;
            eu euVar = new eu(nlVar, fhVar.n);
            gc gcVarA = fhVar.h.a();
            gcVarA.g(euVar, zVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                euVar.toString();
                obj.toString();
                hiVarD.toString();
                SystemClock.elapsedRealtimeNanos();
            }
            if (gcVarA.e(euVar) != null) {
                this.g = euVar;
                this.d = new et(Collections.singletonList(this.f.f247a), this.f311a, this);
                this.f.c.b();
                return true;
            }
            if (Log.isLoggable("SourceGenerator", 3)) {
                Objects.toString(this.g);
                obj.toString();
            }
            try {
                this.b.a(this.f.f247a, faVarG.g(), this.f.c, this.f.c.e(), this.f.f247a);
                return false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    throw th;
                }
                this.f.c.b();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // a.ey
    public final void cancel() {
        pz pzVar = this.f;
        if (pzVar != null) {
            pzVar.c.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
    @Override // a.ey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.e
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L17
            java.lang.Object r0 = r5.e
            r5.e = r1
            boolean r0 = r5.c(r0)     // Catch: java.io.IOException -> L11
            if (r0 != 0) goto L17
            goto L23
        L11:
            java.lang.String r0 = "SourceGenerator"
            r3 = 3
            android.util.Log.isLoggable(r0, r3)
        L17:
            a.et r0 = r5.d
            if (r0 == 0) goto L24
            a.et r0 = r5.d
            boolean r0 = r0.e()
            if (r0 == 0) goto L24
        L23:
            return r2
        L24:
            r5.d = r1
            r5.f = r1
            r0 = 0
        L29:
            if (r0 != 0) goto L87
            int r1 = r5.c
            a.fh r3 = r5.f311a
            java.util.ArrayList r3 = r3.b()
            int r3 = r3.size()
            if (r1 >= r3) goto L87
            a.fh r1 = r5.f311a
            java.util.ArrayList r1 = r1.b()
            int r3 = r5.c
            int r4 = r3 + 1
            r5.c = r4
            java.lang.Object r1 = r1.get(r3)
            a.pz r1 = (a.pz) r1
            r5.f = r1
            a.pz r1 = r5.f
            if (r1 == 0) goto L29
            a.fh r1 = r5.f311a
            a.gd r1 = r1.p
            a.pz r3 = r5.f
            a.ew r3 = r3.c
            int r3 = r3.e()
            boolean r1 = r1.a(r3)
            if (r1 != 0) goto L73
            a.fh r1 = r5.f311a
            a.pz r3 = r5.f
            a.ew r3 = r3.c
            java.lang.Class r3 = r3.a()
            a.oa r1 = r1.c(r3)
            if (r1 == 0) goto L29
        L73:
            a.pz r0 = r5.f
            a.pz r1 = r5.f
            a.ew r1 = r1.c
            a.fh r3 = r5.f311a
            a.rf r3 = r3.o
            a.ah r4 = new a.ah
            r4.<init>(r5, r0)
            r1.f(r3, r4)
            r0 = r2
            goto L29
        L87:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.uc.e():boolean");
    }
}
