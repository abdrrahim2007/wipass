package a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;
import androidx.tracing.Trace;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class tw implements lg {
    public static volatile tw e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f306a;
    public boolean b;
    public final Object c;
    public final AbstractCollection d;

    public tw() {
        this.f306a = 2;
        this.c = Collections.newSetFromMap(new WeakHashMap());
        this.d = new HashSet();
    }

    public static tw b(Context context) {
        if (e == null) {
            synchronized (tw.class) {
                try {
                    if (e == null) {
                        e = new tw(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public boolean a(rw rwVar) {
        boolean z = true;
        if (rwVar == null) {
            return true;
        }
        boolean zRemove = ((Set) this.c).remove(rwVar);
        if (!((HashSet) this.d).remove(rwVar) && !zRemove) {
            z = false;
        }
        if (z) {
            rwVar.clear();
        }
        return z;
    }

    public void c() {
        if (this.b || ((HashSet) this.d).isEmpty()) {
            return;
        }
        gh ghVar = (gh) this.c;
        hp hpVar = (hp) ghVar.c;
        boolean z = false;
        ghVar.f97a = ((ConnectivityManager) hpVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) hpVar.get()).registerDefaultNetworkCallback((tv) ghVar.d);
            z = true;
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
        }
        this.b = z;
    }

    @Override // a.lg
    public Object get() {
        if (this.b) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        Trace.beginSection("Glide registry");
        this.b = true;
        try {
            return bs.a((com.bumptech.glide.a) this.c, (ArrayList) this.d);
        } finally {
            this.b = false;
            Trace.endSection();
        }
    }

    public String toString() {
        switch (this.f306a) {
            case 2:
                return super.toString() + "{numRequests=" + ((Set) this.c).size() + ", isPaused=" + this.b + "}";
            default:
                return super.toString();
        }
    }

    public tw(Context context) {
        this.f306a = 0;
        this.d = new HashSet();
        this.c = new gh(new hp(new ga(context, 9)), new tt(this));
    }

    public tw(com.bumptech.glide.a aVar, ArrayList arrayList, vs vsVar) {
        this.f306a = 1;
        this.c = aVar;
        this.d = arrayList;
    }
}
