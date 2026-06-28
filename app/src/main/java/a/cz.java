package a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class cz extends kz {
    public static int g(List list) {
        mk.h(list, "<this>");
        return list.size() - 1;
    }

    public static List h(Object... objArr) {
        if (objArr.length <= 0) {
            return hd.f111a;
        }
        List listAsList = Arrays.asList(objArr);
        mk.g(listAsList, "asList(this)");
        return listAsList;
    }

    public static ArrayList i(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new aq(objArr, true));
    }
}
