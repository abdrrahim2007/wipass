package a;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class bw implements si {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f35a;
    public final gt b;

    public /* synthetic */ bw(gt gtVar, int i) {
        this.f35a = i;
        this.b = gtVar;
    }

    @Override // a.si
    public final sf a(Object obj, int i, int i2, qu quVar) {
        switch (this.f35a) {
            case 0:
                gt gtVar = this.b;
                return gtVar.a(new z((ByteBuffer) obj, gtVar.d, gtVar.c, 5), i, i2, quVar, gt.j);
            default:
                gt gtVar2 = this.b;
                return gtVar2.a(new z((ParcelFileDescriptor) obj, gtVar2.d, gtVar2.c), i, i2, quVar, gt.j);
        }
    }

    @Override // a.si
    public final boolean b(Object obj, qu quVar) {
        switch (this.f35a) {
            case 0:
                this.b.getClass();
                return true;
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
                String str = Build.MANUFACTURER;
                return (!("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) && !"robolectric".equals(Build.FINGERPRINT);
        }
    }
}
