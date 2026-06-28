package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class uw implements nn, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jh f319a;
    public volatile Object b = ee.g;
    public final Object c = this;

    public uw(jh jhVar) {
        this.f319a = jhVar;
    }

    private final Object writeReplace() {
        return new mb(getValue());
    }

    @Override // a.nn
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.b;
        ee eeVar = ee.g;
        if (obj != eeVar) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.b;
            if (objInvoke == eeVar) {
                jh jhVar = this.f319a;
                mk.c(jhVar);
                objInvoke = jhVar.invoke();
                this.b = objInvoke;
                this.f319a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.b != ee.g ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
