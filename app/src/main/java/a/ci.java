package a;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ci implements nc, Serializable {
    public static final Object NO_RECEIVER = ch.f46a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient nc reflected;
    private final String signature;

    public ci(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // a.nc
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // a.nc
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public nc compute() {
        nc ncVar = this.reflected;
        if (ncVar != null) {
            return ncVar;
        }
        nc ncVarComputeReflected = computeReflected();
        this.reflected = ncVarComputeReflected;
        return ncVarComputeReflected;
    }

    public abstract nc computeReflected();

    @Override // a.nb
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public ne getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            rr.f274a.getClass();
            return new qv(cls);
        }
        rr.f274a.getClass();
        return new cw(cls);
    }

    @Override // a.nc
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract nc getReflected();

    @Override // a.nc
    public nj getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // a.nc
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // a.nc
    public nk getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // a.nc
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // a.nc
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // a.nc
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
