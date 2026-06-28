package a;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class lq implements qa {
    public static final qt b = qt.a(2500, "com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb f171a;

    public lq(fb fbVar) {
        this.f171a = fbVar;
    }

    @Override // a.qa
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        lh lhVar = (lh) obj;
        fb fbVar = this.f171a;
        if (fbVar != null) {
            px pxVar = (px) fbVar.b;
            py pyVarA = py.a(lhVar);
            Object objA = pxVar.a(pyVarA);
            ArrayDeque arrayDeque = py.b;
            synchronized (arrayDeque) {
                arrayDeque.offer(pyVarA);
            }
            lh lhVar2 = (lh) objA;
            if (lhVar2 == null) {
                pxVar.d(py.a(lhVar), lhVar);
            } else {
                lhVar = lhVar2;
            }
        }
        return new pz(lhVar, new lr(lhVar, ((Integer) quVar.c(b)).intValue()));
    }
}
