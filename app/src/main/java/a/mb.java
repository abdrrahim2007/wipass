package a;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class mb implements nn, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f177a;

    public mb(Object obj) {
        this.f177a = obj;
    }

    @Override // a.nn
    public final Object getValue() {
        return this.f177a;
    }

    public final String toString() {
        return String.valueOf(this.f177a);
    }
}
