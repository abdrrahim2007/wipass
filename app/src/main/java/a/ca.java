package a;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f39a;

    public ca(int i) {
        switch (i) {
            case 1:
                this.f39a = new ArrayDeque();
                break;
            default:
                char[] cArr = wh.f346a;
                this.f39a = new ArrayDeque(0);
                break;
        }
    }

    public synchronized void a(kw kwVar) {
        kwVar.b = null;
        kwVar.c = null;
        this.f39a.offer(kwVar);
    }
}
