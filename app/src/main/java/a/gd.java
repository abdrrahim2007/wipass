package a;

/* JADX INFO: loaded from: classes.dex */
public final class gd {
    public static final gd b = new gd(0);
    public static final gd c = new gd(1);
    public static final gd d = new gd(2);
    public static final gd e = new gd(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f94a;

    public /* synthetic */ gd(int i) {
        this.f94a = i;
    }

    public final boolean a(int i) {
        switch (this.f94a) {
            case 0:
                break;
            case 1:
                if (i == 3 || i == 5) {
                }
                break;
            case 2:
                break;
            default:
                if (i == 2) {
                }
                break;
        }
        return false;
    }
}
