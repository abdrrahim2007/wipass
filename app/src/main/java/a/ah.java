package a;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.collection.ArrayMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ah implements sl, ev, gs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5a;
    public final Object b;
    public final Object c;

    public /* synthetic */ ah(int i, Object obj, Object obj2) {
        this.f5a = i;
        this.b = obj;
        this.c = obj2;
    }

    public static af a(ImageDecoder.Source source, int i, int i2, qu quVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new fv(i, i2, quVar));
        if (q.s(drawableDecodeDrawable)) {
            return new af(0, q.e(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public Object b(rc rcVar) {
        HashMap map = (HashMap) this.c;
        lj ljVar = (lj) map.get(rcVar);
        if (ljVar == null) {
            ljVar = new lj(rcVar);
            map.put(rcVar, ljVar);
        } else {
            rcVar.a();
        }
        lj ljVar2 = ljVar.d;
        ljVar2.c = ljVar.c;
        ljVar.c.d = ljVar2;
        lj ljVar3 = (lj) this.b;
        ljVar.d = ljVar3;
        lj ljVar4 = ljVar3.c;
        ljVar.c = ljVar4;
        ljVar4.d = ljVar;
        ljVar.d.c = ljVar;
        ArrayList arrayList = ljVar.b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return ljVar.b.remove(size - 1);
        }
        return null;
    }

    @Override // a.ev
    public void c(Exception exc) {
        uc ucVar = (uc) this.c;
        pz pzVar = (pz) this.b;
        pz pzVar2 = ucVar.f;
        if (pzVar2 == null || pzVar2 != pzVar) {
            return;
        }
        uc ucVar2 = (uc) this.c;
        pz pzVar3 = (pz) this.b;
        fj fjVar = ucVar2.b;
        eu euVar = ucVar2.g;
        ew ewVar = pzVar3.c;
        fjVar.b(euVar, exc, ewVar, ewVar.e());
    }

    @Override // a.ev
    public void d(Object obj) {
        uc ucVar = (uc) this.c;
        pz pzVar = (pz) this.b;
        pz pzVar2 = ucVar.f;
        if (pzVar2 == null || pzVar2 != pzVar) {
            return;
        }
        uc ucVar2 = (uc) this.c;
        pz pzVar3 = (pz) this.b;
        gd gdVar = ucVar2.f311a.p;
        if (obj != null && gdVar.a(pzVar3.c.e())) {
            ucVar2.e = obj;
            ucVar2.b.k(2);
        } else {
            fj fjVar = ucVar2.b;
            nl nlVar = pzVar3.f247a;
            ew ewVar = pzVar3.c;
            fjVar.a(nlVar, obj, ewVar, ewVar.e(), ucVar2.g);
        }
    }

    public synchronized List e(String str) {
        List arrayList;
        try {
            if (!((ArrayList) this.b).contains(str)) {
                ((ArrayList) this.b).add(str);
            }
            arrayList = (List) ((HashMap) this.c).get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                ((HashMap) this.c).put(str, arrayList);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public synchronized ArrayList f(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.b;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            List<sj> list = (List) ((HashMap) this.c).get((String) obj);
            if (list != null) {
                for (sj sjVar : list) {
                    if ((sjVar.f281a.isAssignableFrom(cls) && cls2.isAssignableFrom(sjVar.b)) && !arrayList.contains(sjVar.b)) {
                        arrayList.add(sjVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public void g(rc rcVar, Object obj) {
        HashMap map = (HashMap) this.c;
        lj ljVar = (lj) map.get(rcVar);
        if (ljVar == null) {
            ljVar = new lj(rcVar);
            ljVar.d = ljVar;
            lj ljVar2 = (lj) this.b;
            ljVar.d = ljVar2.d;
            ljVar.c = ljVar2;
            ljVar2.d = ljVar;
            ljVar.d.c = ljVar;
            map.put(rcVar, ljVar);
        } else {
            rcVar.a();
        }
        if (ljVar.b == null) {
            ljVar.b = new ArrayList();
        }
        ljVar.b.add(obj);
    }

    public void h(String str) {
        ge geVar;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.b).get(str);
                mk.f(obj, "Argument must not be null");
                geVar = (ge) obj;
                int i = geVar.b;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + geVar.b);
                }
                int i2 = i - 1;
                geVar.b = i2;
                if (i2 == 0) {
                    ge geVar2 = (ge) ((HashMap) this.b).remove(str);
                    if (!geVar2.equals(geVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + geVar + ", but actually removed: " + geVar2 + ", safeKey: " + str);
                    }
                    ca caVar = (ca) this.c;
                    synchronized (caVar.f39a) {
                        try {
                            if (caVar.f39a.size() < 10) {
                                caVar.f39a.offer(geVar2);
                            }
                        } finally {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        geVar.f95a.unlock();
    }

    @Override // a.hi
    public boolean i(Object obj, File file, qu quVar) {
        return ((bg) this.c).i(new bk((bj) this.b, ((BitmapDrawable) ((sf) obj).get()).getBitmap()), file, quVar);
    }

    public Object j() {
        lj ljVar = (lj) this.b;
        lj ljVar2 = ljVar.d;
        while (true) {
            boolean zEquals = ljVar2.equals(ljVar);
            Object obj = ljVar2.f166a;
            if (zEquals) {
                return null;
            }
            ArrayList arrayList = ljVar2.b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object objRemove = size > 0 ? ljVar2.b.remove(size - 1) : null;
            if (objRemove != null) {
                return objRemove;
            }
            lj ljVar3 = ljVar2.d;
            ljVar3.c = ljVar2.c;
            ljVar2.c.d = ljVar3;
            ((HashMap) this.c).remove(obj);
            ((rc) obj).a();
            ljVar2 = ljVar2.d;
        }
    }

    @Override // a.gs
    public void l(bj bjVar, Bitmap bitmap) throws IOException {
        IOException iOException = ((id) this.c).b;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            bjVar.k(bitmap);
            throw iOException;
        }
    }

    @Override // a.sl
    public int m(qu quVar) {
        return 2;
    }

    public String toString() {
        switch (this.f5a) {
            case 4:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                lj ljVar = (lj) this.b;
                lj ljVar2 = ljVar.c;
                boolean z = false;
                while (!ljVar2.equals(ljVar)) {
                    sb.append('{');
                    sb.append(ljVar2.f166a);
                    sb.append(':');
                    ArrayList arrayList = ljVar2.b;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    ljVar2 = ljVar2.c;
                    z = true;
                }
                if (z) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // a.gs
    public void u() {
        ro roVar = (ro) this.b;
        synchronized (roVar) {
            roVar.c = roVar.f271a.length;
        }
    }

    public ah(int i) {
        this.f5a = i;
        switch (i) {
            case 4:
                this.b = new lj(null);
                this.c = new HashMap();
                break;
            case 5:
            default:
                this.b = new HashMap();
                this.c = new ca(1);
                break;
            case 6:
                this.b = new AtomicReference();
                this.c = new ArrayMap();
                break;
            case 7:
                this.b = new ArrayList();
                this.c = new HashMap();
                break;
        }
    }

    public ah(kn knVar) {
        this.f5a = 5;
        this.b = new HashMap();
        this.c = knVar;
    }

    public ah(uc ucVar, pz pzVar) {
        this.f5a = 8;
        this.c = ucVar;
        this.b = pzVar;
    }
}
