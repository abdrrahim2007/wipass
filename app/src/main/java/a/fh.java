package a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f81a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public la c;
    public Object d;
    public int e;
    public int f;
    public Class g;
    public hp h;
    public qu i;
    public Map j;
    public Class k;
    public boolean l;
    public boolean m;
    public nl n;
    public rf o;
    public gd p;
    public boolean q;
    public boolean r;

    public final ArrayList a() {
        boolean z = this.m;
        ArrayList arrayList = this.b;
        if (!z) {
            this.m = true;
            arrayList.clear();
            ArrayList arrayListB = b();
            int size = arrayListB.size();
            for (int i = 0; i < size; i++) {
                pz pzVar = (pz) arrayListB.get(i);
                nl nlVar = pzVar.f247a;
                List list = pzVar.b;
                if (!arrayList.contains(nlVar)) {
                    arrayList.add(pzVar.f247a);
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (!arrayList.contains(list.get(i2))) {
                        arrayList.add(list.get(i2));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z = this.l;
        ArrayList arrayList = this.f81a;
        if (!z) {
            this.l = true;
            arrayList.clear();
            List listF = this.c.a().f(this.d);
            int size = listF.size();
            for (int i = 0; i < size; i++) {
                pz pzVarB = ((qa) listF.get(i)).b(this.d, this.e, this.f, this.i);
                if (pzVarB != null) {
                    arrayList.add(pzVarB);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final oa c(Class cls) {
        oa oaVar;
        Class cls2;
        Class cls3;
        Class cls4;
        oa oaVar2;
        ArrayList arrayList;
        ArrayList arrayList2;
        sp spVar;
        Class cls5 = cls;
        ru ruVarA = this.c.a();
        Class cls6 = this.g;
        Class cls7 = this.k;
        ob obVar = ruVarA.i;
        qe qeVar = (qe) obVar.b.getAndSet(null);
        if (qeVar == null) {
            qeVar = new qe();
        }
        qeVar.f250a = cls5;
        qeVar.b = cls6;
        qeVar.c = cls7;
        synchronized (obVar.f203a) {
            oaVar = (oa) obVar.f203a.get(qeVar);
        }
        obVar.b.set(qeVar);
        ruVarA.i.getClass();
        if (ob.c.equals(oaVar)) {
            return null;
        }
        if (oaVar != null) {
            return oaVar;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayListF = ruVarA.c.f(cls5, cls6);
        int size = arrayListF.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            Class<?> cls8 = (Class) arrayListF.get(i);
            ArrayList arrayListB = ruVarA.f.b(cls8, cls7);
            int size2 = arrayListB.size();
            int i3 = 0;
            while (i3 < size2) {
                int i4 = i3 + 1;
                Class cls9 = (Class) arrayListB.get(i3);
                ah ahVar = ruVarA.c;
                synchronized (ahVar) {
                    arrayList = new ArrayList();
                    ArrayList arrayList4 = (ArrayList) ahVar.b;
                    int size3 = arrayList4.size();
                    int i5 = 0;
                    while (i5 < size3) {
                        Object obj = arrayList4.get(i5);
                        int i6 = i5 + 1;
                        String str = (String) obj;
                        ArrayList arrayList5 = arrayListB;
                        List list = (List) ((HashMap) ahVar.c).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                sj sjVar = (sj) it.next();
                                Iterator it2 = it;
                                if (sjVar.f281a.isAssignableFrom(cls5) && cls8.isAssignableFrom(sjVar.b)) {
                                    arrayList.add(sjVar.c);
                                }
                                it = it2;
                            }
                        }
                        arrayListB = arrayList5;
                        i5 = i6;
                    }
                    arrayList2 = arrayListB;
                }
                hk hkVar = ruVarA.f;
                synchronized (hkVar) {
                    if (!cls9.isAssignableFrom(cls8)) {
                        ArrayList arrayList6 = hkVar.f116a;
                        int size4 = arrayList6.size();
                        int i7 = 0;
                        while (i7 < size4) {
                            Object obj2 = arrayList6.get(i7);
                            i7++;
                            vn vnVar = (vn) obj2;
                            ArrayList arrayList7 = arrayList6;
                            if (vnVar.f332a.isAssignableFrom(cls8) && cls9.isAssignableFrom(vnVar.b)) {
                                spVar = vnVar.c;
                            } else {
                                cls5 = cls;
                                arrayList6 = arrayList7;
                            }
                        }
                        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls8 + " to " + cls9);
                    }
                    spVar = ee.i;
                }
                arrayList3.add(new fk(cls5, cls8, cls9, arrayList, spVar, ruVarA.j));
                cls5 = cls;
                size2 = size2;
                i3 = i4;
                arrayListB = arrayList2;
            }
            cls5 = cls;
            i = i2;
        }
        if (arrayList3.isEmpty()) {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            oaVar2 = null;
        } else {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            oaVar2 = new oa(cls2, cls3, cls4, arrayList3, ruVarA.j);
        }
        ob obVar2 = ruVarA.i;
        synchronized (obVar2.f203a) {
            obVar2.f203a.put(new qe(cls2, cls3, cls4), oaVar2 != null ? oaVar2 : ob.c);
        }
        return oaVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r1 = r5.b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final a.hi d(java.lang.Object r8) {
        /*
            r7 = this;
            a.la r0 = r7.c
            a.ru r0 = r0.a()
            a.hk r0 = r0.b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f116a     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            a.hj r5 = (a.hj) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.f115a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            a.hi r1 = r5.b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            goto L2e
        L2a:
            r8 = move-exception
            goto L49
        L2c:
            monitor-exit(r0)
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            return r1
        L31:
            a.rt r0 = new a.rt
            java.lang.Class r8 = r8.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.fh.d(java.lang.Object):a.hi");
    }

    public final vo e(Class cls) {
        vo voVar = (vo) this.j.get(cls);
        if (voVar == null) {
            Iterator it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    voVar = (vo) entry.getValue();
                    break;
                }
            }
        }
        if (voVar != null) {
            return voVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return vz.b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
