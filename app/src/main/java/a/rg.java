package a;

import androidx.profileinstaller.DeviceProfileWriter;
import androidx.profileinstaller.ProfileInstaller;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rg implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f265a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ rg(Object obj, int i, Object obj2, int i2) {
        this.f265a = i2;
        this.b = obj;
        this.c = i;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f265a) {
            case 0:
                ((ProfileInstaller.DiagnosticsCallback) this.b).onResultReceived(this.c, this.d);
                break;
            case 1:
                ((ProfileInstaller.DiagnosticsCallback) this.b).onDiagnosticReceived(this.c, this.d);
                break;
            default:
                ((DeviceProfileWriter) this.b).lambda$result$0(this.c, this.d);
                break;
        }
    }
}
