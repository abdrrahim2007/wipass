package a;

import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class to extends kz {
    public static LinkedHashSet g(Set set, Set set2) {
        mk.h(set, "<this>");
        mk.h(set2, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(pd.g(set.size() + Integer.valueOf(set2.size()).intValue()));
        linkedHashSet.addAll(set);
        de.k(linkedHashSet, set2);
        return linkedHashSet;
    }
}
