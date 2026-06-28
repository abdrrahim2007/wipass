package a;

import androidx.lifecycle.LifecycleCoroutineScope;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class pd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f228a = new Object[0];
    public static final fb b = new fb(11, "CONDITION_FALSE");

    /* JADX WARN: Multi-variable type inference failed */
    public static ec a(ec ecVar, ec ecVar2, jw jwVar) {
        mk.h(jwVar, "<this>");
        if (jwVar instanceof az) {
            return ((az) jwVar).create(ecVar, ecVar2);
        }
        ei context = ecVar2.getContext();
        return context == hb.f109a ? new ml(ecVar2, ecVar, jwVar) : new mm(ecVar2, context, jwVar, ecVar);
    }

    public static final st b(Throwable th) {
        mk.h(th, "exception");
        return new st(th);
    }

    public static final ei c(ei eiVar, ei eiVar2, boolean z) {
        Boolean bool = Boolean.FALSE;
        di diVar = di.e;
        boolean zBooleanValue = ((Boolean) eiVar.fold(bool, diVar)).booleanValue();
        boolean zBooleanValue2 = ((Boolean) eiVar2.fold(bool, diVar)).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return eiVar.plus(eiVar2);
        }
        di diVar2 = new di(2, 7);
        hb hbVar = hb.f109a;
        ei eiVar3 = (ei) eiVar.fold(hbVar, diVar2);
        Object objFold = eiVar2;
        if (zBooleanValue2) {
            objFold = eiVar2.fold(hbVar, di.d);
        }
        return eiVar3.plus((ei) objFold);
    }

    public static final String d(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static ec e(ec ecVar) {
        ec ecVarIntercepted;
        mk.h(ecVar, "<this>");
        ed edVar = ecVar instanceof ed ? (ed) ecVar : null;
        return (edVar == null || (ecVarIntercepted = edVar.intercepted()) == null) ? ecVar : ecVarIntercepted;
    }

    public static ud f(LifecycleCoroutineScope lifecycleCoroutineScope, lk lkVar, jw jwVar, int i) {
        ei eiVar = lkVar;
        if ((i & 1) != 0) {
            eiVar = hb.f109a;
        }
        ei eiVarC = c(lifecycleCoroutineScope.getCoroutineContext(), eiVar, true);
        fw fwVar = gp.f102a;
        if (eiVarC != fwVar && eiVarC.get(ee.b) == null) {
            eiVarC = eiVarC.plus(fwVar);
        }
        ud udVar = new ud(eiVarC, true);
        int iT = pt.t(1);
        if (iT == 0) {
            ky.h(jwVar, udVar, udVar);
            return udVar;
        }
        if (iT != 1) {
            if (iT == 2) {
                e(a(udVar, udVar, jwVar)).resumeWith(vx.f338a);
            } else {
                if (iT != 3) {
                    throw new dq();
                }
                try {
                    ei eiVar2 = udVar.b;
                    Object objP = mk.p(eiVar2, null);
                    try {
                        vs.b(jwVar);
                        Object objInvoke = jwVar.invoke(udVar, udVar);
                        if (objInvoke != eq.f74a) {
                            udVar.resumeWith(objInvoke);
                            return udVar;
                        }
                    } finally {
                        mk.n(eiVar2, objP);
                    }
                } catch (Throwable th) {
                    udVar.resumeWith(b(th));
                    return udVar;
                }
            }
        }
        return udVar;
    }

    public static int g(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final void h(Object obj) throws Throwable {
        if (obj instanceof st) {
            throw ((st) obj).f286a;
        }
    }

    public static final Object[] i(Collection collection) {
        mk.h(collection, "collection");
        int size = collection.size();
        Object[] objArr = f228a;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArrCopyOf = new Object[size];
        int i = 0;
        while (true) {
            int i2 = i + 1;
            objArrCopyOf[i] = it.next();
            if (i2 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    i3 = 2147483645;
                    if (i2 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                mk.g(objArrCopyOf, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                mk.g(objArrCopyOf2, "copyOf(result, size)");
                return objArrCopyOf2;
            }
            i = i2;
        }
    }

    public static final Object[] j(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        mk.h(collection, "collection");
        int size = collection.size();
        int i = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    mk.d(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i2 = i + 1;
                    objArrCopyOf[i] = it.next();
                    if (i2 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i3 = ((i2 * 3) + 1) >>> 1;
                        if (i3 <= i2) {
                            i3 = 2147483645;
                            if (i2 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
                        mk.g(objArrCopyOf, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i2] = null;
                            return objArr;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i2);
                        mk.g(objArrCopyOf2, "copyOf(result, size)");
                        return objArrCopyOf2;
                    }
                    i = i2;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static final String k(ec ecVar) {
        Object objB;
        if (ecVar instanceof gm) {
            return ecVar.toString();
        }
        try {
            objB = ecVar + '@' + d(ecVar);
        } catch (Throwable th) {
            objB = b(th);
        }
        if (su.a(objB) != null) {
            objB = ecVar.getClass().getName() + '@' + d(ecVar);
        }
        return (String) objB;
    }

    public static Map l(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return he.f112a;
        }
        if (size == 1) {
            qw qwVar = (qw) arrayList.get(0);
            mk.h(qwVar, "pair");
            Map mapSingletonMap = Collections.singletonMap(qwVar.f259a, qwVar.b);
            mk.g(mapSingletonMap, "singletonMap(pair.first, pair.second)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(g(arrayList.size()));
        int size2 = arrayList.size();
        int i = 0;
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            qw qwVar2 = (qw) obj;
            linkedHashMap.put(qwVar2.f259a, qwVar2.b);
        }
        return linkedHashMap;
    }

    public static final Map m(Map map) {
        mk.h(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mk.g(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    public static final vv n(ec ecVar, ei eiVar, Object obj) {
        vv vvVar = null;
        if ((ecVar instanceof er) && eiVar.get(vw.f337a) != null) {
            er callerFrame = (er) ecVar;
            while (true) {
                if ((callerFrame instanceof gn) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof vv) {
                    vvVar = (vv) callerFrame;
                    break;
                }
            }
            if (vvVar != null) {
                vvVar.d.set(new qw(eiVar, obj));
            }
        }
        return vvVar;
    }

    public static final Object o(el elVar, jw jwVar, ec ecVar) {
        ei context = ecVar.getContext();
        ei eiVarPlus = !((Boolean) elVar.fold(Boolean.FALSE, di.e)).booleanValue() ? context.plus(elVar) : c(context, elVar, false);
        mt mtVar = (mt) eiVarPlus.get(ee.e);
        if (mtVar != null && !mtVar.a()) {
            throw ((na) mtVar).l();
        }
        if (eiVarPlus == context) {
            sz szVar = new sz(ecVar, eiVarPlus);
            return bs.g(szVar, szVar, jwVar);
        }
        ee eeVar = ee.b;
        if (!mk.a(eiVarPlus.get(eeVar), context.get(eeVar))) {
            gn gnVar = new gn(ecVar, eiVarPlus);
            ky.h(jwVar, gnVar, gnVar);
            return gnVar.ab();
        }
        vw vwVar = vw.f337a;
        vv vvVar = new vv(ecVar, eiVarPlus.get(vwVar) == null ? eiVarPlus.plus(vwVar) : eiVarPlus);
        ThreadLocal threadLocal = new ThreadLocal();
        vvVar.d = threadLocal;
        if (!(ecVar.getContext().get(eeVar) instanceof el)) {
            Object objP = mk.p(eiVarPlus, null);
            mk.n(eiVarPlus, objP);
            threadLocal.set(new qw(eiVarPlus, objP));
        }
        Object objP2 = mk.p(eiVarPlus, null);
        try {
            return bs.g(vvVar, vvVar, jwVar);
        } finally {
            mk.n(eiVarPlus, objP2);
        }
    }
}
