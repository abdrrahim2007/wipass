package a;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class ch implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ch f46a = new ch();

    private Object readResolve() throws ObjectStreamException {
        return f46a;
    }
}
