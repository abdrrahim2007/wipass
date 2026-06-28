package a;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class lc extends Exception {
    public static final StackTraceElement[] f = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f163a;
    public nl b;
    public int c;
    public Class d;
    public final String e;

    public lc(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void a(Throwable th, ArrayList arrayList) {
        if (!(th instanceof lc)) {
            arrayList.add(th);
            return;
        }
        Iterator it = ((lc) th).f163a.iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), arrayList);
        }
    }

    public static void b(List list, lb lbVar) {
        try {
            c(list, lbVar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void c(List list, lb lbVar) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            lbVar.append("Cause (");
            int i2 = i + 1;
            lbVar.append(String.valueOf(i2));
            lbVar.append(" of ");
            lbVar.append(String.valueOf(size));
            lbVar.append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof lc) {
                lc lcVar = (lc) th;
                d(lcVar, lbVar);
                b(lcVar.f163a, new lb(lbVar));
            } else {
                d(th, lbVar);
            }
            i = i2;
        }
    }

    public static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String str;
        String strConcat;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.e);
        String str2 = "";
        if (this.d != null) {
            str = ", " + this.d;
        } else {
            str = "";
        }
        sb.append(str);
        int i = this.c;
        if (i != 0) {
            strConcat = ", ".concat(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL");
        } else {
            strConcat = "";
        }
        sb.append(strConcat);
        if (this.b != null) {
            str2 = ", " + this.b;
        }
        sb.append(str2);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            Throwable th = (Throwable) obj;
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
    }

    public lc(String str, List list) {
        this.e = str;
        setStackTrace(f);
        this.f163a = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        d(this, printStream);
        b(this.f163a, new lb(printStream));
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        d(this, printWriter);
        b(this.f163a, new lb(printWriter));
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }
}
