package a;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class sh implements nl {
    public static final oq j = new oq(50);
    public final on b;
    public final nl c;
    public final nl d;
    public final int e;
    public final int f;
    public final Class g;
    public final qu h;
    public final vo i;

    public sh(on onVar, nl nlVar, nl nlVar2, int i, int i2, vo voVar, Class cls, qu quVar) {
        this.b = onVar;
        this.c = nlVar;
        this.d = nlVar2;
        this.e = i;
        this.f = i2;
        this.i = voVar;
        this.g = cls;
        this.h = quVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // a.nl
    public final void b(MessageDigest messageDigest) {
        Object objE;
        on onVar = this.b;
        synchronized (onVar) {
            om omVar = onVar.b;
            rc rcVarB = (rc) ((ArrayDeque) omVar.f21a).poll();
            if (rcVarB == null) {
                rcVarB = omVar.b();
            }
            ol olVar = (ol) rcVarB;
            olVar.b = 8;
            olVar.c = byte[].class;
            objE = onVar.e(olVar, byte[].class);
        }
        byte[] bArr = (byte[]) objE;
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        vo voVar = this.i;
        if (voVar != null) {
            voVar.b(messageDigest);
        }
        this.h.b(messageDigest);
        oq oqVar = j;
        Class cls = this.g;
        byte[] bytes = (byte[]) oqVar.a(cls);
        if (bytes == null) {
            bytes = cls.getName().getBytes(nl.f194a);
            oqVar.d(cls, bytes);
        }
        messageDigest.update(bytes);
        this.b.g(bArr);
    }

    @Override // a.nl
    public final boolean equals(Object obj) {
        if (obj instanceof sh) {
            sh shVar = (sh) obj;
            if (this.f == shVar.f && this.e == shVar.e && wh.b(this.i, shVar.i) && this.g.equals(shVar.g) && this.c.equals(shVar.c) && this.d.equals(shVar.d) && this.h.equals(shVar.h)) {
                return true;
            }
        }
        return false;
    }

    @Override // a.nl
    public final int hashCode() {
        int iHashCode = ((((this.d.hashCode() + (this.c.hashCode() * 31)) * 31) + this.e) * 31) + this.f;
        vo voVar = this.i;
        if (voVar != null) {
            iHashCode = (iHashCode * 31) + voVar.hashCode();
        }
        return this.h.b.hashCode() + ((this.g.hashCode() + (iHashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }
}
