package a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface nz extends Future {
    void addListener(Runnable runnable, Executor executor);
}
