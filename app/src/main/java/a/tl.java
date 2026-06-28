package a;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class tl implements Externalizable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractCollection f297a;
    public final int b;

    public tl(AbstractCollection abstractCollection, int i) {
        this.f297a = abstractCollection;
        this.b = i;
    }

    private final Object readResolve() {
        return this.f297a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        AbstractCollection abstractCollection;
        mk.h(objectInput, "input");
        byte b = objectInput.readByte();
        int i = b & 1;
        if ((b & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b) + '.');
        }
        int i2 = objectInput.readInt();
        if (i2 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i2 + '.');
        }
        int i3 = 0;
        if (i == 0) {
            ny nyVar = new ny(i2);
            while (i3 < i2) {
                nyVar.add(objectInput.readObject());
                i3++;
            }
            kz.a(nyVar);
            abstractCollection = nyVar;
        } else {
            if (i != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i + '.');
            }
            tn tnVar = new tn(i2);
            while (i3 < i2) {
                tnVar.add(objectInput.readObject());
                i3++;
            }
            pa paVar = tnVar.f299a;
            paVar.b();
            paVar.l = true;
            abstractCollection = tnVar;
        }
        this.f297a = abstractCollection;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        mk.h(objectOutput, "output");
        objectOutput.writeByte(this.b);
        objectOutput.writeInt(this.f297a.size());
        Iterator it = this.f297a.iterator();
        while (it.hasNext()) {
            objectOutput.writeObject(it.next());
        }
    }
}
