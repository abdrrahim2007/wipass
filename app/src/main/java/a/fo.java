package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f86a = 0;

    static {
        String property;
        int i = ux.f320a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            fn fnVar = fn.e;
            return;
        }
        fw fwVar = gp.f102a;
        lk lkVar = ox.f222a;
        lk lkVar2 = lkVar.c;
        if (lkVar == null) {
            fn fnVar2 = fn.e;
        }
    }
}
