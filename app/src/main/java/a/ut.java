package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ut extends us {
    public static String q(String str) {
        mk.h(str, "<this>");
        mk.h(str, "missingDelimiterValue");
        int iLastIndexOf = str.lastIndexOf(46, str.length() - 1);
        if (iLastIndexOf == -1) {
            return str;
        }
        String strSubstring = str.substring(iLastIndexOf + 1, str.length());
        mk.g(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }
}
