package a;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public abstract class ba implements qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21a;

    public ba() {
        char[] cArr = wh.f346a;
        this.f21a = new ArrayDeque(20);
    }

    public void a(rc rcVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f21a;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(rcVar);
        }
    }

    @Override // a.qb
    public qa c(qj qjVar) {
        return new bv(2, (iw) this.f21a);
    }

    public ba(iw iwVar) {
        this.f21a = iwVar;
    }
}
