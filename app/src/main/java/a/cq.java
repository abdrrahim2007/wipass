package a;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class cq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f48a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        mk.g(charsetForName, "forName(\"UTF-8\")");
        f48a = charsetForName;
        mk.g(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        mk.g(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        mk.g(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        mk.g(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        mk.g(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
