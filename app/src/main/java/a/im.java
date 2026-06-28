package a;

import android.util.Log;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes.dex */
public final class im implements Pools.Pool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final il f134a;
    public final io b;
    public final Pools.SynchronizedPool c;

    public im(Pools.SynchronizedPool synchronizedPool, il ilVar, io ioVar) {
        this.c = synchronizedPool;
        this.f134a = ilVar;
        this.b = ioVar;
    }

    @Override // androidx.core.util.Pools.Pool
    public final Object acquire() {
        Object objAcquire = this.c.acquire();
        if (objAcquire == null) {
            objAcquire = this.f134a.b();
            if (Log.isLoggable("FactoryPools", 2)) {
                objAcquire.getClass().toString();
            }
        }
        if (objAcquire instanceof in) {
            ((in) objAcquire).c().f314a = false;
        }
        return objAcquire;
    }

    @Override // androidx.core.util.Pools.Pool
    public final boolean release(Object obj) {
        if (obj instanceof in) {
            ((in) obj).c().f314a = true;
        }
        this.b.f(obj);
        return this.c.release(obj);
    }
}
