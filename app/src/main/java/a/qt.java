package a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class qt {
    public static final kn e = new kn(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f257a;
    public final qs b;
    public final String c;
    public volatile byte[] d;

    public qt(String str, Object obj, qs qsVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        this.c = str;
        this.f257a = obj;
        this.b = qsVar;
    }

    public static qt a(Object obj, String str) {
        return new qt(str, obj, e);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof qt) {
            return this.c.equals(((qt) obj).c);
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return pt.j(new StringBuilder("Option{key='"), this.c, "'}");
    }
}
