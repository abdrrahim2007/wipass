package a;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public abstract class ll {
    private static volatile Choreographer choreographer;

    static {
        Object objB;
        try {
            objB = new lk(a(Looper.getMainLooper()), false);
        } catch (Throwable th) {
            objB = pd.b(th);
        }
        if (objB instanceof st) {
            objB = null;
        }
    }

    public static final Handler a(Looper looper) throws IllegalAccessException, InvocationTargetException {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object objInvoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (objInvoke != null) {
            return (Handler) objInvoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
