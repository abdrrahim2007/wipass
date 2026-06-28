package a;

/* JADX INFO: loaded from: classes.dex */
public final class ug implements uf {
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f313a;

    public ug(Object obj) {
        this._state = obj;
    }

    public final void a(Object obj) {
        int i;
        if (obj == null) {
            obj = kz.b;
        }
        synchronized (this) {
            if (mk.a(this._state, obj)) {
                return;
            }
            this._state = obj;
            int i2 = this.f313a;
            if ((i2 & 1) != 0) {
                this.f313a = i2 + 2;
                return;
            }
            int i3 = i2 + 1;
            this.f313a = i3;
            while (true) {
                synchronized (this) {
                    i = this.f313a;
                    if (i == i3) {
                        this.f313a = i3 + 1;
                        return;
                    }
                }
                i3 = i;
            }
        }
    }
}
