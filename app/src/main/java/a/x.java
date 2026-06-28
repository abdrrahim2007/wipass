package a;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public final class x implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f361a;

    public /* synthetic */ x(int i) {
        this.f361a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f361a) {
            case 0:
                return new Thread(new w(0, runnable), "glide-active-resources");
            default:
                return new ld(runnable);
        }
    }
}
