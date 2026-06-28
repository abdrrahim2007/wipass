package a;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rd implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f262a;
    public final /* synthetic */ Predicate b;
    public final /* synthetic */ Object c;

    public /* synthetic */ rd(Predicate predicate, Predicate predicate2, int i) {
        this.f262a = i;
        this.b = predicate;
        this.c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f262a) {
            case 0:
                return this.b.lambda$or$2((Predicate) this.c, obj);
            case 1:
                return this.b.lambda$and$0((Predicate) this.c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.c, this.b, obj);
        }
    }

    public /* synthetic */ rd(Class cls, Predicate predicate) {
        this.f262a = 2;
        this.c = cls;
        this.b = predicate;
    }
}
