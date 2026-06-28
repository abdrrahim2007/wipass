package a;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public abstract class da extends cz {
    public static int j(Iterable iterable, int i) {
        mk.h(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
