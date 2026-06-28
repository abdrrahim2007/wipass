package a;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class bz implements ew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f37a;
    public final Object b;

    public /* synthetic */ bz(int i, Object obj) {
        this.f37a = i;
        this.b = obj;
    }

    @Override // a.ew
    public final Class a() {
        switch (this.f37a) {
            case 0:
                return ByteBuffer.class;
            default:
                return this.b.getClass();
        }
    }

    @Override // a.ew
    public final void b() {
        int i = this.f37a;
    }

    @Override // a.ew
    public final void cancel() {
        int i = this.f37a;
    }

    @Override // a.ew
    public final int e() {
        switch (this.f37a) {
        }
        return 1;
    }

    @Override // a.ew
    public final void f(rf rfVar, ev evVar) {
        switch (this.f37a) {
            case 0:
                try {
                    evVar.d(cf.a((File) this.b));
                } catch (IOException e) {
                    Log.isLoggable("ByteBufferFileLoader", 3);
                    evVar.c(e);
                    return;
                }
                break;
            default:
                evVar.d(this.b);
                break;
        }
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void g() {
    }

    private final void h() {
    }
}
