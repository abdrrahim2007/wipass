package a;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class kt implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ku f154a;

    public kt(ku kuVar) {
        this.f154a = kuVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        ku kuVar = this.f154a;
        if (i == 1) {
            kuVar.b((kr) message.obj);
            return true;
        }
        if (i != 2) {
            return false;
        }
        kuVar.d.k((kr) message.obj);
        return false;
    }
}
