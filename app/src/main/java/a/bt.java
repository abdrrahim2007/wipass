package a;

/* JADX INFO: loaded from: classes.dex */
public final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f33a;

    public final int a(Object obj) {
        switch (this.f33a) {
            case 0:
                return ((byte[]) obj).length;
            default:
                return ((int[]) obj).length;
        }
    }

    public final int b() {
        switch (this.f33a) {
            case 0:
                return 1;
            default:
                return 4;
        }
    }

    public final String c() {
        switch (this.f33a) {
            case 0:
                return "ByteArrayPool";
            default:
                return "IntegerArrayPool";
        }
    }
}
