package a;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class px extends oq {
    @Override // a.oq
    public final void c(Object obj, Object obj2) {
        py pyVar = (py) obj;
        pyVar.getClass();
        ArrayDeque arrayDeque = py.b;
        synchronized (arrayDeque) {
            arrayDeque.offer(pyVar);
        }
    }
}
