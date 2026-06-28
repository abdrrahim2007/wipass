package a;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class tz {
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;
    public static final Bitmap.Config[] f;
    public static final Bitmap.Config[] g;
    public static final Bitmap.Config[] h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final om f309a = new om(1);
    public final ah b = new ah(4);
    public final HashMap c = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        d = configArr;
        e = configArr;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public static String c(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapD.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapD.remove(num);
                return;
            } else {
                navigableMapD.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(wh.c(bitmap), bitmap.getConfig()) + ", this: " + this);
    }

    public final Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int iD = wh.d(config) * i * i2;
        om omVar = this.f309a;
        rc rcVarB = (rc) ((ArrayDeque) omVar.f21a).poll();
        if (rcVarB == null) {
            rcVarB = omVar.b();
        }
        ty tyVar = (ty) rcVarB;
        tyVar.b = iD;
        tyVar.c = config;
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            int i3 = tx.f307a[config.ordinal()];
            configArr = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? new Bitmap.Config[]{config} : h : g : f : d;
        } else {
            configArr = e;
        }
        int length = configArr.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i4];
            Integer num = (Integer) d(config2).ceilingKey(Integer.valueOf(iD));
            if (num == null || num.intValue() > iD * 8) {
                i4++;
            } else if (num.intValue() != iD || (config2 != null ? !config2.equals(config) : config != null)) {
                omVar.a(tyVar);
                int iIntValue = num.intValue();
                rc rcVarB2 = (rc) ((ArrayDeque) omVar.f21a).poll();
                if (rcVarB2 == null) {
                    rcVarB2 = omVar.b();
                }
                tyVar = (ty) rcVarB2;
                tyVar.b = iIntValue;
                tyVar.c = config2;
            }
        }
        Bitmap bitmap = (Bitmap) this.b.b(tyVar);
        if (bitmap != null) {
            a(Integer.valueOf(tyVar.b), bitmap);
            bitmap.reconfigure(i, i2, config);
        }
        return bitmap;
    }

    public final NavigableMap d(Bitmap.Config config) {
        HashMap map = this.c;
        NavigableMap navigableMap = (NavigableMap) map.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        map.put(config, treeMap);
        return treeMap;
    }

    public final void e(Bitmap bitmap) {
        int iC = wh.c(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        om omVar = this.f309a;
        rc rcVarB = (rc) ((ArrayDeque) omVar.f21a).poll();
        if (rcVarB == null) {
            rcVarB = omVar.b();
        }
        ty tyVar = (ty) rcVarB;
        tyVar.b = iC;
        tyVar.c = config;
        this.b.g(tyVar, bitmap);
        NavigableMap navigableMapD = d(bitmap.getConfig());
        Integer num = (Integer) navigableMapD.get(Integer.valueOf(tyVar.b));
        navigableMapD.put(Integer.valueOf(tyVar.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final String toString() {
        StringBuilder sbN = pt.n("SizeConfigStrategy{groupedMap=");
        sbN.append(this.b);
        sbN.append(", sortedSizes=(");
        HashMap map = this.c;
        for (Map.Entry entry : map.entrySet()) {
            sbN.append(entry.getKey());
            sbN.append('[');
            sbN.append(entry.getValue());
            sbN.append("], ");
        }
        if (!map.isEmpty()) {
            sbN.replace(sbN.length() - 2, sbN.length(), "");
        }
        sbN.append(")}");
        return sbN.toString();
    }
}
