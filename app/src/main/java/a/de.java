package a;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class de extends dd {
    public static void k(AbstractCollection abstractCollection, Iterable iterable) {
        mk.h(iterable, "elements");
        if (iterable instanceof Collection) {
            abstractCollection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }
}
