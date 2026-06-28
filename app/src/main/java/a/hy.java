package a;

/* JADX INFO: loaded from: classes.dex */
public final class hy implements sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f127a;
    public final boolean b;
    public final sf c;
    public final hx d;
    public final nl e;
    public int f;
    public boolean g;

    public hy(sf sfVar, boolean z, boolean z2, nl nlVar, hx hxVar) {
        mk.f(sfVar, "Argument must not be null");
        this.c = sfVar;
        this.f127a = z;
        this.b = z2;
        this.e = nlVar;
        mk.f(hxVar, "Argument must not be null");
        this.d = hxVar;
    }

    @Override // a.sf
    public final int a() {
        return this.c.a();
    }

    @Override // a.sf
    public final Class b() {
        return this.c.b();
    }

    public final synchronized void c() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f++;
    }

    public final void d() {
        boolean z;
        synchronized (this) {
            int i = this.f;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.f = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            ((hq) this.d).d(this.e, this);
        }
    }

    @Override // a.sf
    public final Object get() {
        return this.c.get();
    }

    @Override // a.sf
    public final synchronized void recycle() {
        if (this.f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.b) {
            this.c.recycle();
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f127a + ", listener=" + this.d + ", key=" + this.e + ", acquired=" + this.f + ", isRecycled=" + this.g + ", resource=" + this.c + '}';
    }
}
