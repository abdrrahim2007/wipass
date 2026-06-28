package a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class rf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rf f264a;
    public static final rf b;
    public static final rf c;
    public static final rf d;
    public static final /* synthetic */ rf[] e;

    static {
        rf rfVar = new rf("IMMEDIATE", 0);
        f264a = rfVar;
        rf rfVar2 = new rf("HIGH", 1);
        b = rfVar2;
        rf rfVar3 = new rf("NORMAL", 2);
        c = rfVar3;
        rf rfVar4 = new rf("LOW", 3);
        d = rfVar4;
        e = new rf[]{rfVar, rfVar2, rfVar3, rfVar4};
    }

    public static rf valueOf(String str) {
        return (rf) Enum.valueOf(rf.class, str);
    }

    public static rf[] values() {
        return (rf[]) e.clone();
    }
}
