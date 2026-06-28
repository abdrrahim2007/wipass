package a;

/* JADX INFO: loaded from: classes.dex */
public final class oi implements sf, in {
    public static final im e = ip.a(20, new kn(5));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uh f210a = new uh();
    public sf b;
    public boolean c;
    public boolean d;

    @Override // a.sf
    public final int a() {
        return this.b.a();
    }

    @Override // a.sf
    public final Class b() {
        return this.b.b();
    }

    @Override // a.in
    public final uh c() {
        return this.f210a;
    }

    public final synchronized void d() {
        this.f210a.a();
        if (!this.c) {
            throw new IllegalStateException("Already unlocked");
        }
        this.c = false;
        if (this.d) {
            recycle();
        }
    }

    @Override // a.sf
    public final Object get() {
        return this.b.get();
    }

    @Override // a.sf
    public final synchronized void recycle() {
        this.f210a.a();
        this.d = true;
        if (!this.c) {
            this.b.recycle();
            this.b = null;
            e.release(this);
        }
    }
}
