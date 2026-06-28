package a;

/* JADX INFO: loaded from: classes.dex */
public final class hz implements rz, rw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f128a;
    public final rz b;
    public volatile rw c;
    public volatile rw d;
    public int e = 3;
    public int f = 3;

    public hz(Object obj, rz rzVar) {
        this.f128a = obj;
        this.b = rzVar;
    }

    @Override // a.rz, a.rw
    public final boolean a() {
        boolean z;
        synchronized (this.f128a) {
            try {
                z = this.c.a() || this.d.a();
            } finally {
            }
        }
        return z;
    }

    @Override // a.rw
    public final boolean b() {
        boolean z;
        synchronized (this.f128a) {
            try {
                z = this.e == 3 && this.f == 3;
            } finally {
            }
        }
        return z;
    }

    @Override // a.rw
    public final boolean c(rw rwVar) {
        if (rwVar instanceof hz) {
            hz hzVar = (hz) rwVar;
            if (this.c.c(hzVar.c) && this.d.c(hzVar.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.rw
    public final void clear() {
        synchronized (this.f128a) {
            try {
                this.e = 3;
                this.c.clear();
                if (this.f != 3) {
                    this.f = 3;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rw
    public final void d() {
        synchronized (this.f128a) {
            try {
                if (this.e == 1) {
                    this.e = 2;
                    this.c.d();
                }
                if (this.f == 1) {
                    this.f = 2;
                    this.d.d();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rz
    public final void e(rw rwVar) {
        synchronized (this.f128a) {
            try {
                if (rwVar.equals(this.c)) {
                    this.e = 4;
                } else if (rwVar.equals(this.d)) {
                    this.f = 4;
                }
                rz rzVar = this.b;
                if (rzVar != null) {
                    rzVar.e(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rw
    public final void f() {
        synchronized (this.f128a) {
            try {
                if (this.e != 1) {
                    this.e = 1;
                    this.c.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // a.rz
    public final boolean g(rw rwVar) {
        boolean z;
        synchronized (this.f128a) {
            rz rzVar = this.b;
            z = rzVar == null || rzVar.g(this);
        }
        return z;
    }

    @Override // a.rz
    public final rz getRoot() {
        rz root;
        synchronized (this.f128a) {
            try {
                rz rzVar = this.b;
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
        int i;
        synchronized (this.f128a) {
            rz rzVar = this.b;
            z = false;
            if (rzVar == null || rzVar.h(this)) {
                if (this.e != 5 ? rwVar.equals(this.c) : rwVar.equals(this.d) && ((i = this.f) == 4 || i == 5)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // a.rw
    public final boolean i() {
        boolean z;
        synchronized (this.f128a) {
            try {
                z = this.e == 4 || this.f == 4;
            } finally {
            }
        }
        return z;
    }

    @Override // a.rw
    public final boolean isRunning() {
        boolean z;
        synchronized (this.f128a) {
            try {
                z = true;
                if (this.e != 1 && this.f != 1) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // a.rz
    public final boolean j(rw rwVar) {
        boolean z;
        synchronized (this.f128a) {
            rz rzVar = this.b;
            z = (rzVar == null || rzVar.j(this)) && rwVar.equals(this.c);
        }
        return z;
    }

    @Override // a.rz
    public final void k(rw rwVar) {
        synchronized (this.f128a) {
            try {
                if (rwVar.equals(this.d)) {
                    this.f = 5;
                    rz rzVar = this.b;
                    if (rzVar != null) {
                        rzVar.k(this);
                    }
                    return;
                }
                this.e = 5;
                if (this.f != 1) {
                    this.f = 1;
                    this.d.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
