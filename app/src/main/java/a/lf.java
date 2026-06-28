package a;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class lf implements ExecutorService {
    public static final long b = TimeUnit.SECONDS.toMillis(10);
    public static volatile int c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f165a;

    public lf(ThreadPoolExecutor threadPoolExecutor) {
        this.f165a = threadPoolExecutor;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f165a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f165a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection) {
        return this.f165a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection) {
        return this.f165a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f165a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f165a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f165a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.f165a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        return this.f165a.submit(runnable);
    }

    public final String toString() {
        return this.f165a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.f165a.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.f165a.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable, Object obj) {
        return this.f165a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Callable callable) {
        return this.f165a.submit(callable);
    }
}
