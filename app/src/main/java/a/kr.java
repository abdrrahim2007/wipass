package a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class kr implements uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f153a;
    public final int b;
    public rw c;
    public final Handler d;
    public final int e;
    public final long f;
    public Bitmap g;

    public kr(Handler handler, int i, long j) {
        if (!wh.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f153a = Integer.MIN_VALUE;
        this.b = Integer.MIN_VALUE;
        this.d = handler;
        this.e = i;
        this.f = j;
    }

    @Override // a.uy
    public final void a(ts tsVar) throws Throwable {
        tsVar.l(this.f153a, this.b);
    }

    @Override // a.uy
    public final void b(rw rwVar) {
        this.c = rwVar;
    }

    @Override // a.uy
    public final rw g() {
        return this.c;
    }

    @Override // a.uy
    public final void h(Drawable drawable) {
        this.g = null;
    }

    @Override // a.uy
    public final void i(Object obj) {
        this.g = (Bitmap) obj;
        Handler handler = this.d;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f);
    }

    @Override // a.nt
    public final void d() {
    }

    @Override // a.nt
    public final void j() {
    }

    @Override // a.nt
    public final void onStart() {
    }

    @Override // a.uy
    public final void c(Drawable drawable) {
    }

    @Override // a.uy
    public final void e(ts tsVar) {
    }

    @Override // a.uy
    public final void f(Drawable drawable) {
    }
}
