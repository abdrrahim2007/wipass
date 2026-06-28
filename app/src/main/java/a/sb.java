package a;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class sb implements ComponentCallbacks2, nt {
    public static final sd k;
    public static final sd l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bumptech.glide.a f279a;
    public final Context b;
    public final nr c;
    public final tw d;
    public final sc e;
    public final uz f;
    public final w g;
    public final dx h;
    public final CopyOnWriteArrayList i;
    public final sd j;

    static {
        sd sdVar = (sd) new sd().c(Bitmap.class);
        sdVar.l = true;
        k = sdVar;
        sd sdVar2 = (sd) new sd().c(km.class);
        sdVar2.l = true;
        l = sdVar2;
    }

    public sb(com.bumptech.glide.a aVar, nr nrVar, sc scVar, Context context) {
        sd sdVar;
        tw twVar = new tw();
        ee eeVar = aVar.f;
        this.f = new uz();
        w wVar = new w(2, this);
        this.g = wVar;
        this.f279a = aVar;
        this.c = nrVar;
        this.e = scVar;
        this.d = twVar;
        this.b = context;
        Context applicationContext = context.getApplicationContext();
        sa saVar = new sa(this, twVar);
        eeVar.getClass();
        boolean z = ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        Log.isLoggable("ConnectivityMonitor", 3);
        dx flVar = z ? new fl(applicationContext, saVar) : new qp();
        this.h = flVar;
        synchronized (aVar.g) {
            if (aVar.g.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            aVar.g.add(this);
        }
        char[] cArr = wh.f346a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            nrVar.r(this);
        } else {
            wh.f().post(wVar);
        }
        nrVar.r(flVar);
        this.i = new CopyOnWriteArrayList(aVar.c.e);
        la laVar = aVar.c;
        synchronized (laVar) {
            try {
                if (laVar.j == null) {
                    laVar.d.getClass();
                    sd sdVar2 = new sd();
                    sdVar2.l = true;
                    laVar.j = sdVar2;
                }
                sdVar = laVar.j;
            } finally {
            }
        }
        synchronized (this) {
            sd sdVar3 = (sd) sdVar.clone();
            if (sdVar3.l && !sdVar3.n) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            sdVar3.n = true;
            sdVar3.l = true;
            this.j = sdVar3;
        }
    }

    @Override // a.nt
    public final synchronized void d() {
        this.f.d();
        l();
    }

    @Override // a.nt
    public final synchronized void j() {
        int i;
        this.f.j();
        synchronized (this) {
            try {
                ArrayList arrayListE = wh.e(this.f.f321a);
                int size = arrayListE.size();
                i = 0;
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayListE.get(i2);
                    i2++;
                    k((uy) obj);
                }
                this.f.f321a.clear();
            } finally {
            }
        }
        tw twVar = this.d;
        ArrayList arrayListE2 = wh.e((Set) twVar.c);
        int size2 = arrayListE2.size();
        while (i < size2) {
            Object obj2 = arrayListE2.get(i);
            i++;
            twVar.a((rw) obj2);
        }
        ((HashSet) twVar.d).clear();
        this.c.d(this);
        this.c.d(this.h);
        wh.f().removeCallbacks(this.g);
        com.bumptech.glide.a aVar = this.f279a;
        synchronized (aVar.g) {
            if (!aVar.g.contains(this)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            aVar.g.remove(this);
        }
    }

    public final void k(uy uyVar) {
        if (uyVar == null) {
            return;
        }
        boolean zN = n(uyVar);
        rw rwVarG = uyVar.g();
        if (zN) {
            return;
        }
        com.bumptech.glide.a aVar = this.f279a;
        synchronized (aVar.g) {
            try {
                ArrayList arrayList = aVar.g;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((sb) obj).n(uyVar)) {
                        return;
                    }
                }
                if (rwVarG != null) {
                    uyVar.b(null);
                    rwVarG.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void l() {
        tw twVar = this.d;
        twVar.b = true;
        ArrayList arrayListE = wh.e((Set) twVar.c);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            rw rwVar = (rw) obj;
            if (rwVar.isRunning()) {
                rwVar.d();
                ((HashSet) twVar.d).add(rwVar);
            }
        }
    }

    public final synchronized void m() {
        tw twVar = this.d;
        int i = 0;
        twVar.b = false;
        ArrayList arrayListE = wh.e((Set) twVar.c);
        int size = arrayListE.size();
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            rw rwVar = (rw) obj;
            if (!rwVar.i() && !rwVar.isRunning()) {
                rwVar.f();
            }
        }
        ((HashSet) twVar.d).clear();
    }

    public final synchronized boolean n(uy uyVar) {
        rw rwVarG = uyVar.g();
        if (rwVarG == null) {
            return true;
        }
        if (!this.d.a(rwVarG)) {
            return false;
        }
        this.f.f321a.remove(uyVar);
        uyVar.b(null);
        return true;
    }

    @Override // a.nt
    public final synchronized void onStart() {
        m();
        this.f.onStart();
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.d + ", treeNode=" + this.e + "}";
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
    }
}
