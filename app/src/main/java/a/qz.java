package a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class qz {
    public void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        mk.h(th, "cause");
        mk.h(th2, "exception");
        Method method = qy.f260a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public rm b() {
        return new ir();
    }
}
