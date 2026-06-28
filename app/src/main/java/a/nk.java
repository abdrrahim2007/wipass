package a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class nk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ nk[] f193a = {new nk("PUBLIC", 0), new nk("PROTECTED", 1), new nk("INTERNAL", 2), new nk("PRIVATE", 3)};

    /* JADX INFO: Fake field, exist only in values array */
    nk EF5;

    public static nk valueOf(String str) {
        return (nk) Enum.valueOf(nk.class, str);
    }

    public static nk[] values() {
        return (nk[]) f193a.clone();
    }
}
