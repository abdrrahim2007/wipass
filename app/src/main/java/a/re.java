package a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class re {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final re f263a;
    public static final /* synthetic */ re[] b;

    /* JADX INFO: Fake field, exist only in values array */
    re EF0;

    static {
        re reVar = new re("SRGB", 0);
        re reVar2 = new re("DISPLAY_P3", 1);
        f263a = reVar2;
        b = new re[]{reVar, reVar2};
    }

    public static re valueOf(String str) {
        return (re) Enum.valueOf(re.class, str);
    }

    public static re[] values() {
        return (re[]) b.clone();
    }
}
