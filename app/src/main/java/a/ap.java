package a;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ap implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12a;

    public /* synthetic */ ap(int i) {
        this.f12a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f12a) {
            case 0:
                ArchTaskExecutor.lambda$static$0(runnable);
                break;
            case 1:
                ArchTaskExecutor.lambda$static$1(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
