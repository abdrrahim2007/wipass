package a;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class ad implements nl {
    public final int b;
    public final nl c;

    public ad(int i, nl nlVar) {
        this.b = i;
        this.c = nlVar;
    }

    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof ad) {
            ad adVar = (ad) obj;
            if (this.b == adVar.b && this.c.equals(adVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        return wh.h(this.b, this.c);
    }
}
