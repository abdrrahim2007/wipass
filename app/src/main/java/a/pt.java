package a;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class pt {
    public static /* synthetic */ boolean a(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static double b(double d, double d2, double d3) {
        return (Math.sin(d) * d2) + d3;
    }

    public static float c(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String d(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String e(String str, int i) {
        return str + i;
    }

    public static String f(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String g(String str, String str2) {
        return str + str2;
    }

    public static String h(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String i(StringBuilder sb, char c, String str) {
        sb.append(c);
        String string = sb.toString();
        mk.g(string, str);
        return string;
    }

    public static String j(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder k(CharSequence charSequence, String str, js jsVar, String str2, CharSequence charSequence2) {
        mk.h(charSequence, str);
        mk.h(jsVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder l(CharSequence charSequence, String str, jw jwVar, String str2, CharSequence charSequence2) {
        mk.h(charSequence, str);
        mk.h(jwVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    public static StringBuilder m(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        mk.h(charSequence, str);
        mk.h(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    public static StringBuilder n(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder o(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder p(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static void q(int i, int i2, js jsVar) {
        jsVar.invoke(Integer.valueOf(i + i2));
    }

    public static /* synthetic */ void r(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static String s(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ int t(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ String u(int i) {
        switch (i) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }
}
