package a;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class sv implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MessageDigest f287a;
    public final uh b = new uh();

    public sv(MessageDigest messageDigest) {
        this.f287a = messageDigest;
    }

    @Override // a.in
    public final uh c() {
        return this.b;
    }
}
