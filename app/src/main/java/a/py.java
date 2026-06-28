package a;

import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class py {
    public static final ArrayDeque b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f246a;

    static {
        char[] cArr = wh.f346a;
        b = new ArrayDeque(0);
    }

    public static py a(Object obj) {
        py pyVar;
        ArrayDeque arrayDeque = b;
        synchronized (arrayDeque) {
            pyVar = (py) arrayDeque.poll();
        }
        if (pyVar == null) {
            pyVar = new py();
        }
        pyVar.f246a = obj;
        return pyVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof py) && this.f246a.equals(((py) obj).f246a);
    }

    public final int hashCode() {
        return this.f246a.hashCode();
    }
}
