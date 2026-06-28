package a;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class fn extends ib implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final fn e;
    public static final long f;

    static {
        Long l;
        fn fnVar = new fn();
        e = fnVar;
        fnVar.e(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f = timeUnit.toNanos(l.longValue());
    }

    @Override // a.ic
    public final Thread d() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "a.fn");
                _thread = thread;
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // a.ib
    public final void g(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.g(runnable);
    }

    public final synchronized void k() {
        int i = debugStatus;
        if (i == 2 || i == 3) {
            debugStatus = 3;
            j();
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zH;
        vf.f326a.set(this);
        try {
            synchronized (this) {
                int i = debugStatus;
                if (i == 2 || i == 3) {
                    if (zH) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jI = i();
                    if (jI == LocationRequestCompat.PASSIVE_INTERVAL) {
                        long jNanoTime = System.nanoTime();
                        if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j = f + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            k();
                            if (h()) {
                                return;
                            }
                            d();
                            return;
                        }
                        if (jI > j2) {
                            jI = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jI > 0) {
                        int i2 = debugStatus;
                        if (i2 == 2 || i2 == 3) {
                            _thread = null;
                            k();
                            if (h()) {
                                return;
                            }
                            d();
                            return;
                        }
                        LockSupport.parkNanos(this, jI);
                    }
                }
            }
        } finally {
            _thread = null;
            k();
            if (!h()) {
                d();
            }
        }
    }

    @Override // a.ib, a.ic
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
