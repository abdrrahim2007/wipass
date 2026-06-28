package a;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes.dex */
public final class rb extends o {
    @Override // a.o
    public final Random c() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        mk.g(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
