package a;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class mf extends md {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180a;
    public final int b;
    public boolean c;
    public int d;

    public mf(int i, int i2, int i3) {
        this.f180a = i3;
        this.b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // a.md
    public final int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.f180a + i;
            return i;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return i;
    }
}
