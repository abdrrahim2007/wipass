package a;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public abstract class az implements ec, er, Serializable {
    private final ec completion;

    public az(ec ecVar) {
        this.completion = ecVar;
    }

    public ec create(ec ecVar) {
        mk.h(ecVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // a.er
    public er getCallerFrame() {
        ec ecVar = this.completion;
        if (ecVar instanceof er) {
            return (er) ecVar;
        }
        return null;
    }

    public final ec getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        int iIntValue;
        String strC;
        ff ffVar = (ff) getClass().getAnnotation(ff.class);
        String str = null;
        if (ffVar == null) {
            return null;
        }
        int iV = ffVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? ffVar.l()[iIntValue] : -1;
        z zVar = ky.c;
        z zVar2 = ky.d;
        if (zVar2 == null) {
            try {
                z zVar3 = new z(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null), 8);
                ky.d = zVar3;
                zVar2 = zVar3;
            } catch (Exception unused2) {
                ky.d = zVar;
                zVar2 = zVar;
            }
        }
        if (zVar2 != zVar) {
            Method method = (Method) zVar2.b;
            Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
            if (objInvoke != null) {
                Method method2 = (Method) zVar2.c;
                Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                if (objInvoke2 != null) {
                    Method method3 = (Method) zVar2.d;
                    Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                    if (objInvoke3 instanceof String) {
                        str = (String) objInvoke3;
                    }
                }
            }
        }
        if (str == null) {
            strC = ffVar.c();
        } else {
            strC = str + '/' + ffVar.c();
        }
        return new StackTraceElement(strC, ffVar.m(), ffVar.f(), i);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // a.ec
    public final void resumeWith(Object obj) {
        ec ecVar = this;
        while (true) {
            az azVar = (az) ecVar;
            ec ecVar2 = azVar.completion;
            mk.c(ecVar2);
            try {
                obj = azVar.invokeSuspend(obj);
                if (obj == eq.f74a) {
                    return;
                }
            } catch (Throwable th) {
                obj = pd.b(th);
            }
            azVar.releaseIntercepted();
            if (!(ecVar2 instanceof az)) {
                ecVar2.resumeWith(obj);
                return;
            }
            ecVar = ecVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public ec create(Object obj, ec ecVar) {
        mk.h(ecVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
