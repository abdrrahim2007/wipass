package a;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public abstract class o extends rm {
    @Override // a.rm
    public final int a() {
        return c().nextInt();
    }

    @Override // a.rm
    public final int b() {
        return c().nextInt(2147418112);
    }

    public abstract Random c();
}
