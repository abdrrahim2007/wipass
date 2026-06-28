package a;

import androidx.graphics.shapes.MeasuredPolygon;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class cy extends de {
    public static boolean l(Iterable iterable, Object obj) {
        int iIndexOf;
        mk.h(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(obj);
        }
        if (!(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    iIndexOf = -1;
                    break;
                }
                Object next = it.next();
                if (i < 0) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                if (mk.a(obj, next)) {
                    iIndexOf = i;
                    break;
                }
                i++;
            }
        } else {
            iIndexOf = ((List) iterable).indexOf(obj);
        }
        return iIndexOf >= 0;
    }

    public static Object m(List list) {
        mk.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static Object n(MeasuredPolygon measuredPolygon, int i) {
        mk.h(measuredPolygon, "<this>");
        if (i < 0 || i > cz.g(measuredPolygon)) {
            return null;
        }
        return measuredPolygon.get(i);
    }

    public static String o(Iterable iterable, d dVar, int i) {
        String str = (i & 2) != 0 ? "" : "[";
        String str2 = (i & 4) == 0 ? "]" : "";
        if ((i & 32) != 0) {
            dVar = null;
        }
        mk.h(iterable, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        Iterator it = iterable.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) ", ");
            }
            if (dVar != null) {
                sb.append((CharSequence) dVar.invoke(next));
            } else {
                if (next != null ? next instanceof CharSequence : true) {
                    sb.append((CharSequence) next);
                } else if (next instanceof Character) {
                    sb.append(((Character) next).charValue());
                } else {
                    sb.append((CharSequence) String.valueOf(next));
                }
            }
        }
        sb.append((CharSequence) str2);
        String string = sb.toString();
        mk.g(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        return string;
    }

    public static Object p(List list) {
        mk.h(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(cz.g(list));
    }
}
