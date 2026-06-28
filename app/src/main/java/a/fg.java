package a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class fg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fg f80a;
    public static final fg b;
    public static final fg c;
    public static final /* synthetic */ fg[] d;

    static {
        fg fgVar = new fg("PREFER_ARGB_8888", 0);
        f80a = fgVar;
        fg fgVar2 = new fg("PREFER_RGB_565", 1);
        b = fgVar2;
        d = new fg[]{fgVar, fgVar2};
        c = fgVar;
    }

    public static fg valueOf(String str) {
        return (fg) Enum.valueOf(fg.class, str);
    }

    public static fg[] values() {
        return (fg[]) d.clone();
    }
}
