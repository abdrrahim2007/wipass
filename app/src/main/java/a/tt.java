package a;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class tt implements dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tw f303a;

    public tt(tw twVar) {
        this.f303a = twVar;
    }

    @Override // a.dw
    public final void a(boolean z) {
        ArrayList arrayList;
        wh.a();
        synchronized (this.f303a) {
            arrayList = new ArrayList((HashSet) this.f303a.d);
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((dw) obj).a(z);
        }
    }
}
