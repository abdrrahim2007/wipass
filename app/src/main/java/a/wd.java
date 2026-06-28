package a;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class wd implements qa {
    public static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qa f343a;

    public wd(qa qaVar) {
        this.f343a = qaVar;
    }

    @Override // a.qa
    public final boolean a(Object obj) {
        return b.contains(((Uri) obj).getScheme());
    }

    @Override // a.qa
    public final pz b(Object obj, int i, int i2, qu quVar) {
        return this.f343a.b(new lh(((Uri) obj).toString()), i, i2, quVar);
    }
}
