package a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.FileInputStream;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public final class z implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f367a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ z(Object obj, Object obj2, Object obj3, int i) {
        this.f367a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public synchronized void a(nl nlVar, hy hyVar) {
        y yVar = (y) ((HashMap) this.b).put(nlVar, new y(nlVar, hyVar, (ReferenceQueue) this.c));
        if (yVar != null) {
            yVar.c = null;
            yVar.clear();
        }
    }

    @Override // a.sp
    public sf b(sf sfVar, qu quVar) {
        Drawable drawable = (Drawable) sfVar.get();
        if (drawable instanceof BitmapDrawable) {
            return ((bd) this.c).b(bk.c((bj) this.b, ((BitmapDrawable) drawable).getBitmap()), quVar);
        }
        if (drawable instanceof km) {
            return ((ee) this.d).b(sfVar, quVar);
        }
        return null;
    }

    public void c(y yVar) {
        sf sfVar;
        synchronized (this) {
            ((HashMap) this.b).remove(yVar.f366a);
            if (yVar.b && (sfVar = yVar.c) != null) {
                ((hq) this.d).d(yVar.f366a, new hy(sfVar, true, false, yVar.f366a, (hq) this.d));
            }
        }
    }

    public Bitmap d(BitmapFactory.Options options) {
        switch (this.f367a) {
            case 5:
                return BitmapFactory.decodeStream(new ce(cf.c((ByteBuffer) this.b)), null, options);
            case 6:
                ro roVar = (ro) ((fb) this.b).b;
                roVar.reset();
                return BitmapFactory.decodeStream(roVar, null, options);
            default:
                return BitmapFactory.decodeFileDescriptor(((com.bumptech.glide.load.data.a) this.d).a().getFileDescriptor(), null, options);
        }
    }

    public ImageHeaderParser$ImageType e() throws Throwable {
        ro roVar;
        switch (this.f367a) {
            case 5:
                return bs.d((List) this.c, cf.c((ByteBuffer) this.b));
            case 6:
                List list = (List) this.d;
                ro roVar2 = (ro) ((fb) this.b).b;
                roVar2.reset();
                return bs.c(list, roVar2, (on) this.c);
            default:
                List list2 = (List) this.c;
                com.bumptech.glide.load.data.a aVar = (com.bumptech.glide.load.data.a) this.d;
                on onVar = (on) this.b;
                int size = list2.size();
                for (int i = 0; i < size; i++) {
                    lw lwVar = (lw) list2.get(i);
                    ro roVar3 = null;
                    try {
                        roVar = new ro(new FileInputStream(aVar.a().getFileDescriptor()), onVar);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        ImageHeaderParser$ImageType imageHeaderParser$ImageTypeC = lwVar.c(roVar);
                        roVar.b();
                        aVar.a();
                        if (imageHeaderParser$ImageTypeC != ImageHeaderParser$ImageType.UNKNOWN) {
                            return imageHeaderParser$ImageTypeC;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        roVar3 = roVar;
                        if (roVar3 != null) {
                            roVar3.b();
                        }
                        aVar.a();
                        throw th;
                    }
                    break;
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    public z(int i) {
        this.f367a = i;
        switch (i) {
            case 2:
                break;
            default:
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new x(0));
                this.b = new HashMap();
                this.c = new ReferenceQueue();
                executorServiceNewSingleThreadExecutor.execute(new w(1, this));
                break;
        }
    }

    public z(pe peVar, ArrayList arrayList, on onVar) {
        this.f367a = 6;
        mk.f(onVar, "Argument must not be null");
        this.c = onVar;
        mk.f(arrayList, "Argument must not be null");
        this.d = arrayList;
        this.b = new fb(peVar, onVar);
    }

    public z(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, on onVar) {
        this.f367a = 7;
        mk.f(onVar, "Argument must not be null");
        this.b = onVar;
        mk.f(arrayList, "Argument must not be null");
        this.c = arrayList;
        this.d = new com.bumptech.glide.load.data.a(parcelFileDescriptor);
    }

    public z(hq hqVar, ts tsVar, hu huVar) {
        this.f367a = 4;
        this.d = hqVar;
        this.c = tsVar;
        this.b = huVar;
    }

    private final void f() {
    }

    private final void g() {
    }
}
