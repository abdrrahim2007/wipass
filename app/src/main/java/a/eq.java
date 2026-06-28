package a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class eq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final eq f74a;
    public static final /* synthetic */ eq[] b;

    static {
        eq eqVar = new eq("COROUTINE_SUSPENDED", 0);
        f74a = eqVar;
        b = new eq[]{eqVar, new eq("UNDECIDED", 1), new eq("RESUMED", 2)};
    }

    public static eq valueOf(String str) {
        return (eq) Enum.valueOf(eq.class, str);
    }

    public static eq[] values() {
        return (eq[]) b.clone();
    }
}
