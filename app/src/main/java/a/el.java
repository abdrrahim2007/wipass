package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class el extends g implements ef {
    public static final ek Key = new ek(ee.b, ej.f69a);

    public el() {
        super(ee.b);
    }

    public abstract void dispatch(ei eiVar, Runnable runnable);

    public void dispatchYield(ei eiVar, Runnable runnable) {
        dispatch(eiVar, runnable);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [a.js, a.nm] */
    @Override // a.g, a.ei
    public <E extends eg> E get(eh ehVar) {
        E e;
        mk.h(ehVar, "key");
        if (ehVar instanceof ek) {
            ek ekVar = (ek) ehVar;
            eh key = getKey();
            mk.h(key, "key");
            if ((key == ekVar || ekVar.b == key) && (e = (E) ekVar.f70a.invoke(this)) != null) {
                return e;
            }
        } else if (ee.b == ehVar) {
            return this;
        }
        return null;
    }

    @Override // a.ef
    public final <T> ec interceptContinuation(ec ecVar) {
        return new gm(this, ecVar);
    }

    public boolean isDispatchNeeded(ei eiVar) {
        return !(this instanceof vu);
    }

    public el limitedParallelism(int i) {
        mk.i(i);
        return new nv(this, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (((a.eg) r3.f70a.invoke(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (a.ee.b == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        return a.hb.f109a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        return r2;
     */
    /* JADX WARN: Type inference failed for: r3v3, types: [a.js, a.nm] */
    @Override // a.g, a.ei
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a.ei minusKey(a.eh r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            a.mk.h(r3, r0)
            boolean r1 = r3 instanceof a.ek
            if (r1 == 0) goto L25
            a.ek r3 = (a.ek) r3
            a.eh r1 = r2.getKey()
            a.mk.h(r1, r0)
            if (r1 == r3) goto L1a
            a.eh r0 = r3.b
            if (r0 != r1) goto L19
            goto L1a
        L19:
            return r2
        L1a:
            a.nm r3 = r3.f70a
            java.lang.Object r3 = r3.invoke(r2)
            a.eg r3 = (a.eg) r3
            if (r3 == 0) goto L2c
            goto L29
        L25:
            a.ee r0 = a.ee.b
            if (r0 != r3) goto L2c
        L29:
            a.hb r3 = a.hb.f109a
            return r3
        L2c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.el.minusKey(a.eh):a.ei");
    }

    @Override // a.ef
    public final void releaseInterceptedContinuation(ec ecVar) {
        ((gm) ecVar).i();
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + pd.d(this);
    }

    public final el plus(el elVar) {
        return elVar;
    }
}
