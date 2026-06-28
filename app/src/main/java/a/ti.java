package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class ti extends tj {
    public static Object i(iy iyVar) {
        ix ixVar = new ix(iyVar);
        if (ixVar.hasNext()) {
            return ixVar.next();
        }
        return null;
    }

    public static tf j(Object obj, js jsVar) {
        mk.h(jsVar, "nextFunction");
        return obj == null ? hf.f113a : new kj(new tk(obj), jsVar);
    }

    public static iy k(tf tfVar, js jsVar) {
        mk.h(jsVar, "transform");
        return new iy(0, new kj(tfVar, jsVar));
    }

    public static List l(tf tfVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = tfVar.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        int size = arrayList.size();
        return size != 0 ? size != 1 ? arrayList : kz.e(arrayList.get(0)) : hd.f111a;
    }
}
