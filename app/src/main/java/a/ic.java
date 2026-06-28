package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ic extends el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f130a;
    public boolean b;
    public as c;

    public final void b() {
        long j = this.f130a - 4294967296L;
        this.f130a = j;
        if (j <= 0 && this.b) {
            shutdown();
        }
    }

    public final void c(go goVar) {
        as asVar = this.c;
        if (asVar == null) {
            asVar = new as();
            asVar.c = new Object[16];
            this.c = asVar;
        }
        Object[] objArr = (Object[]) asVar.c;
        int i = asVar.b;
        objArr[i] = goVar;
        int length = (objArr.length - 1) & (i + 1);
        asVar.b = length;
        int i2 = asVar.f15a;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            at.n(objArr, objArr2, 0, i2, 0, 10);
            Object[] objArr3 = (Object[]) asVar.c;
            int length3 = objArr3.length;
            int i3 = asVar.f15a;
            at.n(objArr3, objArr2, length3 - i3, 0, i3, 4);
            asVar.c = objArr2;
            asVar.f15a = 0;
            asVar.b = length2;
        }
    }

    public abstract Thread d();

    public final void e(boolean z) {
        this.f130a = (z ? 4294967296L : 1L) + this.f130a;
        if (z) {
            return;
        }
        this.b = true;
    }

    public final boolean f() {
        as asVar = this.c;
        if (asVar == null) {
            return false;
        }
        int i = asVar.f15a;
        Object obj = null;
        if (i != asVar.b) {
            Object[] objArr = (Object[]) asVar.c;
            Object obj2 = objArr[i];
            objArr[i] = null;
            asVar.f15a = (i + 1) & (objArr.length - 1);
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
            }
            obj = obj2;
        }
        go goVar = (go) obj;
        if (goVar == null) {
            return false;
        }
        goVar.run();
        return true;
    }

    @Override // a.el
    public final el limitedParallelism(int i) {
        mk.i(i);
        return this;
    }

    public abstract void shutdown();
}
