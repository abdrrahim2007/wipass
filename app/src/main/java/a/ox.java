package a;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes.dex */
public abstract class ox {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final lk f222a;

    static {
        String property;
        int i = ux.f320a;
        Object next = null;
        try {
            property = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            Boolean.parseBoolean(property);
        }
        try {
            Iterator it = Arrays.asList(new ab()).iterator();
            mk.h(it, "<this>");
            Iterator it2 = ti.l(new dy(new iy(2, it))).iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    ((ab) next).getClass();
                    do {
                        ((ab) it2.next()).getClass();
                    } while (it2.hasNext());
                }
            }
            if (((ab) next) == null) {
                throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null) {
                throw new IllegalStateException("The main looper is not available");
            }
            f222a = new lk(ll.a(mainLooper), false);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
