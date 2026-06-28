package a;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class gk implements gc {
    public final File b;
    public gj e;
    public final ah d = new ah(2);
    public final long c = 262144000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sw f100a = new sw();

    public gk(File file) {
        this.b = file;
    }

    public final synchronized gj a() {
        try {
            if (this.e == null) {
                this.e = gj.h(this.b, this.c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.e;
    }

    @Override // a.gc
    public final File e(nl nlVar) {
        String strA = this.f100a.a(nlVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Objects.toString(nlVar);
        }
        try {
            fb fbVarF = a().f(strA);
            if (fbVarF != null) {
                return ((File[]) fbVarF.b)[0];
            }
            return null;
        } catch (IOException unused) {
            Log.isLoggable("DiskLruCacheWrapper", 5);
            return null;
        }
    }

    @Override // a.gc
    public final void g(nl nlVar, z zVar) {
        ge geVar;
        boolean z;
        String strA = this.f100a.a(nlVar);
        ah ahVar = this.d;
        synchronized (ahVar) {
            geVar = (ge) ((HashMap) ahVar.b).get(strA);
            if (geVar == null) {
                ca caVar = (ca) ahVar.c;
                synchronized (caVar.f39a) {
                    geVar = (ge) caVar.f39a.poll();
                }
                if (geVar == null) {
                    geVar = new ge();
                }
                ((HashMap) ahVar.b).put(strA, geVar);
            }
            geVar.b++;
        }
        geVar.f95a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Objects.toString(nlVar);
            }
            try {
                gj gjVarA = a();
                if (gjVarA.f(strA) == null) {
                    gh ghVarD = gjVarA.d(strA);
                    if (ghVarD == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(strA));
                    }
                    try {
                        if (((hi) zVar.b).i(zVar.c, ghVarD.b(), (qu) zVar.d)) {
                            gj.a((gj) ghVarD.d, ghVarD, true);
                            ghVarD.f97a = true;
                        }
                        if (!z) {
                            try {
                                ghVarD.a();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!ghVarD.f97a) {
                            try {
                                ghVarD.a();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException unused3) {
                Log.isLoggable("DiskLruCacheWrapper", 5);
            }
        } finally {
            this.d.h(strA);
        }
    }
}
