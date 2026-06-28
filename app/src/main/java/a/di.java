package a;

/* JADX INFO: loaded from: classes.dex */
public final class di extends nm implements jw {
    public static final di b;
    public static final di c;
    public static final di d;
    public static final di e;
    public static final di f;
    public static final di g;
    public static final di h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f53a;

    static {
        int i = 2;
        b = new di(i, 0);
        c = new di(i, 1);
        d = new di(i, 2);
        e = new di(i, 3);
        f = new di(i, 4);
        g = new di(i, 5);
        h = new di(i, 6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ di(int i, int i2) {
        super(i);
        this.f53a = i2;
    }

    @Override // a.jw
    public final Object invoke(Object obj, Object obj2) {
        dk dkVar;
        switch (this.f53a) {
            case 0:
                String str = (String) obj;
                eg egVar = (eg) obj2;
                mk.h(str, "acc");
                mk.h(egVar, "element");
                if (str.length() == 0) {
                    return egVar.toString();
                }
                return str + ", " + egVar;
            case 1:
                ei eiVar = (ei) obj;
                eg egVar2 = (eg) obj2;
                mk.h(eiVar, "acc");
                mk.h(egVar2, "element");
                ei eiVarMinusKey = eiVar.minusKey(egVar2.getKey());
                hb hbVar = hb.f109a;
                if (eiVarMinusKey == hbVar) {
                    return egVar2;
                }
                ee eeVar = ee.b;
                ef efVar = (ef) eiVarMinusKey.get(eeVar);
                if (efVar == null) {
                    dkVar = new dk(eiVarMinusKey, egVar2);
                } else {
                    ei eiVarMinusKey2 = eiVarMinusKey.minusKey(eeVar);
                    if (eiVarMinusKey2 == hbVar) {
                        return new dk(egVar2, efVar);
                    }
                    dkVar = new dk(new dk(eiVarMinusKey2, egVar2), efVar);
                }
                return dkVar;
            case 2:
                return ((ei) obj).plus((eg) obj2);
            case 3:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 4:
                eg egVar3 = (eg) obj2;
                if (!(egVar3 instanceof ve)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? egVar3 : Integer.valueOf(iIntValue + 1);
            case 5:
                ve veVar = (ve) obj;
                eg egVar4 = (eg) obj2;
                if (veVar != null) {
                    return veVar;
                }
                if (egVar4 instanceof ve) {
                    return (ve) egVar4;
                }
                return null;
            case 6:
                return (vg) obj;
            default:
                return ((ei) obj).plus((eg) obj2);
        }
    }
}
