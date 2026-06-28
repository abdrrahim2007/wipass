package a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class ig implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f132a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f132a) {
            case 0:
                wh.f().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
