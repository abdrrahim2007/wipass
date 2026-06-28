package a;

/* JADX INFO: loaded from: classes.dex */
public abstract class kh extends ci implements kg, nf {
    private final int arity;
    private final int flags;

    public kh(int i, Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, false);
        this.arity = i;
        this.flags = 0;
    }

    @Override // a.ci
    public nc computeReflected() {
        rr.f274a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof kh) {
            kh khVar = (kh) obj;
            return getName().equals(khVar.getName()) && getSignature().equals(khVar.getSignature()) && this.flags == khVar.flags && this.arity == khVar.arity && mk.a(getBoundReceiver(), khVar.getBoundReceiver()) && mk.a(getOwner(), khVar.getOwner());
        }
        if (obj instanceof nf) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // a.kg
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // a.nf
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // a.nf
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // a.nf
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // a.nf
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // a.nf
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        nc ncVarCompute = compute();
        if (ncVarCompute != this) {
            return ncVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // a.ci
    public nf getReflected() {
        nc ncVarCompute = compute();
        if (ncVarCompute != this) {
            return (nf) ncVarCompute;
        }
        throw new es("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
