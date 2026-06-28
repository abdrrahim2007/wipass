package a;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class id extends InputStream {
    public static final ArrayDeque c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ro f131a;
    public IOException b;

    static {
        char[] cArr = wh.f346a;
        c = new ArrayDeque(0);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f131a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f131a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f131a.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f131a.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        try {
            return this.f131a.read();
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f131a.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        try {
            return this.f131a.skip(j);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        try {
            return this.f131a.read(bArr);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f131a.read(bArr, i, i2);
        } catch (IOException e) {
            this.b = e;
            throw e;
        }
    }
}
