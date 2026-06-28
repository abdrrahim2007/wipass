package a;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class tm implements Externalizable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pa f298a;

    private final Object readResolve() {
        return this.f298a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) throws IOException {
        mk.h(objectInput, "input");
        byte b = objectInput.readByte();
        if (b != 0) {
            throw new InvalidObjectException(pt.e("Unsupported flags value: ", b));
        }
        int i = objectInput.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Illegal size value: " + i + '.');
        }
        pa paVar = new pa(i);
        for (int i2 = 0; i2 < i; i2++) {
            paVar.put(objectInput.readObject(), objectInput.readObject());
        }
        paVar.b();
        paVar.l = true;
        this.f298a = paVar;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        mk.h(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.f298a.h);
        for (Map.Entry entry : (pb) this.f298a.entrySet()) {
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }
}
