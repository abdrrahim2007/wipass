package a;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class oh {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f209a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;
    public static final fb g = new fb(11, "REMOVE_FROZEN");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(oh.class, Object.class, "_next");
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(oh.class, "_state");

    public oh(int i, boolean z) {
        this.f209a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object obj) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (this.b || this.d.get(i2 & i3) == null) {
                if (f.compareAndSet(this, j, (((long) ((i2 + 1) & 1073741823)) << 30) | ((-1152921503533105153L) & j))) {
                    this.d.set(i2 & i3, obj);
                    oh ohVarE = this;
                    while ((ohVarE._state & 1152921504606846976L) != 0) {
                        ohVarE = ohVarE.e();
                        AtomicReferenceArray atomicReferenceArray = ohVarE.d;
                        int i4 = ohVarE.c & i2;
                        Object obj2 = atomicReferenceArray.get(i4);
                        if ((obj2 instanceof og) && ((og) obj2).f208a == i2) {
                            atomicReferenceArray.set(i4, obj);
                        } else {
                            ohVarE = null;
                        }
                        if (ohVarE == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i5 = this.f209a;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int c() {
        long j = this._state;
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final boolean d() {
        long j = this._state;
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final oh e() {
        long j;
        oh ohVar;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                ohVar = this;
                break;
            }
            long j2 = j | 1152921504606846976L;
            ohVar = this;
            if (f.compareAndSet(ohVar, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            oh ohVar2 = (oh) ohVar._next;
            if (ohVar2 != null) {
                return ohVar2;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            oh ohVar3 = new oh(ohVar.f209a * 2, ohVar.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = ohVar.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object ogVar = ohVar.d.get(i4);
                if (ogVar == null) {
                    ogVar = new og(i);
                }
                ohVar3.d.set(ohVar3.c & i, ogVar);
                i++;
            }
            ohVar3._state = (-1152921504606846977L) & j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, ohVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f() {
        /*
            r27 = this;
            r1 = r27
        L2:
            long r2 = r1._state
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r6
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L11
            a.fb r0 = a.oh.g
            return r0
        L11:
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r10
            int r12 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r0 = (int) r4
            int r4 = r1.c
            r0 = r0 & r4
            r4 = r4 & r12
            r13 = 0
            if (r0 != r4) goto L29
            goto L3a
        L29:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.d
            java.lang.Object r14 = r0.get(r4)
            if (r14 != 0) goto L36
            boolean r0 = r1.b
            if (r0 == 0) goto L2
            goto L3a
        L36:
            boolean r0 = r14 instanceof a.og
            if (r0 == 0) goto L3b
        L3a:
            return r13
        L3b:
            int r0 = r12 + 1
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = a.oh.f
            r15 = -1073741824(0xffffffffc0000000, double:NaN)
            long r17 = r2 & r15
            r19 = r6
            long r6 = (long) r0
            long r17 = r17 | r6
            r0 = r4
            r4 = r17
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L5f
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.d
            int r2 = r1.c
            r2 = r2 & r12
            r0.set(r2, r13)
            return r14
        L5f:
            boolean r0 = r1.b
            if (r0 == 0) goto L2
            r0 = r1
        L64:
            long r2 = r0._state
            long r4 = r2 & r10
            int r4 = (int) r4
            long r17 = r2 & r19
            int r5 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r5 == 0) goto L74
            a.oh r0 = r0.e()
            goto L8f
        L74:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r21 = a.oh.f
            long r17 = r2 & r15
            long r25 = r17 | r6
            r22 = r0
            r23 = r2
            boolean r0 = r21.compareAndSet(r22, r23, r25)
            r2 = r22
            if (r0 == 0) goto L92
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r2.d
            int r2 = r2.c
            r2 = r2 & r4
            r0.set(r2, r13)
            r0 = r13
        L8f:
            if (r0 != 0) goto L64
            return r14
        L92:
            r0 = r2
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: a.oh.f():java.lang.Object");
    }
}
