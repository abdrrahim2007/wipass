package a;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.content.UriMatcherCompat;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dz implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f65a;
    public final /* synthetic */ Object b;

    public /* synthetic */ dz(int i, Object obj) {
        this.f65a = i;
        this.b = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f65a) {
            case 0:
                return ((java.util.function.Predicate) this.b).test((ClipData.Item) obj);
            case 1:
                return ((ComponentName) this.b).equals((ComponentName) obj);
            case 2:
                return this.b.equals(obj);
            case 3:
                return ((Predicate) this.b).lambda$negate$1(obj);
            default:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) this.b, (Uri) obj);
        }
    }
}
