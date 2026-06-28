package a;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class iy implements tf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f138a;
    public final Object b;

    public /* synthetic */ iy(int i, Object obj) {
        this.f138a = i;
        this.b = obj;
    }

    @Override // a.tf
    public final Iterator iterator() {
        switch (this.f138a) {
            case 0:
                return new ix(this);
            case 1:
                return ky.e((jw) this.b);
            default:
                return (Iterator) this.b;
        }
    }
}
