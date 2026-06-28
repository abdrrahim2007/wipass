package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class rr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rs f274a;

    static {
        rs rsVar = null;
        try {
            rsVar = (rs) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (rsVar == null) {
            rsVar = new rs();
        }
        f274a = rsVar;
    }
}
