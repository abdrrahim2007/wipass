package a;

import java.lang.Thread;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes.dex */
public abstract class em {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List f71a;

    static {
        try {
            Iterator it = Arrays.asList(new ac()).iterator();
            mk.h(it, "<this>");
            f71a = ti.l(new dy(new iy(2, it)));
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }

    public static final void a(ei eiVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = f71a.iterator();
        while (it.hasNext()) {
            try {
                ((ac) it.next()).b(th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    vs.a(runtimeException, th);
                }
                uncaughtExceptionHandler.uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            vs.a(th, new fz(eiVar));
        } catch (Throwable th3) {
            pd.b(th3);
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
