package a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public final class uk extends ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ul f316a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uk(ul ulVar, int i) {
        super(i);
        this.f316a = ulVar;
    }

    @Override // java.io.ByteArrayOutputStream
    public final String toString() {
        int i = ((ByteArrayOutputStream) this).count;
        if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
            i--;
        }
        try {
            return new String(((ByteArrayOutputStream) this).buf, 0, i, this.f316a.b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
