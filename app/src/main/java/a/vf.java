package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class vf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f326a = new ThreadLocal();

    public static ic a() {
        ThreadLocal threadLocal = f326a;
        ic icVar = (ic) threadLocal.get();
        if (icVar != null) {
            return icVar;
        }
        bm bmVar = new bm(Thread.currentThread());
        threadLocal.set(bmVar);
        return bmVar;
    }
}
