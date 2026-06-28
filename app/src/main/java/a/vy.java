package a;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class vy implements qa {
    public static final vy b = new vy(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f339a;

    public /* synthetic */ vy(int i) {
        this.f339a = i;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        switch (this.f339a) {
            case 0:
                return true;
            case 1:
                return true;
            default:
                return false;
        }
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        switch (this.f339a) {
            case 0:
                return new pz(new qq(obj), new bz(1, obj));
            case 1:
                File file = (File) obj;
                return new pz(new qq(file), new bz(0, file));
            default:
                return null;
        }
    }
}
