package a;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class qy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f260a;

    static {
        Method method;
        Method[] methods = Throwable.class.getMethods();
        mk.g(methods, "throwableMethods");
        int length = methods.length;
        int i = 0;
        while (true) {
            method = null;
            if (i >= length) {
                break;
            }
            Method method2 = methods[i];
            if (mk.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                mk.g(parameterTypes, "it.parameterTypes");
                if (mk.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    method = method2;
                    break;
                }
            }
            i++;
        }
        f260a = method;
        int length2 = methods.length;
        for (int i2 = 0; i2 < length2 && !mk.a(methods[i2].getName(), "getSuppressed"); i2++) {
        }
    }
}
