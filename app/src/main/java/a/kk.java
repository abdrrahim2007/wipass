package a;

/* JADX INFO: loaded from: classes.dex */
public final class kk implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kn f147a;

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final kk clone() {
        try {
            return (kk) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean b(Object obj) {
        if (obj instanceof kk) {
            return wh.b(this.f147a, ((kk) obj).f147a);
        }
        return false;
    }

    public final int c() {
        kn knVar = this.f147a;
        if (knVar != null) {
            return knVar.hashCode();
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof kk) && b(obj);
    }

    public final int hashCode() {
        return c();
    }
}
