package a;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class hk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f116a;

    public hk(int i) {
        switch (i) {
            case 1:
                this.f116a = new ArrayList();
                break;
            case 2:
                this.f116a = new ArrayList();
                break;
            case 3:
                this.f116a = new ArrayList();
                break;
            default:
                this.f116a = new ArrayList();
                break;
        }
    }

    public synchronized sl a(Class cls) {
        int size = this.f116a.size();
        for (int i = 0; i < size; i++) {
            sm smVar = (sm) this.f116a.get(i);
            if (smVar.f283a.isAssignableFrom(cls)) {
                return smVar.b;
            }
        }
        return null;
    }

    public synchronized ArrayList b(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        ArrayList arrayList2 = this.f116a;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            vn vnVar = (vn) obj;
            if ((vnVar.f332a.isAssignableFrom(cls) && cls2.isAssignableFrom(vnVar.b)) && !arrayList.contains(vnVar.b)) {
                arrayList.add(vnVar.b);
            }
        }
        return arrayList;
    }
}
