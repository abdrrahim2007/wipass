package a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.io.InputStream;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class be implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f24a;
    public final Object b;
    public final Object c;

    public /* synthetic */ be(int i, Object obj, Object obj2) {
        this.f24a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // a.si
    public final sf a(Object obj, int i, int i2, qu quVar) {
        boolean z;
        ro roVar;
        id idVar;
        switch (this.f24a) {
            case 0:
                sf sfVarA = ((si) this.b).a(obj, i, i2, quVar);
                Resources resources = (Resources) this.c;
                if (sfVarA == null) {
                    return null;
                }
                return new bk(resources, sfVarA);
            case 1:
                sf sfVarC = ((sk) this.b).c((Uri) obj, quVar);
                if (sfVarC == null) {
                    return null;
                }
                return kz.b((bj) this.c, (Drawable) ((ko) sfVarC).get(), i, i2);
            default:
                InputStream inputStream = (InputStream) obj;
                if (inputStream instanceof ro) {
                    roVar = (ro) inputStream;
                    z = false;
                } else {
                    z = true;
                    roVar = new ro(inputStream, (on) this.c);
                }
                ArrayDeque arrayDeque = id.c;
                synchronized (arrayDeque) {
                    idVar = (id) arrayDeque.poll();
                    break;
                }
                if (idVar == null) {
                    idVar = new id();
                }
                id idVar2 = idVar;
                idVar2.f131a = roVar;
                pe peVar = new pe(idVar2);
                ah ahVar = new ah(9, roVar, idVar2);
                try {
                    gt gtVar = (gt) this.b;
                    bk bkVarA = gtVar.a(new z(peVar, gtVar.d, gtVar.c), i, i2, quVar, ahVar);
                    idVar2.b = null;
                    idVar2.f131a = null;
                    synchronized (arrayDeque) {
                        arrayDeque.offer(idVar2);
                        break;
                    }
                    if (z) {
                        roVar.b();
                    }
                    return bkVarA;
                } catch (Throwable th) {
                    idVar2.b = null;
                    idVar2.f131a = null;
                    ArrayDeque arrayDeque2 = id.c;
                    synchronized (arrayDeque2) {
                        arrayDeque2.offer(idVar2);
                        if (!z) {
                            throw th;
                        }
                        roVar.b();
                        throw th;
                    }
                }
        }
    }

    @Override // a.si
    public final boolean b(Object obj, qu quVar) {
        switch (this.f24a) {
            case 0:
                return ((si) this.b).b(obj, quVar);
            case 1:
                return "android.resource".equals(((Uri) obj).getScheme());
            default:
                ((gt) this.b).getClass();
                return true;
        }
    }

    public be(Resources resources, si siVar) {
        this.f24a = 0;
        this.c = resources;
        this.b = siVar;
    }
}
