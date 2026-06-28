package a;

import com.root4arab.wipass.MainActivity;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ou implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f219a;

    public /* synthetic */ ou(int i) {
        this.f219a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f219a) {
            case 0:
                xc xcVar = (xc) obj;
                xc xcVar2 = (xc) obj2;
                int i = MainActivity.u;
                boolean z = xcVar.f;
                return z != xcVar2.f ? z ? -1 : 1 : Integer.compare(xcVar2.c, xcVar.c);
            default:
                return ((Double) obj).compareTo((Double) obj2);
        }
    }
}
