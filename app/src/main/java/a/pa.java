package a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class pa implements Map, Serializable, ng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f225a;
    public Object[] b;
    public int[] c;
    public int[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public pb i;
    public pc j;
    public pb k;
    public boolean l;

    public pa(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f225a = objArr;
        this.b = null;
        this.c = iArr;
        this.d = new int[iHighestOneBit];
        this.e = 2;
        this.f = 0;
        this.g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (!this.l) {
            throw new NotSerializableException("The map cannot be serialized while it is being built.");
        }
        tm tmVar = new tm();
        tmVar.f298a = this;
        return tmVar;
    }

    public final int a(Object obj) {
        b();
        while (true) {
            int iH = h(obj);
            int i = this.e * 2;
            int length = this.d.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.d;
                int i3 = iArr[iH];
                if (i3 <= 0) {
                    int i4 = this.f;
                    Object[] objArr = this.f225a;
                    if (i4 < objArr.length) {
                        int i5 = i4 + 1;
                        this.f = i5;
                        objArr[i4] = obj;
                        this.c[i4] = iH;
                        iArr[iH] = i5;
                        this.h++;
                        if (i2 > this.e) {
                            this.e = i2;
                        }
                        return i4;
                    }
                    e(1);
                } else {
                    if (mk.a(this.f225a[i3 - 1], obj)) {
                        return -i3;
                    }
                    i2++;
                    if (i2 > i) {
                        i(this.d.length * 2);
                        break;
                    }
                    iH = iH == 0 ? this.d.length - 1 : iH - 1;
                }
            }
        }
    }

    public final void b() {
        if (this.l) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean c(Collection collection) {
        mk.h(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!d((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final void clear() {
        int i;
        b();
        int i2 = new mg(0, this.f - 1, 1).b;
        boolean z = i2 >= 0;
        int i3 = z ? 0 : i2;
        while (z) {
            if (i3 != i2) {
                i = i3 + 1;
            } else {
                if (!z) {
                    throw new NoSuchElementException();
                }
                i = i3;
                z = false;
            }
            int[] iArr = this.c;
            int i4 = iArr[i3];
            if (i4 >= 0) {
                this.d[i4] = 0;
                iArr[i3] = -1;
            }
            i3 = i;
        }
        vs.d(this.f225a, 0, this.f);
        Object[] objArr = this.b;
        if (objArr != null) {
            vs.d(objArr, 0, this.f);
        }
        this.h = 0;
        this.f = 0;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final boolean d(Map.Entry entry) {
        mk.h(entry, "entry");
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        Object[] objArr = this.b;
        mk.c(objArr);
        return mk.a(objArr[iF], entry.getValue());
    }

    public final void e(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f225a;
        int length = objArr.length;
        int i2 = this.f;
        int i3 = length - i2;
        int i4 = i2 - this.h;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            i(this.d.length);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = (objArr.length * 3) / 2;
            if (i5 <= length2) {
                i5 = length2;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i5);
            mk.g(objArrCopyOf2, "copyOf(this, newSize)");
            this.f225a = objArrCopyOf2;
            Object[] objArr2 = this.b;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i5);
                mk.g(objArrCopyOf, "copyOf(this, newSize)");
            } else {
                objArrCopyOf = null;
            }
            this.b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.c, i5);
            mk.g(iArrCopyOf, "copyOf(this, newSize)");
            this.c = iArrCopyOf;
            if (i5 < 1) {
                i5 = 1;
            }
            int iHighestOneBit = Integer.highestOneBit(i5 * 3);
            if (iHighestOneBit > this.d.length) {
                i(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        pb pbVar = this.k;
        if (pbVar != null) {
            return pbVar;
        }
        pb pbVar2 = new pb(this, 0);
        this.k = pbVar2;
        return pbVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.h == map.size() && c(map.entrySet());
    }

    public final int f(Object obj) {
        int iH = h(obj);
        int i = this.e;
        while (true) {
            int i2 = this.d[iH];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (mk.a(this.f225a[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iH = iH == 0 ? this.d.length - 1 : iH - 1;
        }
    }

    public final int g(Object obj) {
        int i = this.f;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.c[i] >= 0) {
                Object[] objArr = this.b;
                mk.c(objArr);
                if (mk.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.b;
        mk.c(objArr);
        return objArr[iF];
    }

    public final int h(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.g;
    }

    @Override // java.util.Map
    public final int hashCode() {
        oy oyVar = new oy(this, 0);
        int i = 0;
        while (oyVar.hasNext()) {
            int i2 = oyVar.b;
            pa paVar = oyVar.f223a;
            if (i2 >= paVar.f) {
                throw new NoSuchElementException();
            }
            oyVar.b = i2 + 1;
            oyVar.c = i2;
            Object obj = paVar.f225a[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = paVar.b;
            mk.c(objArr);
            Object obj2 = objArr[oyVar.c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            oyVar.a();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        r3[r0] = r7;
        r6.c[r2] = r0;
        r2 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(int r7) {
        /*
            r6 = this;
            int r0 = r6.f
            int r1 = r6.h
            r2 = 0
            if (r0 <= r1) goto L34
            java.lang.Object[] r0 = r6.b
            r1 = r2
            r3 = r1
        Lb:
            int r4 = r6.f
            if (r1 >= r4) goto L26
            int[] r4 = r6.c
            r4 = r4[r1]
            if (r4 < 0) goto L23
            java.lang.Object[] r4 = r6.f225a
            r5 = r4[r1]
            r4[r3] = r5
            if (r0 == 0) goto L21
            r4 = r0[r1]
            r0[r3] = r4
        L21:
            int r3 = r3 + 1
        L23:
            int r1 = r1 + 1
            goto Lb
        L26:
            java.lang.Object[] r1 = r6.f225a
            a.vs.d(r1, r3, r4)
            if (r0 == 0) goto L32
            int r1 = r6.f
            a.vs.d(r0, r3, r1)
        L32:
            r6.f = r3
        L34:
            int[] r0 = r6.d
            int r1 = r0.length
            if (r7 == r1) goto L46
            int[] r0 = new int[r7]
            r6.d = r0
            int r7 = java.lang.Integer.numberOfLeadingZeros(r7)
            int r7 = r7 + 1
            r6.g = r7
            goto L4f
        L46:
            int r7 = r0.length
            java.lang.String r1 = "<this>"
            a.mk.h(r0, r1)
            java.util.Arrays.fill(r0, r2, r7, r2)
        L4f:
            int r7 = r6.f
            if (r2 >= r7) goto L83
            int r7 = r2 + 1
            java.lang.Object[] r0 = r6.f225a
            r0 = r0[r2]
            int r0 = r6.h(r0)
            int r1 = r6.e
        L5f:
            int[] r3 = r6.d
            r4 = r3[r0]
            if (r4 != 0) goto L6d
            r3[r0] = r7
            int[] r1 = r6.c
            r1[r2] = r0
            r2 = r7
            goto L4f
        L6d:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L7b
            int r4 = r0 + (-1)
            if (r0 != 0) goto L79
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L5f
        L79:
            r0 = r4
            goto L5f
        L7b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r7.<init>(r0)
            throw r7
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.pa.i(int):void");
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.h == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[LOOP:0: B:6:0x001e->B:30:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f225a
            java.lang.String r1 = "<this>"
            a.mk.h(r0, r1)
            r1 = 0
            r0[r12] = r1
            int[] r0 = r11.c
            r0 = r0[r12]
            int r1 = r11.e
            int r1 = r1 * 2
            int[] r2 = r11.d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1a
            r1 = r2
        L1a:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L1e:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L28
            int[] r0 = r11.d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L29
        L28:
            r0 = r5
        L29:
            int r4 = r4 + 1
            int r5 = r11.e
            r6 = -1
            if (r4 <= r5) goto L35
            int[] r0 = r11.d
            r0[r1] = r2
            goto L66
        L35:
            int[] r5 = r11.d
            r7 = r5[r0]
            if (r7 != 0) goto L3e
            r5[r1] = r2
            goto L66
        L3e:
            if (r7 >= 0) goto L45
            r5[r1] = r6
        L42:
            r1 = r0
            r4 = r2
            goto L5f
        L45:
            java.lang.Object[] r5 = r11.f225a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.h(r5)
            int r5 = r5 - r0
            int[] r9 = r11.d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L5f
            r9[r1] = r7
            int[] r4 = r11.c
            r4[r8] = r1
            goto L42
        L5f:
            int r3 = r3 + r6
            if (r3 >= 0) goto L1e
            int[] r0 = r11.d
            r0[r1] = r6
        L66:
            int[] r0 = r11.c
            r0[r12] = r6
            int r12 = r11.h
            int r12 = r12 + r6
            r11.h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.pa.j(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        pb pbVar = this.i;
        if (pbVar != null) {
            return pbVar;
        }
        pb pbVar2 = new pb(this, 1);
        this.i = pbVar2;
        return pbVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        b();
        int iA = a(obj);
        Object[] objArr = this.b;
        if (objArr == null) {
            int length = this.f225a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        mk.h(map, TypedValues.TransitionType.S_FROM);
        b();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        e(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.b;
            if (objArr == null) {
                int length = this.f225a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!mk.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        b();
        int iF = f(obj);
        if (iF < 0) {
            iF = -1;
        } else {
            j(iF);
        }
        if (iF < 0) {
            return null;
        }
        Object[] objArr = this.b;
        mk.c(objArr);
        Object obj2 = objArr[iF];
        objArr[iF] = null;
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.h;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.h * 3) + 2);
        sb.append("{");
        int i = 0;
        oy oyVar = new oy(this, 0);
        while (oyVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = oyVar.b;
            pa paVar = oyVar.f223a;
            if (i2 >= paVar.f) {
                throw new NoSuchElementException();
            }
            oyVar.b = i2 + 1;
            oyVar.c = i2;
            Object obj = paVar.f225a[i2];
            if (mk.a(obj, paVar)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = paVar.b;
            mk.c(objArr);
            Object obj2 = objArr[oyVar.c];
            if (mk.a(obj2, paVar)) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            oyVar.a();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        mk.g(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        pc pcVar = this.j;
        if (pcVar != null) {
            return pcVar;
        }
        pc pcVar2 = new pc(this);
        this.j = pcVar2;
        return pcVar2;
    }
}
