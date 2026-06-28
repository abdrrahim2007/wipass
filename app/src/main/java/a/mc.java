package a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class mc implements ez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final on f178a;

    public mc(on onVar) {
        this.f178a = onVar;
    }

    @Override // a.ez
    public final Class a() {
        return InputStream.class;
    }

    @Override // a.ez
    public final fa b(Object obj) {
        return new fb((InputStream) obj, this.f178a);
    }
}
