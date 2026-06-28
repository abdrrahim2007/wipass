package a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fb f32a;
    public static final fb b;
    public static final fb c;
    public static final fb d;
    public static final fb e;
    public static final fb f;
    public static final ha g = new ha(false);
    public static final ha h = new ha(true);

    static {
        int i = 11;
        f32a = new fb(i, "NO_DECISION");
        b = new fb(i, "COMPLETING_ALREADY");
        c = new fb(i, "COMPLETING_WAITING_CHILDREN");
        d = new fb(i, "COMPLETING_RETRY");
        e = new fb(i, "TOO_LATE_TO_CANCEL");
        f = new fb(i, "SEALED");
    }

    public static ru a(com.bumptech.glide.a aVar, ArrayList arrayList) {
        Class cls;
        si bwVar;
        si beVar;
        bj bjVar;
        int i;
        String str;
        Class cls2;
        bj bjVar2 = aVar.f395a;
        on onVar = aVar.d;
        la laVar = aVar.c;
        Context applicationContext = laVar.getApplicationContext();
        fb fbVar = laVar.h;
        ru ruVar = new ru();
        fr frVar = new fr();
        hk hkVar = ruVar.g;
        synchronized (hkVar) {
            hkVar.f116a.add(frVar);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            ih ihVar = new ih();
            hk hkVar2 = ruVar.g;
            synchronized (hkVar2) {
                cls = AssetFileDescriptor.class;
                hkVar2.f116a.add(ihVar);
            }
        } else {
            cls = AssetFileDescriptor.class;
        }
        Resources resources = applicationContext.getResources();
        ArrayList arrayListE = ruVar.e();
        cb cbVar = new cb(applicationContext, arrayListE, bjVar2, onVar);
        wm wmVar = new wm(bjVar2, new kn(21));
        gt gtVar = new gt(ruVar.e(), resources.getDisplayMetrics(), bjVar2, onVar);
        if (i2 < 28 || !((Map) fbVar.b).containsKey(ky.class)) {
            bwVar = new bw(gtVar, 0);
            beVar = new be(2, gtVar, onVar);
        } else {
            beVar = new bx(1);
            bwVar = new bx(0);
        }
        if (i2 >= 28) {
            i = i2;
            bjVar = bjVar2;
            ruVar.d("Animation", InputStream.class, Drawable.class, new ag(new ah(0, arrayListE, onVar), 1));
            int i3 = 0;
            ruVar.d("Animation", ByteBuffer.class, Drawable.class, new ag(new ah(i3, arrayListE, onVar), i3));
        } else {
            bjVar = bjVar2;
            i = i2;
        }
        sk skVar = new sk(applicationContext);
        bg bgVar = new bg(onVar);
        bd bdVar = new bd();
        ee eeVar = new ee(29);
        ContentResolver contentResolver = applicationContext.getContentResolver();
        ruVar.a(ByteBuffer.class, new ee(14));
        ruVar.a(InputStream.class, new fb(10, onVar));
        ruVar.d("Bitmap", ByteBuffer.class, Bitmap.class, bwVar);
        ruVar.d("Bitmap", InputStream.class, Bitmap.class, beVar);
        String str2 = Build.FINGERPRINT;
        if ("robolectric".equals(str2)) {
            str = str2;
            cls2 = ParcelFileDescriptor.class;
        } else {
            str = str2;
            bw bwVar2 = new bw(gtVar, 1);
            cls2 = ParcelFileDescriptor.class;
            ruVar.d("Bitmap", cls2, Bitmap.class, bwVar2);
        }
        bj bjVar3 = bjVar;
        ruVar.d("Bitmap", cls, Bitmap.class, new wm(bjVar3, new kn(18)));
        ruVar.d("Bitmap", cls2, Bitmap.class, wmVar);
        ee eeVar2 = ee.h;
        ruVar.c(Bitmap.class, Bitmap.class, eeVar2);
        ruVar.d("Bitmap", Bitmap.class, Bitmap.class, new is(1));
        ruVar.b(Bitmap.class, bgVar);
        ruVar.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new be(resources, bwVar));
        ruVar.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new be(resources, beVar));
        ruVar.d("BitmapDrawable", cls2, BitmapDrawable.class, new be(resources, wmVar));
        ruVar.b(BitmapDrawable.class, new ah(1, bjVar3, bgVar));
        ruVar.d("Animation", InputStream.class, km.class, new ui(arrayListE, cbVar, onVar));
        ruVar.d("Animation", ByteBuffer.class, km.class, cbVar);
        ruVar.b(km.class, new kn(0));
        ruVar.c(ue.class, ue.class, eeVar2);
        ruVar.d("Bitmap", ue.class, Bitmap.class, new bh(bjVar3));
        ruVar.d("legacy_append", Uri.class, Drawable.class, skVar);
        ruVar.d("legacy_append", Uri.class, Bitmap.class, new be(1, skVar, bjVar3));
        ruVar.h(new cc(0));
        ruVar.c(File.class, ByteBuffer.class, new ee(15));
        ruVar.c(File.class, InputStream.class, new iv(new ee(27)));
        ruVar.d("legacy_append", File.class, File.class, new is(0));
        ruVar.c(File.class, cls2, new iv(new ee(26)));
        ruVar.c(File.class, File.class, eeVar2);
        ruVar.h(new mc(onVar));
        if (!"robolectric".equals(str)) {
            ruVar.h(new cc(2));
        }
        ga gaVar = new ga(applicationContext, 2);
        ga gaVar2 = new ga(applicationContext, 0);
        ga gaVar3 = new ga(applicationContext, 1);
        Class cls3 = Integer.TYPE;
        ruVar.c(cls3, InputStream.class, gaVar);
        ruVar.c(Integer.class, InputStream.class, gaVar);
        Class cls4 = cls;
        ruVar.c(cls3, cls4, gaVar2);
        ruVar.c(Integer.class, cls4, gaVar2);
        ruVar.c(cls3, Drawable.class, gaVar3);
        ruVar.c(Integer.class, Drawable.class, gaVar3);
        ruVar.c(Uri.class, InputStream.class, new ga(applicationContext, 8));
        ruVar.c(Uri.class, cls4, new ga(applicationContext, 7));
        bf bfVar = new bf(resources, 3);
        bf bfVar2 = new bf(resources, 1);
        bf bfVar3 = new bf(resources, 2);
        ruVar.c(Integer.class, Uri.class, bfVar);
        ruVar.c(cls3, Uri.class, bfVar);
        ruVar.c(Integer.class, cls4, bfVar2);
        ruVar.c(cls3, cls4, bfVar2);
        ruVar.c(Integer.class, InputStream.class, bfVar3);
        ruVar.c(cls3, InputStream.class, bfVar3);
        ruVar.c(String.class, InputStream.class, new fb(1));
        ruVar.c(Uri.class, InputStream.class, new fb(1));
        ruVar.c(String.class, InputStream.class, new kn(15));
        ruVar.c(String.class, cls2, new kn(14));
        ruVar.c(String.class, cls4, new kn(13));
        ruVar.c(Uri.class, InputStream.class, new aw(applicationContext.getAssets(), 1));
        ruVar.c(Uri.class, cls4, new aw(applicationContext.getAssets(), 0));
        ruVar.c(Uri.class, InputStream.class, new ga(applicationContext, 5));
        ruVar.c(Uri.class, InputStream.class, new ga(applicationContext, 6));
        if (i >= 29) {
            ruVar.c(Uri.class, InputStream.class, new rh(applicationContext, InputStream.class));
            ruVar.c(Uri.class, cls2, new rh(applicationContext, cls2));
        }
        ruVar.c(Uri.class, InputStream.class, new vh(contentResolver, 4));
        ruVar.c(Uri.class, cls2, new vh(contentResolver, 3));
        ruVar.c(Uri.class, cls4, new vh(contentResolver, 2));
        ruVar.c(Uri.class, InputStream.class, new kn(17));
        ruVar.c(URL.class, InputStream.class, new kn(16));
        ruVar.c(Uri.class, File.class, new ga(applicationContext, 4));
        ruVar.c(lh.class, InputStream.class, new fb(5));
        ruVar.c(byte[].class, ByteBuffer.class, new ee(11));
        ruVar.c(byte[].class, InputStream.class, new ee(13));
        ruVar.c(Uri.class, Uri.class, eeVar2);
        ruVar.c(Drawable.class, Drawable.class, eeVar2);
        ruVar.d("legacy_append", Drawable.class, Drawable.class, new is(2));
        ruVar.i(Bitmap.class, BitmapDrawable.class, new bf(resources, 0));
        ruVar.i(Bitmap.class, byte[].class, bdVar);
        ruVar.i(Drawable.class, byte[].class, new z(bjVar3, bdVar, eeVar, 3));
        ruVar.i(km.class, byte[].class, eeVar);
        wm wmVar2 = new wm(bjVar3, new kn(19));
        ruVar.d("legacy_append", ByteBuffer.class, Bitmap.class, wmVar2);
        ruVar.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new be(resources, wmVar2));
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            return ruVar;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    public static int b(List list, InputStream inputStream, on onVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new ro(inputStream, onVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int iD = ((lw) list.get(i)).d(inputStream, onVar);
                if (iD != -1) {
                    return iD;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType c(List list, InputStream inputStream, on onVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new ro(inputStream, onVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeC = ((lw) list.get(i)).c(inputStream);
                inputStream.reset();
                if (imageHeaderParser$ImageTypeC != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeC;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType d(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser$ImageType imageHeaderParser$ImageTypeA = ((lw) list.get(i)).a(byteBuffer);
                AtomicReference atomicReference = cf.f44a;
                if (imageHeaderParser$ImageTypeA != ImageHeaderParser$ImageType.UNKNOWN) {
                    return imageHeaderParser$ImageTypeA;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = cf.f44a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ei e(eg egVar, eh ehVar) {
        mk.h(ehVar, "key");
        return mk.a(egVar.getKey(), ehVar) ? hb.f109a : egVar;
    }

    public static void f(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + cls.getDeclaredConstructor(null).newInstance(null));
            } catch (IllegalAccessException e2) {
                h(cls, e2);
                throw null;
            } catch (InstantiationException e3) {
                h(cls, e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                h(cls, e4);
                throw null;
            } catch (InvocationTargetException e5) {
                h(cls, e5);
                throw null;
            }
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    public static final Object g(sz szVar, sz szVar2, jw jwVar) throws Throwable {
        Object dnVar;
        Object objU;
        ly lyVar;
        try {
            vs.b(jwVar);
            dnVar = jwVar.invoke(szVar2, szVar);
        } catch (Throwable th) {
            dnVar = new dn(false, th);
        }
        eq eqVar = eq.f74a;
        if (dnVar == eqVar || (objU = szVar.u(dnVar)) == c) {
            return eqVar;
        }
        if (objU instanceof dn) {
            throw ((dn) objU).f58a;
        }
        lz lzVar = objU instanceof lz ? (lz) objU : null;
        return (lzVar == null || (lyVar = lzVar.f176a) == null) ? objU : lyVar;
    }

    public static void h(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }
}
