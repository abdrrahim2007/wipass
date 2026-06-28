package a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class od extends ci implements ni, jh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205a;

    public od(oe oeVar) {
        super(oeVar, pd.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f205a = false;
    }

    @Override // a.ci
    public final nc compute() {
        return this.f205a ? this : super.compute();
    }

    @Override // a.ci
    public final nc computeReflected() {
        rr.f274a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof od) {
            od odVar = (od) obj;
            return getOwner().equals(odVar.getOwner()) && getName().equals(odVar.getName()) && getSignature().equals(odVar.getSignature()) && mk.a(getBoundReceiver(), odVar.getBoundReceiver());
        }
        if (obj instanceof ni) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // a.ci
    public final nc getReflected() {
        if (this.f205a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        nc ncVarCompute = compute();
        if (ncVarCompute != this) {
            return (ni) ncVarCompute;
        }
        throw new es("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // a.jh
    public final Object invoke() {
        return this.receiver.getClass().getSimpleName();
    }

    public final String toString() {
        nc ncVarCompute = compute();
        if (ncVarCompute != this) {
            return ncVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
