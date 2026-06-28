package a;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class mq extends qz {
    @Override // a.qz
    public final void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        mk.h(th, "cause");
        mk.h(th2, "exception");
        Integer num = mp.f188a;
        if (num == null || num.intValue() >= 19) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
