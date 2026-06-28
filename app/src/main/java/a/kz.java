package a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public abstract class kz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gw f160a = new gw(9);
    public static final fb b = new fb(11, "NULL");

    public static ny a(ny nyVar) {
        if (nyVar.e != null) {
            throw new IllegalStateException();
        }
        nyVar.e();
        nyVar.d = true;
        return nyVar;
    }

    public static bk b(bj bjVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            if (i != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i2 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i2 = current.getIntrinsicHeight();
                    }
                    Lock lock = vq.b;
                    lock.lock();
                    Bitmap bitmapJ = bjVar.j(i, i2, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapJ);
                        current.setBounds(0, 0, i, i2);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = bitmapJ;
                        z = true;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    current.toString();
                }
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                current.toString();
            }
            bitmap = null;
            z = true;
        }
        if (!z) {
            bjVar = f160a;
        }
        return bk.c(bjVar, bitmap);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class c(nd ndVar) {
        mk.h(ndVar, "<this>");
        Class clsA = ((cv) ndVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals(TypedValues.Custom.S_FLOAT)) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    public static boolean d(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String lowerCase = str.trim().toLowerCase();
        return lowerCase.startsWith("wifi_perso") ? !lowerCase.contains("5") : lowerCase.startsWith("adsl_inwi") || lowerCase.matches("adsl_inwi_(2\\.4g|5g)_[a-f0-9]{4}") || lowerCase.matches("adsl_inwi_[a-f0-9]{4}_(2\\.4g|5g)") || lowerCase.matches("(fh|04fs)_[a-f0-9]{6}(_(2\\.4g|5g))?");
    }

    public static List e(Object obj) {
        List listSingletonList = Collections.singletonList(obj);
        mk.g(listSingletonList, "singletonList(element)");
        return listSingletonList;
    }

    public static final void f(cl clVar, ec ecVar, boolean z) {
        Object objF = clVar.f();
        Throwable thC = clVar.c(objF);
        Object objB = thC != null ? pd.b(thC) : clVar.d(objF);
        if (!z) {
            ecVar.resumeWith(objB);
            return;
        }
        gm gmVar = (gm) ecVar;
        ec ecVar2 = gmVar.e;
        Object obj = gmVar.g;
        ei context = ecVar2.getContext();
        Object objP = mk.p(context, obj);
        vv vvVarN = objP != mk.b ? pd.n(ecVar2, context, objP) : null;
        try {
            gmVar.e.resumeWith(objB);
            if (vvVarN == null || vvVarN.ab()) {
                mk.n(context, objP);
            }
        } catch (Throwable th) {
            if (vvVarN == null || vvVarN.ab()) {
                mk.n(context, objP);
            }
            throw th;
        }
    }
}
