package a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ku {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ue f155a;
    public final Handler b;
    public final ArrayList c;
    public final sb d;
    public final bj e;
    public boolean f;
    public boolean g;
    public ry h;
    public kr i;
    public boolean j;
    public kr k;
    public Bitmap l;
    public kr m;
    public int n;
    public int o;
    public int p;

    public ku(com.bumptech.glide.a aVar, ue ueVar, int i, int i2, Bitmap bitmap) {
        bj bjVar = aVar.f395a;
        la laVar = aVar.c;
        Context baseContext = laVar.getBaseContext();
        mk.f(baseContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        sb sbVarB = com.bumptech.glide.a.a(baseContext).e.b(baseContext);
        Context baseContext2 = laVar.getBaseContext();
        mk.f(baseContext2, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        sb sbVarB2 = com.bumptech.glide.a.a(baseContext2).e.b(baseContext2);
        sbVarB2.getClass();
        ry ryVarA = new ry(sbVarB2.f279a, sbVarB2, Bitmap.class, sbVarB2.b).a(sb.k).a(((sd) ((sd) ((sd) new sd().d(gd.b)).r()).n()).h(i, i2));
        this.c = new ArrayList();
        this.d = sbVarB;
        Handler handler = new Handler(Looper.getMainLooper(), new kt(this));
        this.e = bjVar;
        this.b = handler;
        this.h = ryVarA;
        this.f155a = ueVar;
        c(vz.b, bitmap);
    }

    public final void a() {
        int i;
        if (!this.f || this.g) {
            return;
        }
        kr krVar = this.m;
        if (krVar != null) {
            this.m = null;
            b(krVar);
            return;
        }
        this.g = true;
        ue ueVar = this.f155a;
        kv kvVar = ueVar.l;
        int i2 = kvVar.c;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) ((i2 <= 0 || (i = ueVar.k) < 0) ? 0 : (i < 0 || i >= i2) ? -1 : ((kq) kvVar.e.get(i)).i));
        int i3 = (ueVar.k + 1) % ueVar.l.c;
        ueVar.k = i3;
        this.k = new kr(this.b, i3, jUptimeMillis);
        ry ryVarX = this.h.a((sd) new sd().m(new qq(Double.valueOf(Math.random())))).x(ueVar);
        ryVarX.w(this.k, ryVarX);
    }

    public final void b(kr krVar) {
        this.g = false;
        boolean z = this.j;
        Handler handler = this.b;
        if (z) {
            handler.obtainMessage(2, krVar).sendToTarget();
            return;
        }
        if (!this.f) {
            this.m = krVar;
            return;
        }
        if (krVar.g != null) {
            Bitmap bitmap = this.l;
            if (bitmap != null) {
                this.e.k(bitmap);
                this.l = null;
            }
            kr krVar2 = this.i;
            this.i = krVar;
            ArrayList arrayList = this.c;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                km kmVar = (km) ((ks) arrayList.get(size));
                Object callback = kmVar.getCallback();
                while (callback instanceof Drawable) {
                    callback = ((Drawable) callback).getCallback();
                }
                if (callback == null) {
                    kmVar.stop();
                    kmVar.invalidateSelf();
                } else {
                    kmVar.invalidateSelf();
                    kr krVar3 = kmVar.f149a.f148a.i;
                    if ((krVar3 != null ? krVar3.e : -1) == r6.f155a.l.c - 1) {
                        kmVar.f++;
                    }
                    int i = kmVar.g;
                    if (i != -1 && kmVar.f >= i) {
                        ArrayList arrayList2 = kmVar.k;
                        if (arrayList2 != null) {
                            int size2 = arrayList2.size();
                            for (int i2 = 0; i2 < size2; i2++) {
                                ((Animatable2Compat.AnimationCallback) kmVar.k.get(i2)).onAnimationEnd(kmVar);
                            }
                        }
                        kmVar.stop();
                    }
                }
            }
            if (krVar2 != null) {
                handler.obtainMessage(2, krVar2).sendToTarget();
            }
        }
        a();
    }

    public final void c(vo voVar, Bitmap bitmap) {
        mk.f(voVar, "Argument must not be null");
        mk.f(bitmap, "Argument must not be null");
        this.l = bitmap;
        this.h = this.h.a(new sd().p(voVar, true));
        this.n = wh.c(bitmap);
        this.o = bitmap.getWidth();
        this.p = bitmap.getHeight();
    }
}
