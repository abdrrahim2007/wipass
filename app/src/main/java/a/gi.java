package a;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class gi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98a;
    public final long[] b;
    public final File[] c;
    public final File[] d;
    public boolean e;
    public gh f;
    public final /* synthetic */ gj g;

    public gi(gj gjVar, String str) {
        this.g = gjVar;
        this.f98a = str;
        int i = gjVar.g;
        File file = gjVar.f99a;
        this.b = new long[i];
        this.c = new File[i];
        this.d = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(i2);
            this.c[i2] = new File(file, sb.toString());
            sb.append(".tmp");
            this.d[i2] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        for (long j : this.b) {
            sb.append(' ');
            sb.append(j);
        }
        return sb.toString();
    }
}
