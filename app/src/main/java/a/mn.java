package a;

import androidx.activity.contextaware.ContextAwareKt$withContextAvailable$2$1;

/* JADX INFO: loaded from: classes.dex */
public final class mn implements qn, js {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContextAwareKt$withContextAvailable$2$1 f187a;

    public mn(ContextAwareKt$withContextAvailable$2$1 contextAwareKt$withContextAvailable$2$1) {
        this.f187a = contextAwareKt$withContextAvailable$2$1;
    }

    @Override // a.js
    public final Object invoke(Object obj) {
        this.f187a.invoke(obj);
        return vx.f338a;
    }

    public final String toString() {
        return "InvokeOnCancel[@" + pd.d(this) + ']';
    }
}
