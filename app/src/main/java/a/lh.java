package a;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class lh implements nl {
    public final ln b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public lh(URL url) {
        nq nqVar = ln.f169a;
        mk.f(url, "Argument must not be null");
        this.c = url;
        this.d = null;
        mk.f(nqVar, "Argument must not be null");
        this.b = nqVar;
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = c().getBytes(nl.f194a);
        }
        messageDigest.update(this.g);
    }

    public final String c() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        URL url = this.c;
        mk.f(url, "Argument must not be null");
        return url.toString();
    }

    public final URL d() {
        if (this.f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String string = this.d;
                if (TextUtils.isEmpty(string)) {
                    URL url = this.c;
                    mk.f(url, "Argument must not be null");
                    string = url.toString();
                }
                this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f = new URL(this.e);
        }
        return this.f;
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof lh) {
            lh lhVar = (lh) obj;
            if (c().equals(lhVar.c()) && this.b.equals(lhVar.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        if (this.h == 0) {
            int iHashCode = c().hashCode();
            this.h = iHashCode;
            this.h = this.b.hashCode() + (iHashCode * 31);
        }
        return this.h;
    }

    public final String toString() {
        return c();
    }

    public lh(String str) {
        nq nqVar = ln.f169a;
        this.c = null;
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            mk.f(nqVar, "Argument must not be null");
            this.b = nqVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
