package a;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class at extends bs {
    public static void i(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        mk.h(iArr, "<this>");
        mk.h(iArr2, "destination");
        System.arraycopy(iArr, i2, iArr2, i, i3 - i2);
    }

    public static void j(float[] fArr, int i, float[] fArr2, int i2, int i3) {
        mk.h(fArr, "<this>");
        mk.h(fArr2, "destination");
        System.arraycopy(fArr, i2, fArr2, i, i3 - i2);
    }

    public static void k(long[] jArr, long[] jArr2, int i, int i2, int i3) {
        mk.h(jArr, "<this>");
        mk.h(jArr2, "destination");
        System.arraycopy(jArr, i2, jArr2, i, i3 - i2);
    }

    public static void l(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        mk.h(objArr, "<this>");
        mk.h(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
    }

    public static /* synthetic */ void m(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = iArr.length;
        }
        i(i, 0, iArr, iArr2, i2);
    }

    public static /* synthetic */ void n(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        l(objArr, objArr2, i, i2, i3);
    }

    public static Object[] o(Object[] objArr, int i, int i2) {
        mk.h(objArr, "<this>");
        int length = objArr.length;
        if (i2 <= length) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i2);
            mk.g(objArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            return objArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + length + ").");
    }

    public static void p(Object[] objArr, int i, int i2) {
        mk.h(objArr, "<this>");
        Arrays.fill(objArr, i, i2, (Object) null);
    }

    public static void q(long[] jArr) {
        int length = jArr.length;
        mk.h(jArr, "<this>");
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static int r(Object[] objArr, Object obj) {
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
