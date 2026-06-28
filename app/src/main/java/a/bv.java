package a;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class bv implements qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f34a;
    public final Object b;

    public /* synthetic */ bv(int i, Object obj) {
        this.f34a = i;
        this.b = obj;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        switch (this.f34a) {
            case 0:
                return true;
            case 1:
                return obj.toString().startsWith("data:image");
            default:
                return true;
        }
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        switch (this.f34a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                return new pz(new qq(bArr), new pr(1, bArr, (bu) this.b));
            case 1:
                return new pz(new qq(obj), new fd(0, obj.toString(), (ee) this.b));
            default:
                File file = (File) obj;
                return new pz(new qq(file), new fd(1, file, (iw) this.b));
        }
    }
}
