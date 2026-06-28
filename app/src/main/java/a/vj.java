package a;

/* JADX INFO: loaded from: classes.dex */
public final class vj implements rz, rw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rz f329a;
    public final Object b;
    public volatile ts c;
    public volatile rw d;
    public int e = 3;
    public int f = 3;
    public boolean g;

    public vj(Object obj, rz rzVar) {
        this.b = obj;
        this.f329a = rzVar;
    }

    @Override // a.rz, a.rw
    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.d.a() || this.c.a();
            } finally {
            }
        }
        return z;
    }

    @Override // a.rw
    public final boolean b() {
        boolean z;
        synchronized (this.b) {
            z = this.e == 3;
        }
        return z;
    }

    @Override // a.rw
    public final boolean c(rw rwVar) {
        if (!(rwVar instanceof vj)) {
            return false;
        }
        vj vjVar = (vj) rwVar;
        if (this.c == null) {
            if (vjVar.c != null) {
                return false;
            }
        } else if (!this.c.c(vjVar.c)) {
            return false;
        }
        return this.d == null ? vjVar.d == null : this.d.c(vjVar.d);
    }

    @Override // a.rw
    public final void clear() {
        synchronized (this.b) {
            this.g = false;
            this.e = 3;
            this.f = 3;
            this.d.clear();
            this.c.clear();
        }
    }

    @Override // a.rw
    public final void d() {
        synchronized (this.b) {
            try {
                if (!pt.a(this.f)) {
                    this.f = 2;
                    this.d.d();
                }
                if (!pt.a(this.e)) {
                    this.e = 2;
                    this.c.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rz
    public final void e(rw rwVar) {
        synchronized (this.b) {
            try {
                if (rwVar.equals(this.d)) {
                    this.f = 4;
                    return;
                }
                this.e = 4;
                rz rzVar = this.f329a;
                if (rzVar != null) {
                    rzVar.e(this);
                }
                if (!pt.a(this.f)) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rw
    public final void f() {
        synchronized (this.b) {
            try {
                this.g = true;
                try {
                    if (this.e != 4 && this.f != 1) {
                        this.f = 1;
                        this.d.f();
                    }
                    if (this.g && this.e != 1) {
                        this.e = 1;
                        this.c.f();
                    }
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // a.rz
    public final boolean g(rw rwVar) {
        boolean z;
        synchronized (this.b) {
            try {
                rz rzVar = this.f329a;
                z = (rzVar == null || rzVar.g(this)) && (rwVar.equals(this.c) || this.e != 4);
            } finally {
            }
        }
        return z;
    }

    @Override // a.rz
    public final rz getRoot() {
        rz root;
        synchronized (this.b) {
            try {
                rz rzVar = this.f329a;
                root = rzVar != null ? rzVar.getRoot() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return root;
    }

    @Override // a.rz
    public final boolean h(rw rwVar) {
        boolean z;
        synchronized (this.b) {
            try {
                rz rzVar = this.f329a;
                z = (rzVar == null || rzVar.h(this)) && rwVar.equals(this.c) && !a();
            } finally {
            }
        }
        return z;
    }

    @Override // a.rw
    public final boolean i() {
        boolean z;
        synchronized (this.b) {
            z = this.e == 4;
        }
        return z;
    }

    @Override // a.rw
    public final boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = true;
            if (this.e != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // a.rz
    public final boolean j(rw rwVar) {
        boolean z;
        synchronized (this.b) {
            try {
                rz rzVar = this.f329a;
                z = (rzVar == null || rzVar.j(this)) && rwVar.equals(this.c) && this.e != 2;
            } finally {
            }
        }
        return z;
    }

    @Override // a.rz
    public final void k(rw rwVar) {
        synchronized (this.b) {
            try {
                if (!rwVar.equals(this.c)) {
                    this.f = 5;
                    return;
                }
                this.e = 5;
                rz rzVar = this.f329a;
                if (rzVar != null) {
                    rzVar.k(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
