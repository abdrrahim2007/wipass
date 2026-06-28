package a;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class et implements ey, ev {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f75a;
    public final fh b;
    public final ex c;
    public int d = -1;
    public nl e;
    public List f;
    public int g;
    public volatile pz h;
    public File i;

    public et(List list, fh fhVar, ex exVar) {
        this.f75a = list;
        this.b = fhVar;
        this.c = exVar;
    }

    @Override // a.ev
    public final void c(Exception exc) {
        this.c.b(this.e, exc, this.h.c, 3);
    }

    @Override // a.ey
    public final void cancel() {
        pz pzVar = this.h;
        if (pzVar != null) {
            pzVar.c.cancel();
        }
    }

    @Override // a.ev
    public final void d(Object obj) {
        this.c.a(this.e, obj, this.h.c, 3, this.e);
    }

    @Override // a.ey
    public final boolean e() {
        while (true) {
            List list = this.f;
            boolean z = false;
            if (list != null && this.g < list.size()) {
                this.h = null;
                while (!z && this.g < this.f.size()) {
                    List list2 = this.f;
                    int i = this.g;
                    this.g = i + 1;
                    qa qaVar = (qa) list2.get(i);
                    File file = this.i;
                    fh fhVar = this.b;
                    this.h = qaVar.b(file, fhVar.e, fhVar.f, fhVar.i);
                    if (this.h != null && this.b.c(this.h.c.a()) != null) {
                        this.h.c.f(this.b.o, this);
                        z = true;
                    }
                }
                return z;
            }
            int i2 = this.d + 1;
            this.d = i2;
            if (i2 >= this.f75a.size()) {
                return false;
            }
            nl nlVar = (nl) this.f75a.get(this.d);
            fh fhVar2 = this.b;
            File fileE = fhVar2.h.a().e(new eu(nlVar, fhVar2.n));
            this.i = fileE;
            if (fileE != null) {
                this.e = nlVar;
                this.f = this.b.c.a().f(fileE);
                this.g = 0;
            }
        }
    }
}
