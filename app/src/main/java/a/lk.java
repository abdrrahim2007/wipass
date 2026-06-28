package a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class lk extends el implements fx {
    private volatile lk _immediate;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f167a;
    public final boolean b;
    public final lk c;

    public lk(Handler handler, boolean z) {
        this.f167a = handler;
        this.b = z;
        this._immediate = z ? this : null;
        lk lkVar = this._immediate;
        if (lkVar == null) {
            lkVar = new lk(handler, true);
            this._immediate = lkVar;
        }
        this.c = lkVar;
    }

    @Override // a.el
    public final void dispatch(ei eiVar, Runnable runnable) {
        if (this.f167a.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        mt mtVar = (mt) eiVar.get(ee.e);
        if (mtVar != null) {
            ((na) mtVar).e(cancellationException);
        }
        gp.b.dispatch(eiVar, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof lk) && ((lk) obj).f167a == this.f167a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f167a);
    }

    @Override // a.el
    public final boolean isDispatchNeeded(ei eiVar) {
        return (this.b && mk.a(Looper.myLooper(), this.f167a.getLooper())) ? false : true;
    }

    @Override // a.el
    public el limitedParallelism(int i) {
        mk.i(i);
        return this;
    }

    @Override // a.el
    public final String toString() {
        lk lkVar;
        String str;
        fw fwVar = gp.f102a;
        lk lkVar2 = ox.f222a;
        if (this == lkVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                lkVar = lkVar2.c;
            } catch (UnsupportedOperationException unused) {
                lkVar = null;
            }
            str = this == lkVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f167a.toString();
        return this.b ? pt.g(string, ".immediate") : string;
    }
}
