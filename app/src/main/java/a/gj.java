package a;

import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class gj implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f99a;
    public final File b;
    public final File c;
    public final File d;
    public final long f;
    public BufferedWriter i;
    public int k;
    public long h = 0;
    public final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new gg());
    public final gf n = new gf(this);
    public final int e = 1;
    public final int g = 1;

    public gj(File file, long j) {
        this.f99a = file;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.f = j;
    }

    public static void a(gj gjVar, gh ghVar, boolean z) {
        synchronized (gjVar) {
            gi giVar = (gi) ghVar.b;
            if (giVar.f != ghVar) {
                throw new IllegalStateException();
            }
            if (z && !giVar.e) {
                for (int i = 0; i < gjVar.g; i++) {
                    if (!((boolean[]) ghVar.c)[i]) {
                        ghVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!giVar.d[i].exists()) {
                        ghVar.a();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < gjVar.g; i2++) {
                File file = giVar.d[i2];
                if (!z) {
                    c(file);
                } else if (file.exists()) {
                    File file2 = giVar.c[i2];
                    file.renameTo(file2);
                    long j = giVar.b[i2];
                    long length = file2.length();
                    giVar.b[i2] = length;
                    gjVar.h = (gjVar.h - j) + length;
                }
            }
            gjVar.k++;
            giVar.f = null;
            if (giVar.e || z) {
                giVar.e = true;
                gjVar.i.append((CharSequence) "CLEAN");
                gjVar.i.append(' ');
                gjVar.i.append((CharSequence) giVar.f98a);
                gjVar.i.append((CharSequence) giVar.a());
                gjVar.i.append('\n');
                if (z) {
                    gjVar.l++;
                }
            } else {
                gjVar.j.remove(giVar.f98a);
                gjVar.i.append((CharSequence) "REMOVE");
                gjVar.i.append(' ');
                gjVar.i.append((CharSequence) giVar.f98a);
                gjVar.i.append('\n');
            }
            e(gjVar.i);
            if (gjVar.h > gjVar.f || gjVar.g()) {
                gjVar.m.submit(gjVar.n);
            }
        }
    }

    public static void b(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void c(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void e(BufferedWriter bufferedWriter) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            bufferedWriter.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static gj h(File file, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                m(file2, file3, false);
            }
        }
        gj gjVar = new gj(file, j);
        if (gjVar.b.exists()) {
            try {
                gjVar.j();
                gjVar.i();
                return gjVar;
            } catch (IOException e) {
                PrintStream printStream = System.out;
                Objects.toString(file);
                e.getMessage();
                printStream.getClass();
                gjVar.close();
                wi.a(gjVar.f99a);
            }
        }
        file.mkdirs();
        gj gjVar2 = new gj(file, j);
        gjVar2.l();
        return gjVar2;
    }

    public static void m(File file, File file2, boolean z) throws IOException {
        if (z) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.i == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.j.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                gh ghVar = ((gi) obj).f;
                if (ghVar != null) {
                    ghVar.a();
                }
            }
            n();
            b(this.i);
            this.i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final gh d(String str) {
        synchronized (this) {
            try {
                if (this.i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                gi giVar = (gi) this.j.get(str);
                if (giVar == null) {
                    giVar = new gi(this, str);
                    this.j.put(str, giVar);
                } else if (giVar.f != null) {
                    return null;
                }
                gh ghVar = new gh(this, giVar);
                giVar.f = ghVar;
                this.i.append((CharSequence) "DIRTY");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                e(this.i);
                return ghVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized fb f(String str) {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
        gi giVar = (gi) this.j.get(str);
        if (giVar == null) {
            return null;
        }
        if (!giVar.e) {
            return null;
        }
        for (File file : giVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (g()) {
            this.m.submit(this.n);
        }
        return new fb(3, giVar.c);
    }

    public final boolean g() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public final void i() throws IOException {
        c(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            gi giVar = (gi) it.next();
            gh ghVar = giVar.f;
            int i = this.g;
            int i2 = 0;
            if (ghVar == null) {
                while (i2 < i) {
                    this.h += giVar.b[i2];
                    i2++;
                }
            } else {
                giVar.f = null;
                while (i2 < i) {
                    c(giVar.c[i2]);
                    c(giVar.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void j() {
        File file = this.b;
        ul ulVar = new ul(new FileInputStream(file), wi.f347a);
        try {
            String strA = ulVar.a();
            String strA2 = ulVar.a();
            String strA3 = ulVar.a();
            String strA4 = ulVar.a();
            String strA5 = ulVar.a();
            if (!"libcore.io.DiskLruCache".equals(strA) || !"1".equals(strA2) || !Integer.toString(this.e).equals(strA3) || !Integer.toString(this.g).equals(strA4) || !"".equals(strA5)) {
                throw new IOException("unexpected journal header: [" + strA + ", " + strA2 + ", " + strA4 + ", " + strA5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    k(ulVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (ulVar.e == -1) {
                        l();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), wi.f347a));
                    }
                    try {
                        ulVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                ulVar.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void k(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.j;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        gi giVar = (gi) linkedHashMap.get(strSubstring);
        if (giVar == null) {
            giVar = new gi(this, strSubstring);
            linkedHashMap.put(strSubstring, giVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                giVar.f = new gh(this, giVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        giVar.e = true;
        giVar.f = null;
        if (strArrSplit.length != giVar.g.g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                giVar.b[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void l() {
        try {
            BufferedWriter bufferedWriter = this.i;
            if (bufferedWriter != null) {
                b(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), wi.f347a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (gi giVar : this.j.values()) {
                    if (giVar.f != null) {
                        bufferedWriter2.write("DIRTY " + giVar.f98a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + giVar.f98a + giVar.a() + '\n');
                    }
                }
                b(bufferedWriter2);
                if (this.b.exists()) {
                    m(this.b, this.d, true);
                }
                m(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), wi.f347a));
            } catch (Throwable th) {
                b(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void n() {
        while (this.h > this.f) {
            String str = (String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.i == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    gi giVar = (gi) this.j.get(str);
                    if (giVar != null && giVar.f == null) {
                        for (int i = 0; i < this.g; i++) {
                            File file = giVar.c[i];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j = this.h;
                            long[] jArr = giVar.b;
                            this.h = j - jArr[i];
                            jArr[i] = 0;
                        }
                        this.k++;
                        this.i.append((CharSequence) "REMOVE");
                        this.i.append(' ');
                        this.i.append((CharSequence) str);
                        this.i.append('\n');
                        this.j.remove(str);
                        if (g()) {
                            this.m.submit(this.n);
                        }
                    }
                } finally {
                }
            }
        }
    }
}
