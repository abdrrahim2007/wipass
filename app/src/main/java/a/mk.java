package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fb f184a;
    public static final fb b;
    public static volatile boolean c = true;

    static {
        int i = 11;
        f184a = new fb(i, "CLOSED_EMPTY");
        b = new fb(i, "NO_THREAD_ELEMENTS");
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        o(nullPointerException, mk.class.getName());
        throw nullPointerException;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str);
        o(nullPointerException, mk.class.getName());
        throw nullPointerException;
    }

    public static void e(Object obj) {
        f(obj, "Argument must not be null");
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void g(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        o(nullPointerException, mk.class.getName());
        throw nullPointerException;
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = mk.class.getName();
            int i = 0;
            while (!stackTrace[i].getClassName().equals(name)) {
                i++;
            }
            while (stackTrace[i].getClassName().equals(name)) {
                i++;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
            o(nullPointerException, mk.class.getName());
            throw nullPointerException;
        }
    }

    public static final void i(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(pt.e("Expected positive parallelism level, but got ", i).toString());
        }
    }

    public static Drawable j(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (c) {
                return k(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e;
            }
            return ContextCompat.getDrawable(context2, i);
        } catch (NoClassDefFoundError unused2) {
            c = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return ResourcesCompat.getDrawable(context2.getResources(), i, theme);
    }

    public static Drawable k(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, theme);
            contextThemeWrapper.applyOverrideConfiguration(theme.getResources().getConfiguration());
            context = contextThemeWrapper;
        }
        return AppCompatResources.getDrawable(context, i);
    }

    public static final Object l(Object obj) {
        return obj instanceof dn ? pd.b(((dn) obj).f58a) : obj;
    }

    public static void m() {
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static final void n(ei eiVar, Object obj) {
        if (obj == b) {
            return;
        }
        if (!(obj instanceof vg)) {
            Object objFold = eiVar.fold(null, di.g);
            if (objFold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            pt.r(objFold);
            throw null;
        }
        vg vgVar = (vg) obj;
        ve[] veVarArr = vgVar.b;
        int length = veVarArr.length - 1;
        if (length < 0) {
            return;
        }
        ve veVar = veVarArr[length];
        c(null);
        Object obj2 = vgVar.f327a[length];
        throw null;
    }

    public static void o(RuntimeException runtimeException, String str) {
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
    }

    public static final Object p(ei eiVar, Object obj) {
        if (obj == null) {
            obj = eiVar.fold(0, di.f);
            c(obj);
        }
        if (obj == 0) {
            return b;
        }
        if (obj instanceof Integer) {
            return eiVar.fold(new vg(eiVar, ((Number) obj).intValue()), di.h);
        }
        pt.r(obj);
        throw null;
    }
}
