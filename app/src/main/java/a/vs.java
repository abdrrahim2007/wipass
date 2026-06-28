package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class vs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ig f335a = new ig(0);
    public static final ig b = new ig(1);

    public static void a(Throwable th, Throwable th2) {
        mk.h(th, "<this>");
        mk.h(th2, "exception");
        if (th != th2) {
            ra.f261a.a(th, th2);
        }
    }

    public static void b(Object obj) {
        if (obj != null) {
            if (obj instanceof ke) {
                if ((obj instanceof kg ? ((kg) obj).getArity() : obj instanceof jh ? 0 : obj instanceof js ? 1 : obj instanceof jw ? 2 : obj instanceof jy ? 4 : -1) == 2) {
                    return;
                }
            }
            ClassCastException classCastException = new ClassCastException(obj.getClass().getName().concat(" cannot be cast to kotlin.jvm.functions.Function2"));
            mk.o(classCastException, vs.class.getName());
            throw classCastException;
        }
    }

    public static ei c(ei eiVar, ei eiVar2) {
        mk.h(eiVar2, "context");
        return eiVar2 == hb.f109a ? eiVar : (ei) eiVar2.fold(eiVar, di.c);
    }

    public static final void d(Object[] objArr, int i, int i2) {
        mk.h(objArr, "<this>");
        while (i < i2) {
            objArr[i] = null;
            i++;
        }
    }

    public static final long e(long j, long j2, long j3, String str) {
        String property;
        String str2;
        Long lValueOf;
        long j4;
        int i = ux.f320a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j;
        }
        int i2 = 1;
        if (10 > new mg(2, 36, 1).b) {
            throw new IllegalArgumentException("radix 10 was not in valid range " + new mg(2, 36, 1));
        }
        int length = property.length();
        if (length == 0) {
            str2 = property;
            lValueOf = null;
            break;
        }
        boolean z = false;
        char cCharAt = property.charAt(0);
        long j5 = -9223372036854775807L;
        if (cCharAt < '0') {
            if (length != 1) {
                if (cCharAt == '-') {
                    j5 = Long.MIN_VALUE;
                    z = true;
                } else if (cCharAt == '+') {
                }
            }
            str2 = property;
            lValueOf = null;
            break;
        }
        i2 = 0;
        long j6 = 0;
        long j7 = -256204778801521550L;
        while (i2 < length) {
            int iDigit = Character.digit((int) property.charAt(i2), 10);
            if (iDigit < 0) {
                str2 = property;
                lValueOf = null;
                break;
            }
            long j8 = j6;
            str2 = property;
            if (j8 < j7) {
                if (j7 == -256204778801521550L) {
                    j4 = j5;
                    j7 = j4 / ((long) 10);
                    if (j8 < j7) {
                    }
                }
                lValueOf = null;
                break;
            }
            j4 = j5;
            long j9 = j8 * ((long) 10);
            long j10 = iDigit;
            if (j9 < j4 + j10) {
                lValueOf = null;
                break;
            }
            i2++;
            property = str2;
            j6 = j9 - j10;
            j5 = j4;
        }
        long j11 = j6;
        str2 = property;
        long j12 = j11;
        if (!z) {
            j12 = -j12;
        }
        lValueOf = Long.valueOf(j12);
        if (lValueOf == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + str2 + '\'').toString());
        }
        long jLongValue = lValueOf.longValue();
        if (j2 <= jLongValue && jLongValue <= j3) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int f(String str, int i, int i2) {
        return (int) e(i, 1, (i2 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }

    public static mg g(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? mg.d : new mg(i, i2 - 1, 1);
    }
}
