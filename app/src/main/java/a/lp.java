package a;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class lp extends IOException {
    private static final long serialVersionUID = 1;

    public lp(String str, int i, IOException iOException) {
        super(str + ", status code: " + i, iOException);
    }
}
