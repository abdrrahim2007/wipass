package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class ra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qz f261a;

    static {
        qz qzVar;
        Object objNewInstance;
        try {
            objNewInstance = ms.class.newInstance();
            mk.g(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
        } catch (ClassNotFoundException unused) {
            Object objNewInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            mk.g(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    qzVar = (qz) objNewInstance2;
                } catch (ClassCastException e) {
                    ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                    ClassLoader classLoader2 = qz.class.getClassLoader();
                    if (mk.a(classLoader, classLoader2)) {
                        throw e;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                }
            } catch (ClassNotFoundException unused2) {
                Object objNewInstance3 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                mk.g(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    qzVar = (qz) objNewInstance3;
                } catch (ClassCastException e2) {
                    ClassLoader classLoader3 = objNewInstance3.getClass().getClassLoader();
                    ClassLoader classLoader4 = qz.class.getClassLoader();
                    if (mk.a(classLoader3, classLoader4)) {
                        throw e2;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
                }
            }
        }
        try {
            try {
                qzVar = (qz) objNewInstance;
            } catch (ClassNotFoundException unused3) {
                Object objNewInstance4 = mq.class.newInstance();
                mk.g(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        qzVar = (qz) objNewInstance4;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = objNewInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = qz.class.getClassLoader();
                        if (mk.a(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                } catch (ClassNotFoundException unused4) {
                    qzVar = new qz();
                }
            }
            f261a = qzVar;
        } catch (ClassCastException e4) {
            ClassLoader classLoader7 = objNewInstance.getClass().getClassLoader();
            ClassLoader classLoader8 = qz.class.getClassLoader();
            if (mk.a(classLoader7, classLoader8)) {
                throw e4;
            }
            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
        }
    }
}
