package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class of {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f207a = AtomicReferenceFieldUpdater.newUpdater(of.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur = new oh(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            oh ohVar = (oh) this._cur;
            int iA = ohVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f207a;
                oh ohVarE = ohVar.e();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, ohVar, ohVarE) && atomicReferenceFieldUpdater.get(this) == ohVar) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            oh ohVar = (oh) this._cur;
            if (ohVar.b()) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f207a;
            oh ohVarE = ohVar.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, ohVar, ohVarE) && atomicReferenceFieldUpdater.get(this) == ohVar) {
            }
        }
    }

    public final int c() {
        return ((oh) this._cur).c();
    }

    public final Object d() {
        while (true) {
            oh ohVar = (oh) this._cur;
            Object objF = ohVar.f();
            if (objF != oh.g) {
                return objF;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f207a;
            oh ohVarE = ohVar.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, ohVar, ohVarE) && atomicReferenceFieldUpdater.get(this) == ohVar) {
            }
        }
    }
}
