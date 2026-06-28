package a;

/* JADX INFO: loaded from: classes.dex */
public final class rs {
    public static String a(kg kgVar) {
        String string = kgVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
