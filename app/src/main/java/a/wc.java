package a;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class wc implements qa {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f342a;

    public wc(wb wbVar) {
        this.f342a = wbVar;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        return b.contains(((Uri) obj).getScheme());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [a.wb, java.lang.Object] */
    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        Uri uri = (Uri) obj;
        return new pz(new qq(uri), this.f342a.a(uri));
    }
}
