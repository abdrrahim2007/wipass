package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class xf {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(xf.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(xf.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(xf.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(xf.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f365a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public final va a(va vaVar) {
        if (vaVar.b.f324a == 1) {
            e.incrementAndGet(this);
        }
        if (this.producerIndex - this.consumerIndex == 127) {
            return vaVar;
        }
        int i = this.producerIndex & 127;
        while (this.f365a.get(i) != null) {
            Thread.yield();
        }
        this.f365a.lazySet(i, vaVar);
        c.incrementAndGet(this);
        return null;
    }

    public final int b() {
        return this.lastScheduledTask != null ? (this.producerIndex - this.consumerIndex) + 1 : this.producerIndex - this.consumerIndex;
    }

    public final va c() {
        va vaVar;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (vaVar = (va) this.f365a.getAndSet(i2, null)) != null) {
                if (vaVar.b.f324a == 1) {
                    e.decrementAndGet(this);
                }
                return vaVar;
            }
        }
    }

    public final long d(xf xfVar) {
        int i = xfVar.producerIndex;
        AtomicReferenceArray atomicReferenceArray = xfVar.f365a;
        for (int i2 = xfVar.consumerIndex; i2 != i; i2++) {
            int i3 = i2 & 127;
            if (xfVar.blockingTasksInBuffer == 0) {
                break;
            }
            va vaVar = (va) atomicReferenceArray.get(i3);
            if (vaVar != null && vaVar.b.f324a == 1) {
                while (!atomicReferenceArray.compareAndSet(i3, vaVar, null)) {
                    if (atomicReferenceArray.get(i3) != vaVar) {
                        break;
                    }
                }
                e.decrementAndGet(xfVar);
                va vaVar2 = (va) b.getAndSet(this, vaVar);
                if (vaVar2 == null) {
                    return -1L;
                }
                a(vaVar2);
                return -1L;
            }
        }
        return e(xfVar, true);
    }

    public final long e(xf xfVar, boolean z) {
        while (true) {
            va vaVar = (va) xfVar.lastScheduledTask;
            if (vaVar == null) {
                return -2L;
            }
            if (z && vaVar.b.f324a != 1) {
                return -2L;
            }
            vd.e.getClass();
            long jNanoTime = System.nanoTime() - vaVar.f323a;
            long j = vd.f325a;
            if (jNanoTime < j) {
                return j - jNanoTime;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b;
            while (!atomicReferenceFieldUpdater.compareAndSet(xfVar, vaVar, null)) {
                if (atomicReferenceFieldUpdater.get(xfVar) != vaVar) {
                    break;
                }
            }
            va vaVar2 = (va) b.getAndSet(this, vaVar);
            if (vaVar2 == null) {
                return -1L;
            }
            a(vaVar2);
            return -1L;
        }
    }
}
