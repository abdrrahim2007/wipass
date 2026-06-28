package a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class cw implements nd, cv {
    public static final Map b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f50a;

    static {
        List listH = cz.h(jh.class, js.class, jw.class, jx.class, jy.class, jz.class, ka.class, kb.class, kc.class, kd.class, ji.class, jj.class, jk.class, jl.class, jm.class, jn.class, jo.class, jp.class, jq.class, jr.class, jt.class, ju.class, jv.class);
        ArrayList arrayList = new ArrayList(da.j(listH, 10));
        int i = 0;
        for (Object obj : listH) {
            int i2 = i + 1;
            if (i < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new qw((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        b = pd.l(arrayList);
        HashMap map = new HashMap();
        map.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        mk.g(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            mk.g(str, "kotlinName");
            sb.append(ut.q(str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "a.ke" + iIntValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(pd.g(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), ut.q((String) entry2.getValue()));
        }
    }

    public cw(Class cls) {
        mk.h(cls, "jClass");
        this.f50a = cls;
    }

    @Override // a.cv
    public final Class a() {
        return this.f50a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof cw) && kz.c(this).equals(kz.c((nd) obj));
    }

    public final int hashCode() {
        return kz.c(this).hashCode();
    }

    public final String toString() {
        return this.f50a.toString() + " (Kotlin reflection is not available)";
    }
}
