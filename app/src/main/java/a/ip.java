package a;

import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes.dex */
public abstract class ip {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ee f135a = new ee(25);

    public static im a(int i, il ilVar) {
        return new im(new Pools.SynchronizedPool(i), ilVar, f135a);
    }
}
