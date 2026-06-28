package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class cm extends dn {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(cm.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public cm(cl clVar, Throwable th, boolean z) {
        super(z, th);
        this._resumed = 0;
    }
}
