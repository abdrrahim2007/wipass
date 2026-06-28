package a;

/* JADX INFO: loaded from: classes.dex */
public final class hr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f123a;
    public final ts b;
    public final /* synthetic */ hu c;

    public /* synthetic */ hr(hu huVar, ts tsVar, int i) {
        this.f123a = i;
        this.c = huVar;
        this.b = tsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cj cjVar;
        switch (this.f123a) {
            case 0:
                ts tsVar = this.b;
                tsVar.f302a.a();
                synchronized (tsVar.b) {
                    synchronized (this.c) {
                        try {
                            if (this.c.f126a.f125a.contains(new hs(this.b, vs.b))) {
                                hu huVar = this.c;
                                ts tsVar2 = this.b;
                                huVar.getClass();
                                try {
                                    tsVar2.h(huVar.q, 5);
                                } finally {
                                }
                            }
                            this.c.d();
                        } finally {
                        }
                        break;
                    }
                }
                return;
            default:
                ts tsVar3 = this.b;
                tsVar3.f302a.a();
                synchronized (tsVar3.b) {
                    synchronized (this.c) {
                        try {
                            if (this.c.f126a.f125a.contains(new hs(this.b, vs.b))) {
                                this.c.s.c();
                                hu huVar2 = this.c;
                                ts tsVar4 = this.b;
                                huVar2.getClass();
                                try {
                                    tsVar4.j(huVar2.s, huVar2.o, huVar2.v);
                                    this.c.h(this.b);
                                } finally {
                                }
                            }
                            this.c.d();
                        } finally {
                        }
                    }
                }
                return;
        }
    }
}
