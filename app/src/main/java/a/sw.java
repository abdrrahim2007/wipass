package a;

/* JADX INFO: loaded from: classes.dex */
public final class sw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oq f288a = new oq(1000);
    public final im b = ip.a(10, new kn(12));

    public final String a(nl nlVar) {
        String str;
        synchronized (this.f288a) {
            str = (String) this.f288a.a(nlVar);
        }
        if (str == null) {
            sv svVar = (sv) this.b.acquire();
            try {
                nlVar.b(svVar.f287a);
                byte[] bArrDigest = svVar.f287a.digest();
                char[] cArr = wh.b;
                synchronized (cArr) {
                    for (int i = 0; i < bArrDigest.length; i++) {
                        byte b = bArrDigest[i];
                        int i2 = i * 2;
                        char[] cArr2 = wh.f346a;
                        cArr[i2] = cArr2[(b & 255) >>> 4];
                        cArr[i2 + 1] = cArr2[b & 15];
                    }
                    str = new String(cArr);
                }
            } finally {
                this.b.release(svVar);
            }
        }
        synchronized (this.f288a) {
            this.f288a.d(nlVar, str);
        }
        return str;
    }
}
