package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class ay extends qr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f19a = AtomicReferenceFieldUpdater.newUpdater(ay.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = bs.f32a;

    @Override // a.qr
    public final Object a(Object obj) {
        Object obj2 = this._consensus;
        fb fbVar = bs.f32a;
        if (obj2 == fbVar) {
            fb fbVarC = c(obj);
            obj2 = this._consensus;
            if (obj2 == fbVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f19a;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, fbVar, fbVarC)) {
                        obj2 = fbVarC;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != fbVar) {
                        obj2 = this._consensus;
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract fb c(Object obj);
}
